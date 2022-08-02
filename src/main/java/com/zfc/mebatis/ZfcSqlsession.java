package com.zfc.mebatis;

/**
 * @auther:zfc
 * @Date:2022-08-02 19:30
 **/
public class ZfcSqlsession {
    // 配置类对象
    private ZfcConfiguration configuration;
    // 执行器对象
    private ZFcExecutor executor;

    public ZfcSqlsession(ZfcConfiguration configuration, ZFcExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    /**
     * 调用执行器执行单条查询
     * @param statementId
     * @param parameter
     * @param <T>
     * @return
     */
    public <T> T selectOne(String statementId, Object parameter) {
        String sql = ZfcConfiguration.sqlMappings.getString(statementId);
        return executor.query(sql,parameter);
    }

    /**
     * 获取一个代理对象
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class clazz){
        return configuration.getMapper(clazz,this);
    }

}
