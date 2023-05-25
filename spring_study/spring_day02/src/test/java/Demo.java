import com.demo.entity.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("base.xml");
        Hello hello = (Hello)context.getBean("hello");
        System.out.println(hello.toString());
    }
}
