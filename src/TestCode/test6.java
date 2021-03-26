package TestCode;

public class test6 {
    static int a=10;
    static int b;
    static void function() {
     System.out.println("a="+a);
     System.out.println(b);
    }


    public static void main(String[] args) {
        function();
        a x=new a();
        x.function();
    }
    static {
        System.out.println("first.");
        b=3*a;
    }
}
class a {
    static void function(){
        System.out.println("hello");
    }
}