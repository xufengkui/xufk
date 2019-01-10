package maobohe;

import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Component;

@Component
public class ReflectBean {
    public static String BBD = "1213141";

    @NotNull
    private String name;

    @NotNull
    public String age;

    public ReflectBean(){

    }
    public ReflectBean(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String say(){
        return "abc";
    }

    public String hello(String str){
        return this.name+"，"+str + ",hello!";
    }
}
