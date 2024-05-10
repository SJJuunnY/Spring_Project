package exercise.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberBaseball {
    public static void main(String[] args) {
        game();
    }
    public static void game(){
        //숫자를 int 배열로 설정한다.
        int [] ans = {5,2,7};
        Scanner scanner = new Scanner(System.in);

        for(int i=0;i<10;i++){
            System.out.println("숫자를 맞춰보세요~~(남은기회 : "+(10-i)+"번)");

            int [] inputs = new int[3];
            try {
                inputs = getNumber();
            }catch (InputMismatchException e){
                System.out.println("숫자를 다시 입력하세요");
                i--;
                continue;
            }
            int ball = 0, strike=0, out = 0;

            for(int j=0;j<inputs.length;j++){
                if(inputs[j]==ans[j])
                    strike++;
                else if (checkContain(ans,inputs[j]))
                    ball++;
                else
                    out++;
            }


            System.out.print("결과보고 : ");
            if(strike > 0 )
                System.out.print(strike+"S ");
            if(ball > 0 )
                System.out.print(ball+"B ");
            if(out > 0 )
                System.out.print(out+"O ");
            System.out.println();

            if(strike==3) {
                System.out.println("당신이 이겼습니다....아디다스");
                break;
            }
            if(i==9){
                System.out.println("당신이 졌습니다.. 수고하세요");
            }
        }

    }
    public static boolean checkContain(int [] arr, int num){
        for(int i=0;i<arr.length;i++)
            if(arr[i]==num)
                return true;
        return false;
    }

    public static int [] getNumber(){
        int [] numbers = new int[3];
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<3;i++){
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }


}
