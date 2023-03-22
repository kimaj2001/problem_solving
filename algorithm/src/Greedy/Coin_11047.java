package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Coin_11047 {
    Scanner scanner = new Scanner(System.in);
    public void print() {
        String[] input = scanner.nextLine().split(" ");
        // 가지고 있는 동전 종류
        int count = Integer.valueOf(input[0]);
        // 가지고 있는 동전으로 만들어야 하는 값
        int price = Integer.valueOf(input[1]);
        // 동전의 타입을 저장하기 위한 배열 생성
        int[] ints = new int[count];
        // 배열에 동전 타입 저장
        for (int i = 0; i < count; i++) {
            ints[i] = scanner.nextInt();
        }
        // price원을 만드는데 필요한 동전 개수
        int result = 0;
        // 가장 큰 동전 타입부터 확인하기 위해 정렬 (오름차순으로 주어진다는 조건이 있어 주석처리)
//        Arrays.sort(ints);
        // 가장 큰 동전부터 확인하면서 필요한 동전 개수를 확인한다.
        for (int i = ints.length -1; i >= 0; i--) {
            if (price != 0 && ints[i] <= price) {
                System.out.printf("type : %d, price : %d%n", ints[i], price);
                result += price/ints[i];
                price = price%ints[i];
                System.out.printf("result : %d, price : %d%n", result, price);
            } else if (price == 0) break;
            System.out.println();
        }
        // 결과값을 출력한다.
        System.out.println(result);
    }
}

/*
입력
10 4790
1
5
10
50
100
500
1000
5000
10000
50000

출력
12
 */

