package exercise.exception;

public class ArrayIndexOutOfBoundEx {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4};
        try {
            System.out.println(arr[5]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("에러났지롱");
            System.out.println(e);
        }
    }
}