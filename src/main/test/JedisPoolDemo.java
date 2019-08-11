import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Administrator on 2019/8/5.
 */
public class JedisPoolDemo {
    public static void main(String[] args) {
//        连接池配置
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
//        设置最大连接数
        jedisPoolConfig.setMaxTotal(50);
//        设置获取链接的最大等待时间
        jedisPoolConfig.setMaxWaitMillis(1000);
//        保证获取到的链接时可用的
        jedisPoolConfig.setTestOnBorrow(true);

//        获取连接池
        JedisPool jedisPool=new JedisPool(jedisPoolConfig,"127.0.0.1",6379);
//        获取jedis对象
        Jedis jedis=jedisPool.getResource();
        jedis.set("pool","测试pool");

        System.out.println("pool:  "+jedis.get("pool"));

//        jedis使用完后，放入连接池中
        jedisPool.returnResource(jedis);
//        释放连接池
        jedisPool.close();
    }
}
