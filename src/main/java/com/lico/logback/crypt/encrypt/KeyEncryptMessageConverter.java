package com.lico.logback.crypt.encrypt;


import com.lico.logback.crypt.Properties;
import com.lico.logback.crypt.exception.EncryptionException;
import com.lico.logback.crypt.utils.AESEncryptor;
import com.lico.logback.crypt.utils.StringUtils;
import com.lico.logback.crypt.utils.asymmetric.AsymmetricManager;

import java.lang.invoke.MethodHandles;
import java.nio.charset.StandardCharsets;


public class KeyEncryptMessageConverter extends AbstractEncryptMessageConverter {

    private static final String name = MethodHandles.lookup().lookupClass().getSimpleName();

    // 脱敏值#加密值#密匙类型#密匙
    private final String keyEncFormat;
    // 加密类型枚举
    private final EncryptKeyType typeEnum;
    // 加密KEY
    private final String encKey;

    public KeyEncryptMessageConverter() {
        String type = System.getProperty(Properties.LOG_KEY_TYPE);
        if (StringUtils.isEmpty(type)) {
            throw new NullPointerException("type cannot be null or empty");
        }
        typeEnum = EncryptKeyType.valueOf(type);

        encKey = System.getProperty(Properties.LOG_KEY_ENCKEY);
        if (StringUtils.isEmpty(encKey)) {
            throw new NullPointerException("encKey cannot be null or empty");
        }
        keyEncFormat = ENC_FORMAT.replace(ENC_FORMAT_KEY, typeEnum.name());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String encrypt(String val) throws EncryptionException {
        String encVal;
        if (typeEnum == EncryptKeyType.AES) {
            encVal = AESEncryptor.encrypt(val, encKey, StandardCharsets.UTF_8.displayName());
        } else {
            encVal = AsymmetricManager.getByName(typeEnum.getType()).encrypt(val, StandardCharsets.UTF_8.displayName(), encKey);
        }

        return String.format(keyEncFormat, encKey, encVal);
    }

}
