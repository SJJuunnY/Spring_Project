package exercise.exception;

public class NullPointerExceptionEx {
    public static void main(String[] args) {
        String [] strings = null;
        String str = null;

        try{
            System.out.println(str.charAt(0));
            System.out.println(strings[0]);
        }catch (Exception e){
            System.out.println("예외 터짐 수고");
        }
    }
}