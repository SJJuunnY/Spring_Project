package exercise.generics;

import java.util.ArrayList;

public class GenericsDemo {
    public static void main(String[] args) {
//        car [] cars = new car[3];
//        ArrayList<car> cars = new ArrayList<car>();
//        cars.add(new Hyundai());
//        cars.add(new Kia());
//        cars.add(new Tesla());

//        ArrayList<car> carArrayList = new ArrayList<car>();
//        carArrayList.add(new Hyundai());
//        carArrayList.add(new Kia());
//        carArrayList.add(new Tesla());

        ArrayList<car> carArrayList = new ArrayList<>();
        for(int i=0;i<carArrayList.size();i++)
            carArrayList.get(i).bbang();

    }
}
class carList<T>{
    ArrayList<T> arrayList = new ArrayList<T>();

    void add(T data){
        arrayList.add(data);
    }

    T get(int idx){
        return arrayList.get(idx);
    }
}




class car{
    void bbang(){
        System.out.println("BBANG BBANG~");
    }
}
class Hyundai extends car{
    void bbang(){
        System.out.println("Hyundai BBANG~");
    }
}

class Kia extends car{
    void bbang(){
        System.out.println("Kia BBANG~");
    }
}

class Tesla extends car{
    void bbang(){
        System.out.println("Tesla BBANG~");
    }
}