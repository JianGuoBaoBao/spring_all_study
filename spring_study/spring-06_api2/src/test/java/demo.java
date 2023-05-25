import com.demo.service.UserService;
import com.demo.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo {
    @Test
    public void fun(){
        /*动态代理的是接口*/
        ApplicationContext context =  new ClassPathXmlApplicationContext("base.xml");

        UserService userService = (UserService) context.getBean("userService");
        userService.delete();

    }
}
