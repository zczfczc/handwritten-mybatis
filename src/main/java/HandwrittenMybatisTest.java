import com.zfc.mebatis.ZFcExecutor;
import com.zfc.mebatis.ZfcConfiguration;
import com.zfc.mebatis.ZfcSqlsession;
import com.zfc.mebatis.mapper.UserMapper;

/**
 * @auther:zfc
 * @Date:2022-08-02 19:27
 **/
public class HandwrittenMybatisTest {
    public static void main(String[] args) {
        ZfcSqlsession sqlsession = new ZfcSqlsession(new ZfcConfiguration(), new ZFcExecutor());
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        mapper.selectUserById(1);
    }
}
