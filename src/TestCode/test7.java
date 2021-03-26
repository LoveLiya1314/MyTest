package TestCode;

public class test7 {
    public static void main(String[] args) {
    testClass1 f =new testClass1();
    food a=new rice();
    eat b=new fruit();
    f.testClass(a);
    f.testInterface(b);
    }
}
class food {
    public void aaa(){
        System.out.println("我是食物！");
    }
    public void bbb(){
        System.out.println("可以吃！");
    }
}
class water{
    public void aaa(){
        System.out.println("我是水！");
    }
    public void bbb(){
        System.out.println("可以喝！");
    }
}
class rice extends food {
    public void aaa() {
        System.out.println("我是米饭！");
    }

}
class vegetable extends food {
    public void aaa() {
     System.out.println("我是蔬菜！");
    }
}
class fruit extends food implements eat{
    public void aaa() {
     System.out.println("我是水果！");
    }
    public  void  ccc() {
        System.out.println("我可以被吃！");
    }
}
interface eat{
    public abstract void ccc();
    static void totle() {
        System.out.println("我们都是人体所需要的！");
    }

}
class testClass1 {
    public void testClass(food x){
        x.aaa();
    }
    public void testInterface(eat x){
        x.ccc();
        eat.totle();
    }
}