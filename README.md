# logback-crypt
logback 数据加密库



### 使用方法

#### 方式一

1. 引入jar包

2. 修改logback配置

   - xml

     ```xml
     <?xml version="1.0" encoding="UTF-8"?>
     <configuration>
     	......
     	<conversionRule conversionWord="m" converterClass="com.lico.logback.crypt.encrypt.KeyEncryptMessageConverter"/>
       <conversionRule conversionWord="msg" converterClass="com.lico.logback.crypt.encrypt.KeyEncryptMessageConverter"/>
       <conversionRule conversionWord="message" converterClass="com.lico.logback.crypt.encrypt.KeyEncryptMessageConverter"/>
     	......
     </configuration>
     ```
     
     
     
   
3. 写入系统配置

   ```java
   System.setProperty("log.key.type", ""); // 加密类型
   System.setProperty("log.key.encKey", ""); // 加密key
   ```



#### 方式二

1. 引入jar包

2. 修改logback配置

   - xml

     ```xml
     <appender name="xxxx" class="ch.qos.logback.core.rolling.RollingFileAppender">
       <Encoding>UTF-8</Encoding>
       <layout class="com.lico.logback.crypt.encrypt.EncryptPatternLayout">
           <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS}|%m%n</pattern>
       </layout>
     </appender>
     
     或者
     
     <appender name="xxxx" class="ch.qos.logback.core.rolling.RollingFileAppender">
         <encoder class = "ch.qos.logback.classic.encoder.PatternLayoutEncoder">
             <layout class = "ch.qos.logback.classic.PatternLayout">
               <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS}|%m%n</pattern>
             </layout>
     </appender>
     ```

3. 写入系统配置

   ```java
   System.setProperty("log.key.type", ""); // 加密类型
   System.setProperty("log.key.encKey", ""); // 加密key
   ```

   

