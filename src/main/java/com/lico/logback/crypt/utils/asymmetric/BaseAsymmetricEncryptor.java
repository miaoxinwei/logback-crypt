package com.lico.logback.crypt.utils.asymmetric;


import com.lico.logback.crypt.exception.EncryptionException;
import com.lico.logback.crypt.utils.StringUtils;

/**
 * 非对称加密算法
 */
public abstract class BaseAsymmetricEncryptor implements IAsymmetricEncryptor {

    //默认字符集编码。现在推荐使用UTF-8，之前默认是GBK
    private static final String DEFAULT_CHARSET = "UTF-8";

    public String decrypt(String cipherTextBase64, String charset, String privateKey) throws EncryptionException {
        try {
            if (StringUtils.isEmpty(cipherTextBase64)) {
                throw new EncryptionException("密文不可为空");
            }
            if (StringUtils.isEmpty(privateKey)) {
                throw new EncryptionException("私钥不可为空");
            }
            if (StringUtils.isEmpty(charset)) {
                charset = DEFAULT_CHARSET;
            }
            return doDecrypt(cipherTextBase64, charset, privateKey);

        } catch (Exception e) {

            String errorMessage = getAsymmetricType() + "非对称解密遭遇异常，请检查私钥格式是否正确。" + e.getMessage() +
                    " cipherTextBase64=" + cipherTextBase64 + "，charset=" + charset + "，privateKeySize=" + privateKey.length();
            throw new EncryptionException(errorMessage, e);
        }

    }

    public String encrypt(String plainText, String charset, String publicKey) throws EncryptionException {
        try {
            if (StringUtils.isEmpty(plainText)) {
                throw new EncryptionException("密文不可为空");
            }
            if (StringUtils.isEmpty(publicKey)) {
                throw new EncryptionException("公钥不可为空");
            }
            if (StringUtils.isEmpty(charset)) {
                charset = DEFAULT_CHARSET;
            }
            return doEncrypt(plainText, charset, publicKey);
        } catch (Exception e) {

            String errorMessage = getAsymmetricType() + "非对称解密遭遇异常，请检查公钥格式是否正确。" + e.getMessage() +
                    " plainText=" + plainText + "，charset=" + charset + "，publicKey=" + publicKey;
            throw new EncryptionException(errorMessage, e);
        }

    }

    public String sign(String content, String charset, String privateKey) throws EncryptionException {
        try {
            if (StringUtils.isEmpty(content)) {
                throw new EncryptionException("待签名内容不可为空");
            }
            if (StringUtils.isEmpty(privateKey)) {
                throw new EncryptionException("私钥不可为空");
            }
            if (StringUtils.isEmpty(charset)) {
                charset = DEFAULT_CHARSET;
            }
            return doSign(content, charset, privateKey);
        } catch (Exception e) {

            String errorMessage = getAsymmetricType() + "签名遭遇异常，请检查私钥格式是否正确。" + e.getMessage() +
                    " content=" + content + "，charset=" + charset + "，privateKeySize=" + privateKey.length();
            throw new EncryptionException(errorMessage, e);
        }

    }

    public boolean verify(String content, String charset, String publicKey, String sign) throws EncryptionException {
        try {
            if (StringUtils.isEmpty(content)) {
                throw new EncryptionException("待验签内容不可为空");
            }
            if (StringUtils.isEmpty(publicKey)) {
                throw new EncryptionException("公钥不可为空");
            }
            if (StringUtils.isEmpty(sign)) {
                throw new EncryptionException("签名串不可为空");
            }
            if (StringUtils.isEmpty(charset)) {
                charset = DEFAULT_CHARSET;
            }
            return doVerify(content, charset, publicKey, sign);
        } catch (Exception e) {

            String errorMessage = getAsymmetricType() + "验签遭遇异常，请检查公钥格式是否正确。" + e.getMessage() +
                    " content=" + content + "，charset=" + charset + "，publicKey=" + publicKey;
            throw new EncryptionException(errorMessage, e);
        }
    }

    protected abstract String doDecrypt(String cipherTextBase64, String charset, String privateKey) throws Exception;

    protected abstract String doEncrypt(String plainText, String charset, String publicKey) throws Exception;

    protected abstract String doSign(String content, String charset, String privateKey) throws Exception;

    protected abstract boolean doVerify(String content, String charset, String publicKey, String sign) throws Exception;

    protected abstract String getAsymmetricType();

}