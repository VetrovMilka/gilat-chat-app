package org.students.ninjas.encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Encryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KeyPair keyPair = null;
        String sourceDir = "encryption/src/main/resources/";

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Generate & Save New Keys");
            System.out.println("2. Store an Encrypted Message");
            System.out.println("3. Load an Encrypted Message");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    try {
                        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
                        keyPairGenerator.initialize(512);
                        keyPair = keyPairGenerator.generateKeyPair();

                        saveKey(keyPair.getPublic(), sourceDir + "publicKey.txt");
                        saveKey(keyPair.getPrivate(), sourceDir + "privateKey.txt");

                        System.out.println("Keys generated and saved successfully.");
                    } catch (NoSuchAlgorithmException | IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    if (keyPair == null) {
                        System.out.println("Please generate keys first.");
                        break;
                    }
                    try {
                        System.out.println("Enter the message to encrypt:");
                        String message = scanner.nextLine();

                        Cipher cipher = Cipher.getInstance("RSA");
                        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
                        byte[] encryptedBytes = cipher.doFinal(message.getBytes());

                        FileOutputStream outputStream = new FileOutputStream(sourceDir + "encrypted_message.txt");
                        outputStream.write(encryptedBytes);
                        outputStream.close();

                        System.out.println("Message encrypted and stored.");
                    } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                             IllegalBlockSizeException | BadPaddingException | IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    if (keyPair == null) {
                        System.out.println("Please generate keys first.");
                        break;
                    }
                    try(FileInputStream inputStream = new FileInputStream(sourceDir + "encrypted_message.txt")) {
                        byte[] encryptedData = inputStream.readAllBytes();

                        Cipher cipher = Cipher.getInstance("RSA");
                        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
                        byte[] decryptedBytes = cipher.doFinal(encryptedData);

                        System.out.println("Decrypted message:");
                        System.out.println(new String(decryptedBytes));
                    } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                             IllegalBlockSizeException | BadPaddingException | IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    private static void saveKey(Key key, String fileName) throws IOException {
        byte[] keyBytes = key.getEncoded();
        FileOutputStream outputStream = new FileOutputStream(fileName);
        outputStream.write(keyBytes);
        outputStream.close();
    }
}