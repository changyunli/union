import com.union.dao.UserMapper;
import com.union.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2019/7/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class MybatisTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){

        List<User> userList=userMapper.queryUserAll();

        System.out.println("userList  "+userList);
        System.out.println(userList.getClass().getName());
        System.out.println("=====================================");

    }
}
