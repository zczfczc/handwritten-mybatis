package com.zfc.mebatis;

/**
 * @auther:zfc
 * @Date:2022-08-02 19:30
 **/
public class ZfcSqlsession {
    // 配置类
    private ZfcConfiguration configuration;
    // 执行器
    private ZFcExecutor executor;

    /**
     * 调用执行器执行单条查询
     * @param statementId
     * @param parameter
     * @param <T>
     * @return
     */
    public <T> T selectOne(String statementId, Object parameter) {
        String sql = statementId;
        return executor.query(sql,parameter);
    }

}
