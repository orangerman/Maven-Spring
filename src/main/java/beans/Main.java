package beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Person person2 = (Person) ctx.getBean("person2");
        System.out.println(person2);


        ApplicationContext ctx2 = new ClassPathXmlApplicationContext("beans-autowhire.xml");
        Person person = ctx2.getBean(Person.class);
        System.out.println(person);

        Address address = (Address) ctx.getBean("address");
        System.out.println(address);

        Address address2 = (Address) ctx.getBean("address2");
        System.out.println(address2);

        Person person3 = (Person) ctx.getBean("person3");
        System.out.println(person3);


        ApplicationContext ctx3 = new ClassPathXmlApplicationContext("beans-properties.xml");
        System.out.println(ctx3);
        DataSource dataSource = (DataSource) ctx3.getBean("dataSource");
        System.out.println(dataSource.getConnection());

    }
}
