package franxx.code.cryptography.asymmetric;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

public class AsymmetricEncryptionUtils {
  /**
   * Identifier algoritma RSA.
   * Digunakan sebagai nama algoritma saat menginisialisasi operasi kriptografi.
   */
  private static final String RSA = "RSA";

  /**
   * Menghasilkan pasangan kunci RSA untuk enkripsi asimetris.
   * <p>
   * RSA digunakan untuk enkripsi asimetris, yang artinya menggunakan dua kunci:
   * satu kunci publik dan satu kunci privat. Metode ini membuat kedua kunci
   * tersebut dan mengembalikannya dalam bentuk objek KeyPair.
   *
   * @return objek {@code KeyPair} yang berisi kunci publik dan privat yang dihasilkan.
   * @throws Exception jika terjadi masalah saat menghasilkan pasangan kunci RSA.
   */
  public static KeyPair generateRSAKeyPair() throws Exception {
    SecureRandom secureRandom = new SecureRandom();
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
    keyPairGenerator.initialize(4096, secureRandom);

    return keyPairGenerator.generateKeyPair();
  }
}
