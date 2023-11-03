import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.students.ninjas.SecureIOStream;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class SecureIOStreamTest {
    private static final String TEST_FILE_PATH = "/Users/vetrov/IdeaProjects/java-training---gilat---miroslav-vetrov/test-hb-io-stream-security/src/main/resources/test.data";
    private static SecureIOStream secureIOStream;
    private static FileOutputStream outputStream;
    private static FileInputStream inputStream;
    private static Cipher encrypt;
    private static final SecretKey secretKey = new SecretKeySpec(new byte[]{-33, -57, 100, -43, 38, -116, 112, -43}, "DES");

    @BeforeEach
    public void clearFile() {
        try {
            encrypt = Cipher.getInstance("DES/ECB/PKCS5Padding");
            encrypt.init(Cipher.ENCRYPT_MODE, secretKey);

            outputStream = new FileOutputStream(TEST_FILE_PATH);
            inputStream = new FileInputStream(TEST_FILE_PATH);
            secureIOStream = new SecureIOStream(inputStream, outputStream);
            outputStream = new FileOutputStream(TEST_FILE_PATH);
        } catch (IOException e) {
            fail("Exception thrown while clearing file: " + e.getMessage());
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSecureIOStreamInitialization() {
        FileInputStream input = null;
        FileOutputStream output = null;
        try {
            input = new FileInputStream(TEST_FILE_PATH);
            output = new FileOutputStream(TEST_FILE_PATH);
            SecureIOStream secureIOStream = new SecureIOStream(input, output);
            assertNotNull(secureIOStream);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        } finally {
            try {
                if (input != null)
                    input.close();
                if (output != null)
                    output.close();
            } catch (IOException e) {
                fail("Exception thrown while closing streams: " + e.getMessage());
            }
        }
    }

    @Test
    public void testSendMethod() {
        try (FileInputStream inStream = new FileInputStream(TEST_FILE_PATH)) {

            secureIOStream.send(65);

            byte[] writtenData = inStream.readNBytes(inStream.available());
            byte[] encryptedData = encrypt.doFinal(new byte[]{65});

            assertNotNull(writtenData);
            assertEquals(encryptedData.length + 4, writtenData.length);

        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testReceiveMethod() {
        try (FileOutputStream outStream = new FileOutputStream(TEST_FILE_PATH)) {
            byte[] buffer = encrypt.doFinal(new byte[]{65});
            byte[] length = ByteBuffer.allocate(4).putInt(buffer.length).array();
            outStream.write(length);
            outStream.write(buffer);

            int receivedData = secureIOStream.receive();
            assertEquals(65, receivedData);

        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testEntireLogic() {
        byte[] array = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        byte[] result = new byte[8];
        for (int i = 0; i < array.length; i++) {
            try {
                secureIOStream.send(array[i]);
                result[i] = (byte) secureIOStream.receive();
            } catch (IOException e) {
                fail("Exception thrown: " + e.getMessage());
            }
        }
        assertArrayEquals(array, result);
    }
}
