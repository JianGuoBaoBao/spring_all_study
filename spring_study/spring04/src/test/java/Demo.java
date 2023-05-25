
import com.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    @Test
    public void fun(){
        ApplicationContext context = new ClassPathXmlApplicationContext("base.xml");
        User user = (User)context.getBean("user3");
        User user2 = (User)context.getBean("user3");

        System.out.println(user  == user2);
    }
}
