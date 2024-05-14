package exercise.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MbtiThrowsEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("=== MBTI 검사를 시작합니다. ===");
            checkEorI(scanner);
            /*
            1. 나는 밖에서 에너지를 얻는다.
            2. 나는 이불속에서 에너지를 얻는다
            당신의 선택은 ? _ (숫자로 입력받기)
            1 -> E, 2-> I 입니다.
            만약 1a처럼 잘못 입력하면, 예외 처리
            */
            System.out.println("=== MBTI 검사가 종료되었습니다. ===");
            if(scanner != null)
                scanner.close();
        } catch (InputMismatchException e){
            System.out.println("키보드 입력이 잘못되었습니다.");
        }
    }
    static void checkEorI(Scanner scanner) throws InputMismatchException{
        System.out.println("1. 나는 밖에서 에너지를 얻는다");
        System.out.println("2. 나는 이불속에서 에너지를 얻는다.");
        System.out.print("당신의 선택은 ? ");
        int num= scanner.nextInt();
        if(num == 1){
            System.out.println("당신은 E입니다.");
        }
        else if (num == 2){
            System.out.println("당신은 I입니다.");
        }
        else {
            System.out.println("숫자를 잘못 입력하셨습니다.");
        }
    }
}
