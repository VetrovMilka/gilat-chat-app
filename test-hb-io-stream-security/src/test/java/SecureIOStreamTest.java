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
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class SecureIOStreamTest {
    private static final String TEST_FILE_PATH = "src/main/resources/test.data";
    private static SecureIOStream secureIOStream;
    private static final SecretKey secretKey = new SecretKeySpec(new byte[]{-33, -57, 100, -43, 38, -116, 112, -43}, "DES");

    @BeforeEach
    public void clearFile() {
        try {
            Cipher encrypt = Cipher.getInstance("DES/CTR/PKCS5Padding");
            encrypt.init(Cipher.ENCRYPT_MODE, secretKey);

            FileOutputStream outputStream = new FileOutputStream(TEST_FILE_PATH);
            FileInputStream inputStream = new FileInputStream(TEST_FILE_PATH);
            secureIOStream = new SecureIOStream(inputStream, outputStream);
        } catch (IOException e) {
            fail("Exception thrown while clearing file: " + e.getMessage());
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSendMethod() {
        try (FileInputStream inStream = new FileInputStream(TEST_FILE_PATH)) {

            secureIOStream.send(65);

            byte[] writtenData = inStream.readNBytes(inStream.available());
            byte[] encryptedData = secureIOStream.encrypt(new byte[]{65});

            assertNotNull(writtenData);
            assertEquals(encryptedData.length + 4, writtenData.length);

        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testReceiveMethod() {
        secureIOStream.send(65);
        int receivedData = secureIOStream.receive();
        assertEquals(65, receivedData);
    }

    @Test
    public void testEntireLogic() {
        byte[] array = new byte[8];
        new Random().nextBytes(array);
        byte[] result = new byte[8];
        for (int i = 0; i < array.length; i++) {
            secureIOStream.send(array[i]);
            result[i] = (byte) secureIOStream.receive();
        }
        assertArrayEquals(array, result);
    }
}
