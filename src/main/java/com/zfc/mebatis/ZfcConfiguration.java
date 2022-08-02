package com.zfc.mebatis;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/**
 * 配置类
 *
 * @auther:zfc
 * @Date:2022-08-02 19:32
 **/
@SuppressWarnings("all") // 单纯看到警告不舒服
public class ZfcConfiguration {

    public final static ResourceBundle sqlMappings;

    static {
        sqlMappings = ResourceBundle.getBundle("mesql");
    }

    /**
     * 返回接口的代理对象
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class clazz, ZfcSqlsession sqlsession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, new ZfcMapperProxy(sqlsession));
    }
}
