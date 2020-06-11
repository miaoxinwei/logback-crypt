package com.lico.logback.crypt.utils.asymmetric;


import com.lico.logback.crypt.exception.EncryptionException;

/**
 * 非对称加密算法 接口类
 */
public interface IAsymmetricEncryptor {

    /**
     * 计算指定内容的签名
     *
     * @param content    待签名的原文
     * @param charset    待签名的原文的字符集编码
     * @param privateKey 私钥字符串
     * @return 签名字符串
     */
    String sign(String content, String charset, String privateKey) throws EncryptionException;

    /**
     * 验证指定内容的签名是否正确
     *
     * @param content   待校验的原文
     * @param charset   待校验的原文的字符集编码
     * @param publicKey 公钥字符串
     * @param sign      签名字符串
     * @return true：验证通过；false：验证不通过
     */
    boolean verify(String content, String charset, String publicKey, String sign) throws EncryptionException;

    /**
     * 对明文进行非对称加密
     *
     * @param plainText 明文字符串
     * @param charset   明文的字符集编码
     * @param publicKey 公钥字符串
     * @return 密文的Base64编码字符串
     */
    String encrypt(String plainText, String charset, String publicKey) throws EncryptionException;

    /**
     * 对密文进行非对称解密
     *
     * @param cipherTextBase64 密文Base64编码字符串
     * @param charset          明文的字符集编码
     * @param privateKey       私钥字符串
     * @return 明文
     */
    String decrypt(String cipherTextBase64, String charset, String privateKey) throws EncryptionException;

}