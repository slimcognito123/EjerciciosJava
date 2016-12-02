import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Created by curso mañana on 23/11/2016.
 */
public class JellouGuorldPrintear {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "Spring-Module.xml");

        otraCosa obj = (otraCosa) context.getBean("otraCosa");
        JelouGuorldController variable = obj.getHolaJudia();
        variable.printHello();
    }
}
