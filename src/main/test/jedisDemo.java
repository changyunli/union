import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2019/8/5.
 */
public class jedisDemo {

    public static void main(String[] args) {

//        创建jedis对象
        Jedis jedis=new Jedis("127.0.0.1",6379);

        jedis.set("data","测试数据");

        System.out.println("data:  "+jedis.get("data"));

//        释放
        jedis.close();
    }
}
