import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2019/8/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class testspringredis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testsetredis(){

        redisTemplate.opsForValue().set("name_redis","jack");
        System.out.println("name_redis:  "+redisTemplate.opsForValue().get("name_redis"));
    }
}
