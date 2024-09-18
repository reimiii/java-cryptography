Kriptografi itu cara buat nyembunyiin atau ngamanin informasi biar nggak bisa dibaca orang lain yang nggak punya kunci khusus. Intinya, data diacak pake metode tertentu (enkripsi) dan cuma bisa dibalikin lagi (dekripsi) sama yang punya kunci buat ngebukanya. Dipakai buat jaga privasi, misal di chatting, transaksi online, atau password.

---

Berikut glossary kriptografi yang lengkap:

1. **Plaintext**: Pesan asli sebelum dienkripsi (teks biasa).
2. **Ciphertext**: Pesan yang udah dienkripsi dan diacak jadi nggak bisa dibaca.
3. **Enkripsi (Encryption)**: Proses ngacak plaintext jadi ciphertext.
4. **Dekripsi (Decryption)**: Proses balikkin ciphertext jadi plaintext.
5. **Kunci (Key)**: Informasi rahasia buat enkripsi dan dekripsi.
6. **Algoritma**: Metode atau rumus buat enkripsi dan dekripsi (contoh: AES, RSA).
7. **Hashing**: Ubah data jadi kode tetap (hash) buat verifikasi, nggak bisa dibalik.
8. **Salt**: Data acak yang ditambahin ke password sebelum di-hash, buat bikin hash lebih aman dan unik.
9. **Symmetric Key**: Enkripsi yang pake kunci yang sama buat enkripsi dan dekripsi.
10. **Asymmetric Key**: Enkripsi yang pake kunci berbeda: satu buat enkripsi (public key) dan satu buat dekripsi (private key).
11. **Digital Signature**: Tanda tangan elektronik buat validasi keaslian dan integritas data.
12. **Certificate Authority (CA)**: Pihak yang ngeluarin sertifikat digital buat verifikasi identitas di internet.

Itu istilah penting yang sering dipakai di dunia kriptografi.

---
Di dunia kriptografi, ada beberapa fungsi penting yang sering dipakai buat ngamanin data. Berikut beberapa **functions** yang umum digunakan:

1. **Encryption Function**:
    - Fungsi buat ngubah plaintext jadi ciphertext.
    - Contoh: AES (Advanced Encryption Standard), RSA (Rivest-Shamir-Adleman).

2. **Decryption Function**:
    - Kebalikannya enkripsi, fungsi ini ngubah ciphertext balik lagi jadi plaintext.
    - Contoh: Fungsi RSA decryption, AES decryption.

3. **Hashing Function**:
    - Fungsi buat ngubah data jadi nilai hash tetap yang unik. Biasanya dipakai buat cek integritas data atau nyimpen password dengan aman.
    - Contoh: SHA-256 (Secure Hash Algorithm 256-bit), MD5 (meski udah dianggap kurang aman).

4. **Key Derivation Function (KDF)**:
    - Fungsi buat ngenerate kunci dari password atau input lain dengan proses yang lebih aman. KDF biasanya pake **salt** biar lebih aman.
    - Contoh: PBKDF2 (Password-Based Key Derivation Function 2), bcrypt, scrypt.

5. **Digital Signature Function**:
    - Fungsi buat bikin tanda tangan elektronik yang dipakai buat validasi keaslian data. Tanda tangan ini dibikin dengan kunci pribadi dan bisa dicek sama orang lain dengan kunci publik.
    - Contoh: DSA (Digital Signature Algorithm), RSA signature.

6. **Random Number Generation (RNG)**:
    - Fungsi ini buat bikin angka acak yang dipakai di banyak algoritma kriptografi, seperti bikin **salt**, kunci enkripsi, atau nonce.
    - Contoh: CSPRNG (Cryptographically Secure Pseudo-Random Number Generator).

7. **MAC (Message Authentication Code)**:
    - Fungsi buat verifikasi integritas dan keaslian pesan. MAC ngasih semacam "kode autentikasi" buat ngecek apakah pesan diubah atau nggak selama perjalanan.
    - Contoh: HMAC (Hash-based Message Authentication Code).

Fungsi-fungsi ini sering dipakai di berbagai aplikasi, mulai dari enkripsi data, keamanan password, sampai validasi integritas pesan di jaringan internet.