package exercise.generics;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList array = new ArrayList();
        array.add("hi");
        array.add(0);
        array.add(true);
        array.add(new human());
        System.out.println(array);
        ((human) array.get(3)).talk();
    }
}
class human {
    int height = 123;
    int weight = 123;

    Integer num2 = Integer.valueOf(7);


    void talk() {
        System.out.println("안녕하세요~");
    }
}