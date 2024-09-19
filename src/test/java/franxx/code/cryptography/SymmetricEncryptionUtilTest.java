package franxx.code.cryptography;

import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.util.Arrays;

import static jakarta.xml.bind.DatatypeConverter.printBase64Binary;
import static jakarta.xml.bind.DatatypeConverter.printHexBinary;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SymmetricEncryptionUtilTest {

  @Test
  void createAESKey() throws Exception {
    SecretKey secretKey = SymmetricEncryptionUtil.createAESKey();
    assertNotNull(secretKey);
    System.out.println(printHexBinary(secretKey.getEncoded()));
  }

  @Test
  void testInitVector() {
    for (int i = 0; i < 5; i++) {
      byte[] bytes = SymmetricEncryptionUtil.createInitVector();
      System.out.println(Arrays.toString(bytes));
    }
  }

  @Test
  void testAESCryptoRoutine() throws Exception {
    SecretKey key = SymmetricEncryptionUtil.createAESKey();
    System.out.println("secret key: " + printHexBinary(key.getEncoded()));

    byte[] initVector = SymmetricEncryptionUtil.createInitVector();
    System.out.println("Init Vector: " + printHexBinary(initVector));

    String plainText = "this is text mana ada lahh...";
    byte[] cipherText = SymmetricEncryptionUtil.performAESEncryption(
        plainText, key, initVector
    );

    assertNotNull(cipherText);
    String hexBinary = printHexBinary(cipherText);
    String base64Binary = printBase64Binary(cipherText);
    System.out.println("hex: " + hexBinary);
    System.out.println("base64: " + base64Binary);

    String decryption = SymmetricEncryptionUtil.performAESDecryption(cipherText, key, initVector);

    assertEquals(plainText, decryption);

    System.out.println("decryption: " + decryption);
  }
}