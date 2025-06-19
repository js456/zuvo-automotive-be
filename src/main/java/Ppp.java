import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Ppp {
    String name;
    int age;
    public void getInf(){
        System.out.println("my name is "+this.name);
        System.out.println("my age is "+this.age);
    }
    public static void main(String[] args) {
        Ppp ppp = new Ppp();
        ppp.name = "dev";
        ppp.age = 21;
        ppp.getInf();

        Ppp ppp1 = new Ppp();
        ppp1.name = "asdfas";
        ppp1.age= 33;
        ppp1.getInf();

    }
}
