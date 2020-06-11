package com.lico.logback.crypt.encrypt;

import ch.qos.logback.classic.PatternLayout;

/**
 * @author lico
 */
public class EncryptPatternLayout extends PatternLayout {
    static {
        defaultConverterMap.put("m", KeyEncryptMessageConverter.class.getName());
        defaultConverterMap.put("msg", KeyEncryptMessageConverter.class.getName());
        defaultConverterMap.put("message", KeyEncryptMessageConverter.class.getName());
    }
}
