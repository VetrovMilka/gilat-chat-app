package org.students.ninjas;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


//TODO DES algorithm one hardcoded key -> encrypt 1 byte and send it
//TODO DES algorithm one hardcoded key -> receive 1 byte and decrypt it
public class SecureIOStream extends IOStream {
    //    private OutputStream bOut;
//    private InputStream bIn;
    private static Cipher encrypt;
    private static Cipher decrypt;
    private final FileInputStream fIn;
    private final FileOutputStream fOut;

    public SecureIOStream(FileInputStream fIn, FileOutputStream fOut) {
        super();
        this.fIn = fIn;
        this.fOut = fOut;
        try {
            SecretKey secretKey = SecretKeyHolder.SECRET_KEY_HOLDER;
            decrypt = Cipher.getInstance("DES/ECB/PKCS5Padding");
            encrypt = Cipher.getInstance("DES/ECB/PKCS5Padding");
            encrypt.init(Cipher.ENCRYPT_MODE, secretKey);
            decrypt.init(Cipher.DECRYPT_MODE, secretKey);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void send(int value) throws IOException {
        byte[] buffer;
        try {
            buffer = encrypt.doFinal(new byte[]{(byte) value});
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException(e);
        }
        byte[] length = ByteBuffer.allocate(4).putInt(buffer.length).array();
        this.fOut.write(length);
        this.fOut.write(buffer);
        this.fOut.flush();
    }

    //TODO
    @Override
    public int receive() {
        try {
            DataInputStream dataInputStream = new DataInputStream(fIn);
            int length = dataInputStream.readInt();
            byte[] buffer = dataInputStream.readNBytes(length);
            buffer = decrypt.doFinal(buffer);
            return buffer[0];
        } catch (IOException e) {
            return -1;
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }
}
