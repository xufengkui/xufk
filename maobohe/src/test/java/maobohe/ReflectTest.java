package maobohe;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] args) throws Exception{
        ReflectBean rb = new ReflectBean();
        Class c1 = rb.getClass();
        /*Class c2 = ReflectBean.class;
        Class c3 =  Class.forName("maobohe.ReflectBean");

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        System.out.println("*********************完美分割线***********************");

        Field field = c1.getField("BBD");
        System.out.println("指定名称获取public属性:"+field);

        field = c1.getDeclaredField("name");
        System.out.println("指定名称获取private属性:"+field);

        Field[] fields = c2.getFields();
        for (Field field1:fields) {
            System.out.println("获取public属性:"+field1.toString());
        }

        fields = c2.getDeclaredFields();
        for (Field field1:fields) {
            System.out.println("获取所有属性:"+field1.toString());
        }

        System.out.println("*********************完美分割线***********************");

        Method method = c1.getMethod("hello", String.class);
        System.out.println("指定名称获取方法："+ method.toString());
        Method[] methods = c2.getMethods();
        for (Method method1:methods) {
            System.out.println("获取public方法："+ method1.toString());
        }
        methods = c2.getDeclaredMethods();
        for (Method method1:methods) {
            System.out.println("获取所有方法："+ method1.toString());
        }

        System.out.println("*********************完美分割线***********************");

        Constructor[] constructors = c1.getConstructors();
        Constructor constructor = c2.getConstructor(String.class);
        System.out.println("根据指定参数构造器:"+ constructor.toString());
        for (Constructor constructor1:constructors) {
            System.out.println("数构造器:"+ constructor1.toString());
        }*/

        //创建对象
       /* Constructor constructor = c1.getConstructor();
        Object o = c1.newInstance();
        ReflectBean r = (ReflectBean) o;
        Field field = c1.getDeclaredField("name");
        field.setAccessible(true);
        field.set(o,"张三");
        System.out.println(r.getName());
        Method method = c1.getMethod("hello", String.class);
        System.out.println(method.invoke(o,"李四"));*/

       Field field = c1.getDeclaredField("age");
       Annotation[] annotations = field.getAnnotations();
        System.out.println(annotations[0].toString());
    }


}
