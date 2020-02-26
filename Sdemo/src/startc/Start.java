package startc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import testc.Book;

public class Start {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        Book book = applicationContext.getBean("book", Book.class);
        book.printBookInfo();
    }
}
