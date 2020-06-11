package com.lico.logback.crypt.encrypt;

import com.lico.logback.crypt.Constants;

/**
 * @author lico
 */
public enum EncryptKeyType {

    RSA(Constants.ENCRYPT_TYPE_RSA),
    RSA2(Constants.ENCRYPT_TYPE_RSA2),
    AES(Constants.ENCRYPT_TYPE_AES);

    private final String type;

    EncryptKeyType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
