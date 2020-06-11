package com.lico.logback.crypt.encrypt;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.lico.logback.crypt.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.regex.Pattern;

/**
 * @author lico
 */
public abstract class AbstractEncryptMessageConverter extends MessageConverter {

    protected static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    protected static final Pattern PATTERN = Pattern.compile("(ENC\\([\\s\\S]+\\))");

    protected static final String ENC_FORMAT_KEY = "TYPE";
    // 密匙类型#密匙#加密值
    protected static final String ENC_FORMAT = ENC_FORMAT_KEY + "#%s#%s";

    @Override
    public String convert(ILoggingEvent event) {
        String msg = event.getFormattedMessage();
        if (StringUtils.isEmpty(msg)) {
            return msg;
        }
        try {
            String[] msgArr = msg.split("\\|");
            StringBuilder sb = new StringBuilder();
            for (String val : msgArr) {
                val = val.trim();
                if (PATTERN.matcher(val).matches()) {
                    val = encrypt(val);
                }
                sb.append(val).append("|");
            }

            return sb.substring(0, sb.length() - 1);
        } catch (Exception e) {
            logger.error(getName() + " convert error", e);
            return "";
        }
    }

    public abstract String getName();

    public abstract String encrypt(String val) throws Exception;

}
