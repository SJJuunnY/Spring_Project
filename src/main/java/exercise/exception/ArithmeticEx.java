package exercise.exception;

public class ArithmeticEx {
    public static void main(String[] args) {
        int result = divide(10,0);
    }
    public static int divide(int a, int b){
        int result = 0;
        try{
            result = a / b;
        }catch (ArithmeticException e){
            System.out.println("nono");
        }
        return result;
    }
}
