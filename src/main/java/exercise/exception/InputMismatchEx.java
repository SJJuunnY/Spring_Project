package exercise.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatchEx {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            int score;
            String input = scanner.next();

            if(input.equals("q"))
                break;

            try {

                score = Integer.parseInt(input);
            } catch (NumberFormatException e){ //잘못된 문자열을 숫자로 변환할때 생기는 예외
                continue;
            }

            if (score >= 60)
                System.out.println("합격 축");
            else
                System.out.println("떨입니다 수공");
        }
    }
}
