package franxx.code.cryptography.symmetric;

import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.util.Arrays;

import static jakarta.xml.bind.DatatypeConverter.printBase64Binary;
import static jakarta.xml.bind.DatatypeConverter.printHexBinary;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SymmetricEncryptionUtilsTest {

  @Test
  void createAESKey() throws Exception {
    SecretKey secretKey = SymmetricEncryptionUtils.createAESKey();
    assertNotNull(secretKey);
    System.out.println(printHexBinary(secretKey.getEncoded()));
  }

  @Test
  void testInitVector() {
    for (int i = 0; i < 5; i++) {
      byte[] bytes = SymmetricEncryptionUtils.createInitVector();
      System.out.println(Arrays.toString(bytes));
    }
  }

  @Test
  void testAESCryptoRoutine() throws Exception {
    SecretKey key = SymmetricEncryptionUtils.createAESKey();
    System.out.println("secret key: " + printHexBinary(key.getEncoded()));

    byte[] initVector = SymmetricEncryptionUtils.createInitVector();
    System.out.println("Init Vector: " + printHexBinary(initVector));

    String plainText = "this is text mana ada lahh...";
    byte[] cipherText = SymmetricEncryptionUtils.performAESEncryption(
        plainText, key, initVector
    );

    assertNotNull(cipherText);
    String hexBinary = printHexBinary(cipherText);
    String base64Binary = printBase64Binary(cipherText);
    System.out.println("hex: " + hexBinary);
    System.out.println("base64: " + base64Binary);

    String decryption = SymmetricEncryptionUtils.performAESDecryption(
        cipherText, key, initVector
    );

    assertEquals(plainText, decryption);

    System.out.println("decryption: " + decryption);
  }
}