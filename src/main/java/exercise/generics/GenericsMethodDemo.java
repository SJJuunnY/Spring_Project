package exercise.generics;

public class GenericsMethodDemo {

}

class GenericMethod{
    static <T> GenericsClass<T> returnGenericsObject(){
        return new GenericsClass<T>();
    }
}

class GenericsClass<T>{
    T field;

}
