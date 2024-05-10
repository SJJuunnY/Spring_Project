package exercise.generics;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStackDemo {
    public static void main(String[] args) {
        MyStack<String> stackStr = new MyStack();
        stackStr.push("a");
        stackStr.push("b");
        stackStr.push("c");

        System.out.println( stackStr.pop() ); // 제거 + 반환
        System.out.println( stackStr.peek() );
        System.out.println( stackStr.isEmpty() );
        stackStr.printElement();
    }


}

class MyStack<T>{
    ArrayList<T> arrayList = new ArrayList<T>();
    void push(T data){
        arrayList.add(data);
    }
    T pop(){
        if(arrayList.size()==0){
            throw new EmptyStackException();
        }
        T elem = arrayList.get(arrayList.size() - 1);
        arrayList.remove(arrayList.size() - 1);
        return elem;
    }
    T peek(){
        if(arrayList.size()==0){
            throw new EmptyStackException();
        }
        return  arrayList.get(arrayList.size() - 1);
    }
    boolean isEmpty(){
        return  arrayList.isEmpty() ;
    }
    void printElement(){
        System.out.println(arrayList);
    }
}
