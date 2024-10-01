package franxx.code.cryptography.hash;

import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class HashUtilsTest {

  @Test
  void generateRandomSalt() {
    byte[] salt = HashUtils.generateRandomSalt();
    assertNotNull(salt);
    System.out.println(DatatypeConverter.printHexBinary(salt));
    System.out.println(DatatypeConverter.printBase64Binary(salt));
  }

  @Test
  void createSHA2Hash() throws Exception {
    byte[] salt = HashUtils.generateRandomSalt();
    byte[] salt2 = HashUtils.generateRandomSalt();

    String valueToHash = UUID.randomUUID().toString();

    System.out.println(valueToHash);

    byte[] hash = HashUtils.createSHA2Hash(valueToHash, salt);
    byte[] hash2 = HashUtils.createSHA2Hash(valueToHash, salt);

    byte[] hash3 = HashUtils.createSHA2Hash(valueToHash, salt2);

    assertNotNull(hash);
    assertNotNull(hash2);

    System.out.println(DatatypeConverter.printHexBinary(hash));
    System.out.println(DatatypeConverter.printHexBinary(hash2));
    System.out.println(DatatypeConverter.printHexBinary(hash3));

    assertEquals(
        DatatypeConverter.printHexBinary(hash),
        DatatypeConverter.printHexBinary(hash2)
    );

    assertNotEquals(
        DatatypeConverter.printHexBinary(hash3),
        DatatypeConverter.printHexBinary(hash2)
    );

  }

  @Test
  void testPasswordRoutine() {
    String secretPhrase = "correct horse battery staple";
    String passwordHash = HashUtils.hashPassword(secretPhrase);
    System.out.println(passwordHash);
    assertTrue(HashUtils.verifyPassord(secretPhrase, passwordHash));
  }
}