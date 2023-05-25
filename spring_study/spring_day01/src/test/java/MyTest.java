import com.demo.dao.UserDaoImpl;
import com.demo.dao.UserDaoMysqlImpl;
import com.demo.service.UserService;
import com.demo.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public  void fun1(){
        //Spring本质是个set方法
        UserService userService = new UserServiceImpl();
        ((UserServiceImpl)userService).setUserDao(new UserDaoMysqlImpl());
        userService.getUser();
    }
    @Test
    public  void fun2(){
        //Spring本质是个set方法
        ApplicationContext context = new ClassPathXmlApplicationContext("base.xml");
        UserService udi = (UserServiceImpl)context.getBean("userServiceImpl");
        udi.getUser();
    }
}
