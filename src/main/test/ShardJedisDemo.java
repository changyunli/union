import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/8/5.
 */
public class ShardJedisDemo {
    public static void main(String[] args) {
//        设置连接池配置信息
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
//        设置链接最大数
        jedisPoolConfig.setMaxTotal(50);
//        设置获取链接的最大等待时间
        jedisPoolConfig.setMaxWaitMillis(1000);
//        保证获取的链接可用
        jedisPoolConfig.setTestOnBorrow(true);

//        定义分片信息，添加redis分片的端口和IP
        List<JedisShardInfo> jedisShardInfo_list=new ArrayList<JedisShardInfo>();
        jedisShardInfo_list.add(new JedisShardInfo("127.0.0.1",6379));
//      jedisShardInfo_list.add(new JedisShardInfo(IP,6379));

//        定义分片连接池，指定配置信息和分片地址信息
        ShardedJedisPool shard_jedis=new ShardedJedisPool(jedisPoolConfig,jedisShardInfo_list);

        ShardedJedis jedis=null;
        try{
            jedis=shard_jedis.getResource();//            获取jedis
            jedis.set("share_data","测试share_data");
            System.out.println("share_data:  "+jedis.get("share_data"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(jedis!=null){//            放回到连接池(有效)，摧毁（无效）
                jedis.close();
            }
        }
        shard_jedis.close();//       释放连接池
    }
}
