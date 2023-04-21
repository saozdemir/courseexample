package com.sao.homomorphic;


import com.n1analytics.paillier.*;

import java.math.BigInteger;

/**
 * @author saozd
 * @project com.sao.homomorphic courseexample
 * 18.04.2023 Nis 2023
 */
public class HomomorphicEncryption {
    public static void main(String[] args) {
        // Anahtar oluşturma
        PaillierPrivateKey privateKey = PaillierPrivateKey.create(1024);
        PaillierPublicKey publicKey = privateKey.getPublicKey();
        PaillierContext context = publicKey.createSignedContext();

        // Verilerin şifrelenmesi
        BigInteger a = BigInteger.valueOf(5);
        BigInteger b = BigInteger.valueOf(7);
        EncryptedNumber cipherTextA = context.encrypt(a);
        EncryptedNumber cipherTextB = context.encrypt(b);//.calculateCiphertext();

        // Şifrelenmiş verilerin toplanması
        EncryptedNumber cipherTextC = context.add(cipherTextA, cipherTextB);

        // Şifreli sonucun çözümlenmesi
        EncodedNumber result = privateKey.decrypt(cipherTextC);
        System.out.println("5 + 7 = " + result.getValue());

    }
}
