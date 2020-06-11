package com.lico.logback.crypt.utils.asymmetric;


import com.lico.logback.crypt.Constants;
import com.lico.logback.crypt.exception.EncryptionException;

/**
 * 非对称加密算法管理类
 */
public class AsymmetricManager {

    private static final RSAEncryptor rsaEncryptor = new RSAEncryptor();
    private static final RSA2Encryptor rsa2Encryptor = new RSA2Encryptor();

    public static IAsymmetricEncryptor getByName(String type) throws EncryptionException {
        if (Constants.ENCRYPT_TYPE_RSA.equals(type)) {
            return rsaEncryptor;
        }
        if (Constants.ENCRYPT_TYPE_RSA2.equals(type)) {
            return rsa2Encryptor;
        }
        throw new EncryptionException("无效的非对称加密类型:[\" + type + \"]，可选值为：RSA、RSA2和AES。");
    }

}