package week02;

import java.util.*;

public class bacise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numbers = ""; //사용자로부터 입력받을 값 저장
        Set<String> HashSet = new HashSet<>();
        while(true){
            HashSet.add(Integer.toString((int)(Math.random()*9)));
            if(HashSet.size() == 3) {
                break;
            }
        }
        String[] num = HashSet.toArray(new String[3]); // 크기가 3인 배열선언
        System.out.println("컴퓨터 숫자 : "+ Arrays.toString(num));
        int count = 1; // 번째카운트변수
        while(true){
            System.out.print(count+"번째 시도 : ");
            ++count;
            numbers = sc.next();

            //사용자한테 받은 숫자를 배열에 넣은 코드
            String[] arrNum = new String[numbers.length()]; // 입력받은 크기만큼의 배열생성
            for(int i = 0; i< arrNum.length; i++){
                arrNum[i] = String.valueOf(numbers.charAt(i) - '0');
            }

            int ballcount = 0; // 볼 카운트
            int scrcount = 0; // 스트라이크 카운트
            String comment = ""; // 결과값 저장
            for(int i = 0; i < 3; i++) {
                if (numbers.contains(num[i])) { // 카운트 값 포함되어 있어?
                    if ((num[i]).equals(arrNum[i])) { // 위치 같아?
                        ++scrcount;
                        if (scrcount == 3) {
                            System.out.println((count - 1) + "번만에 맞히셨습니다");
                            System.out.println("게임을 종료합니다");
                        }
                    } else {
                        ++ballcount;
                    }
                }
            }
            comment += scrcount+"S"+ballcount+"B";
            if(scrcount == 3){
                break;
            }
            System.out.println(comment);
        }
    }
}
