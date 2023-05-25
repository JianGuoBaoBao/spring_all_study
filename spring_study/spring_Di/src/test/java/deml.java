import com.demo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class deml {
    @Test
    public void fun(){
        ApplicationContext context = new ClassPathXmlApplicationContext("base.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
    }
}
