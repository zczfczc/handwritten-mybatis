package com.zfc.mebatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * jdk代理类实现类
 *
 * @auther:zfc
 * @Date:2022-08-02 19:50
 **/
public class ZfcMapperProxy implements InvocationHandler {

    private ZfcSqlsession sqlsession;

    public ZfcMapperProxy(ZfcSqlsession sqlsession) {
        this.sqlsession = sqlsession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String statementId = method.getDeclaringClass().getName() + "." + method.getName();
        return sqlsession.selectOne(statementId, args[0]);
    }
}
