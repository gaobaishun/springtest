package testc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.core.ReflectUtils;

import java.lang.reflect.Proxy;

/**
 * @Author gaobaishun
 * @Date 2020-03-08 18:48
 * imformation：
 */
public class TestBean implements BeanPostProcessor {
    private String s;

    public TestBean() {
        System.out.println("默认construct构造函数");
    }

    public TestBean(String s) {


        this.s = s;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        System.out.println("设置属性："+s);
        this.s = s;
    }
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+"执行postProcessBeforeInitialization---"+(null==bean));
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+"执行postProcessAfterInitialization---"+(null==bean));
        return bean;
    }

    public void start(){
        System.out.println("后置处理器的初始化方法");
    }
}
