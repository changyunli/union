import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2019/7/11.
 */
public class SpringTest {

    @Test
    public void test(){

//        创建IOC
        ApplicationContext app=new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        System.out.println("app: "+app);
    }
}
