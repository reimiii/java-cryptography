package franxx.code.cryptography.asymmetric;

import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Test;

import java.security.KeyPair;

import static org.junit.jupiter.api.Assertions.*;

class AsymmetricEncryptionUtilsTest {

  @Test
  void generateRSAKeyPair() throws Exception {
    KeyPair keyPair = AsymmetricEncryptionUtils.generateRSAKeyPair();
    assertNotNull(keyPair);
    System.out.println("Private key: " + DatatypeConverter.printHexBinary(keyPair.getPrivate().getEncoded()));
    System.out.println("Public key:  " + DatatypeConverter.printHexBinary(keyPair.getPublic().getEncoded()));
  }
}