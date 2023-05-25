import demo.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.lang.annotation.Target;å

public class Demo {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("base.xml");

        People people = context.getBean("people",People.class);

        people.getDog().shout();
        people.getCat().shout();
    }
}
