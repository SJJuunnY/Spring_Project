package exercise.exception;

import java.util.Scanner;

public class AgeThrowCheckerEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            try {
                System.out.println("나이를 입력하세요. 범위는 0 ~ 100");
                int age = scanner.nextInt();

                if (age < -1 || age > 101) {
                    throw new InputBoundErrorException("0~100사이로 입력해주세요");
                }

                if (age == -1)
                    break;

                System.out.println("당신의 나이는 " + age + "살이시네요. 빈갑습니다.");
            } catch (InputBoundErrorException e){
//                System.out.println(e.getMessage());
                System.out.println(e.getMessage());
            }finally {
                scanner.close();
            }
        }
    }
}
