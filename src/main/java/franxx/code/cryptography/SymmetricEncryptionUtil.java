package franxx.code.cryptography;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

public class SymmetricEncryptionUtil {

    // Enkripsi yang pake kunci yang sama buat enkripsi dan dekripsi
    private static final String AES = "AES";

    // membuat key udh di buat key nya... sekarang tinggal encrypt some data
    public static SecretKey createAESKey() throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
        keyGenerator.init(256, secureRandom);

        return keyGenerator.generateKey();
    }
}
