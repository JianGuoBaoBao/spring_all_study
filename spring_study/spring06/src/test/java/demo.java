
import com.demo.config.UserConfig;
import com.demo.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class demo {
    public static <UserProxy> void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("base.xml");
//        User user = context.getBean("user",User.class);
//        System.out.println(user.name);

        //javaconfig方式配置
        // 如果完全使用了配置类方式去做，我们就只能通过AnnotationConfig上下文来获取
        ApplicationContext context2 = new AnnotationConfigApplicationContext(UserConfig.class);
        User user = context2.getBean("user",User.class);
        System.out.println(user.name);

//        代理思想
//        UserProxy up = new UserProxy();


//        HashMap<String,String> map = new HashMap()
//        ArrayList arrayList = new ArrayList();
    }
}
