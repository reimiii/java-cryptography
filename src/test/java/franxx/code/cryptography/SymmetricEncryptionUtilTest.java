package franxx.code.cryptography;

import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;

import static org.junit.jupiter.api.Assertions.*;

class SymmetricEncryptionUtilTest {

    @Test
    void createAESKey() throws Exception {
        SecretKey secretKey = SymmetricEncryptionUtil.createAESKey();
        assertNotNull(secretKey);
        System.out.println(DatatypeConverter.printHexBinary(secretKey.getEncoded()));
    }
}