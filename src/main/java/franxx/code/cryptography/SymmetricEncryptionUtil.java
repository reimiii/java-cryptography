package franxx.code.cryptography;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class SymmetricEncryptionUtil {

  // Enkripsi yang pake kunci yang sama buat enkripsi dan dekripsi
  private static final String AES = "AES";

  // bikin cipher buat enkripsi atau dekripsi dengan algo AES
  /**
   * PKCS5Padding nambahin byte ke data yang panjangnya nggak pas biar AES
   * bisa enkripsi data dengan benar.
   */
  private static final String AES_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";

  // membuat key udh di buat key nya... sekarang tinggal encrypt some data
  public static SecretKey createAESKey() throws Exception {
    SecureRandom secureRandom = new SecureRandom();
    KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
    keyGenerator.init(256, secureRandom);

    return keyGenerator.generateKey();
  }

  /**
   * IV dibutuhkan di mode CBC untuk memastikan blok pertama enkripsi aman dan
   * nggak ada pola yang bisa ditebak,
   * serta memastikan hasil enkripsi jadi random dan unik,
   * meskipun data yang dienkripsi sama. Kalau nggak pakai IV,
   * enkripsi di CBC bakal jauh lebih gampang ditebak sama attacker.
   * 16-byte == 128-bit
   */
  public static byte[] createInitVector() {
    byte[] initVector = new byte[16];
    SecureRandom secureRandom = new SecureRandom();
    secureRandom.nextBytes(initVector);
    return initVector;
  }

  /**
   * Melakukan enkripsi teks menggunakan AES dengan mode CBC dan padding PKCS5.
   * <p>
   * 1. Buat objek Cipher dengan algoritma AES/CBC/PKCS5Padding.
   * - PKCS5Padding otomatis digunakan untuk menambah padding jika data tidak pas dengan panjang blok AES (16 byte).
   * 2. Buat IvParameterSpec dari initVector.
   * - IV diperlukan oleh mode CBC sebagai blok awal untuk memulai proses enkripsi.
   * 3. Inisialisasi Cipher untuk mode enkripsi dengan secretKey dan IV.
   * 4. Enkripsi plainText (konversi ke byte UTF-8) dan kembalikan hasilnya.
   *
   * @param plainText  Teks yang akan dienkripsi
   * @param secretKey  Kunci rahasia AES yang digunakan untuk enkripsi
   * @param initVector Vektor inisialisasi (IV) untuk enkripsi CBC
   * @return byte[]    Hasil enkripsi dalam bentuk byte array
   * @throws Exception Jika terjadi kesalahan selama proses enkripsi
   */
  public static byte[] performAESEncryption(
      String plainText,
      SecretKey secretKey,
      byte[] initVector
  ) throws Exception {
    Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
    IvParameterSpec ivParameterSpec = new IvParameterSpec(initVector);
    cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

    return cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
  }

  /**
   * Melakukan dekripsi teks menggunakan AES dengan mode CBC dan padding PKCS5.
   * <p>
   * Proses dekripsi ini mengharuskan penggunaan IV (Initialization Vector) yang
   * sama seperti saat enkripsi, karena mode CBC membutuhkan blok awal untuk
   * memulai dekripsi. Hasil dekripsi akan dikembalikan dalam bentuk teks asli.
   * <p>
   * Langkah-langkah:
   * 1. Buat objek Cipher dengan algoritma AES/CBC/PKCS5Padding.
   * 2. Buat IvParameterSpec dari initVector yang digunakan untuk mode CBC.
   * 3. Inisialisasi Cipher untuk mode DECRYPT_MODE dengan secretKey dan IV.
   * 4. Dekripsi cipherText dan konversikan hasil byte ke string (plaintext).
   *
   * @param cipherText Data terenkripsi (ciphertext) yang akan didekripsi
   * @param secretKey  Kunci rahasia AES yang digunakan untuk dekripsi
   * @param initVector Vektor inisialisasi (IV) yang digunakan untuk dekripsi CBC
   * @return String     Hasil dekripsi berupa teks asli (plaintext)
   * @throws Exception Jika terjadi kesalahan selama proses dekripsi
   */
  public static String performAESDecryption(
      byte[] cipherText,
      SecretKey secretKey,
      byte[] initVector
  ) throws Exception {

    Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
    IvParameterSpec ivParameterSpec = new IvParameterSpec(initVector);
    cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

    byte[] result = cipher.doFinal(cipherText);

    return new String(result);
  }
}
