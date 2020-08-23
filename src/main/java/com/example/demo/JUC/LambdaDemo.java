package com.example.demo.JUC;


/**
 * lamda表达式要求：1.标记为函数式接口，
 *                  2.接口中可以又default方法，以及静态方法（类方法）
 */
@FunctionalInterface//函数式接口
interface Foo{
    public int add(int x, int y);



    default int div(int x, int y){
        return x/y;
    }
    default int div1(int x,int y){
        return x/y-2;
    }

    public static int sub(int x, int y){
        return x-y;
    }
//    public static int asd(int x,int y){
//        return x+y;
//    }

}


public class LambdaDemo {

    /**
     * Lambda Express-----> 函数式编程
     * @param args
     * @throws Exception
     *拷贝小括号（），写死右箭头->，落地大括号{...}
     *
     */
    public static void main(String[] args)throws Exception {
        Foo foo2 = new Foo() {
            @Override
            public int add(int x, int y) {
                System.out.println("hello java191101");
                return x+y;
            }
        };



        Foo foo = (int x,int y)->{
            System.out.println("hello java191101");

            return x+y;
        };
        Foo foo1 = (int x,int y)->{

            return 0;
        };

        System.out.println(foo.add(10, 5));
        System.out.println(foo.div1(10, 5));
        System.out.println(Foo.sub(10, 5));



    }
}
