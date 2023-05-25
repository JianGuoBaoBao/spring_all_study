import com.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    @Test
    public void fun(){
//        在配置文件时容器已经生成了
        ApplicationContext context = new ClassPathXmlApplicationContext("base.xml");
                User user = (User)context.getBean("userAlias");
                user.toString();
    }
}
