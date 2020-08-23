package com.example.demo.JUC;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Administrator
 * @create 2020-07-21 20:01
 */
class User{
    private int id;
    private String UserName;
    private int age;

    public int getId() {
        return id;
    }

    public String getUserName() {
        return UserName;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(int id, String userName, int age) {
        this.id = id;
        UserName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", UserName='" + UserName + '\'' +
                ", age=" + age +
                '}';
    }

}
/**
 * 请按照给出数据，找出
 * 偶数ID
 * 年龄大于24
 * 用户名转为大写
 * 用户名字母倒排序
 * 只输出一个
 * 用户名字
 */
public class StreamDemo {


    public static void main(String[] args) {
        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);

        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);
        list.stream().filter((p)->{return p.getId()%2==0;}).filter(p->{return p.getAge()>24;})
                .map(t->{return t.getUserName().toUpperCase();})
                .sorted((o1, o2) ->{return o2.compareTo(o1);})
                .limit(1).forEach(System.out::println);


    }

    private static void FunctionTest() {
        //消费型接口，有参数无返回  方法：accept
        Consumer<String> consumer = t->{
            System.out.println(t);
        };
        consumer.accept("a");


        //供给型接口  无参数有返回  方法：get
        Supplier<String> supplier = ()->{

            return "b";
        };
        System.out.println(supplier.get());

        //函数式接口 有参数有返回  方法：apply
        Function<String,Integer> function =(t)->{

            return t.length();
        };
        System.out.println(function.apply("abc"));

        //断定型接口 有参数，有boolean返回 方法：test

        Predicate<String> predicate = t->{

            return t.startsWith("a");
        };
        System.out.println(predicate.test("abc"));
    }


}
