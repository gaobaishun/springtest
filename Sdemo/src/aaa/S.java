package aaa;

/**
 * @Author gaobaishun
 * @Date 2020-03-09 20:15
 * imformation：
 */
public class S {
    public static void main(String[] args) {
        A ab=new B();
        //System.out.println(new A().a);
        ((B) ab).print();
    }
}
