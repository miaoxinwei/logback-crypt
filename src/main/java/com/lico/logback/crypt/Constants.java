package com.lico.logback.crypt;

/**
 * @author lico
 */
public class Constants {

    public static final String ENCRYPT_TYPE_KMS = "KMS";

    public static final String ENCRYPT_TYPE_RSA = "RSA";

    /**
     * sha256WithRsa 算法请求类型
     */
    public static final String ENCRYPT_TYPE_RSA2 = "RSA2";

    public static final String ENCRYPT_TYPE_AES = "AES";

    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    public static final String SIGN_SHA256RSA_ALGORITHMS = "SHA256WithRSA";

    // 加密后 分界符
    public static final String MSG_DELIM_STR = "#";

}
