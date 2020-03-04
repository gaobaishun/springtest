package startc;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import testc.Book;

public class Start {
    public static void main(String[] args) {

//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
//        Book book = applicationContext.getBean("book", Book.class);
//        book.printBookInfo();
        //包含了beandefinition的信息
//        ClassPathResource resource=new ClassPathResource("spring-config.xml");
//        //创建 一个bean factory
//        XmlBeanFactory factory=new XmlBeanFactory(resource);
//
//        //创建一个读取器
//        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
//
//        //ioc容器建立
//        reader.loadBeanDefinitions(resource);
//
//        Book book=factory.getBean("book",Book.class);
//        book.printBookInfo();
//
//        String s="/1232";
//        s=s.substring(1);
//        System.out.println(s);

        FileSystemXmlApplicationContext fileSystemXmlApplicationContext=new FileSystemXmlApplicationContext("/Sdemo/src/spring-config.xml");

        Book book=fileSystemXmlApplicationContext.getBean("book",Book.class);
        Book book2=fileSystemXmlApplicationContext.getBean("book",Book.class);
        System.out.println(book.hashCode()==book2.hashCode());
        book.printBookInfo();

    }
}
