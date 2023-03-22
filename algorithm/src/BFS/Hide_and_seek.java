package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hide_and_seek {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 수빈이와 동생의 위치를 입력받는다.
        String[] input = scanner.nextLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        // 수빈이의 위치와 동생의 위치를 매개변수로 전달한다.
        bfs(start, end);
    }
    public static void bfs(int start, int end) {
        // 시작 정점부터 인접한 정점을 탐색하기 위해 Queue 를 사용한다.
        Queue<Integer> queue = new LinkedList<>();
        // 정점간 이동 시 시간을 저장하기 위해 int 배열 생성
        int time[] = new int[100001];
        // 방문한 정점은 다시 방문하지 않기 위해 boolean 배열 생성
        boolean[] visited = new boolean[100001];
        // 시작 정점을 queue에 추가하고 방문한 것으로 체크한다.
        queue.offer(start);
        visited[start] = true;
        // 시작 정점의 time 은 0으로 시작한다.
        time[start] = 0;

        // 큐가 비어있지 않으면 계속 반복한다.
        while(!queue.isEmpty()) {
            // 가장 처음 추가한 queue 를 꺼낸다.
            int n = queue.poll();
//            System.out.println("n : " + n + ", time : " + time[n]);
            // 반환된 큐가 동생의 위치와 동일하면 시간을 출력한다.
            if (n == end) {
                System.out.println(time[n]);
            };
            // 위치는 100000을 넘을 수 없으며 해당 정점에 방문한 적이 있는지 체크한다.
            if(n * 2 <= 100000 && visited[n*2] == false) {
                // 위치 * 2 는 시간이 추가되지 않으므로 현재 정점의 시간을 그대로 저장한다.
                queue.offer(n * 2);
                time[n*2] = time[n];
                visited[n*2] = true;
//                System.out.printf("n * 2 = %d, time[n*2] = %d%n", n*2, time[n*2]);
            }
            // 위치는 0보다 작을 수 없으며, 해당 정점에 방문한 적이 있는지 체크한다.
            if(n - 1 >= 0 && visited[n-1] == false)  {
                // 위치 - 1 은 시간이 1초 추가되므로 현재 정점의 시간에서 +1 한다.
                queue.offer(n - 1);
                time[n-1] = time[n] + 1;
                visited[n-1] = true;
//                System.out.printf("n - 1 = %d, time[n-1] = %d%n", n-1, time[n-1]);
            }
            // 위치는 100000을 넘을 수 없으며 해당 정점에 방문한 적이 있는지 체크한다.
            if(n + 1 <= 100000 && visited[n+1] == false) {
                // 위치 + 1 은 시간이 1초 추가되므로 현재 정점의 시간에서 +1 한다.
                queue.offer(n + 1);
                time[n+1] = time[n] + 1;
                visited[n+1] = true;
//                System.out.printf("n + 1 = %d, time[n+1] = %d%n", n+1, time[n+1]);
            }
//            queue.stream().forEach(a -> System.out.print("queue:" + a + "-" + time[a] + "  "));
//            System.out.println("queue : " + queue);
//            System.out.println();
//            System.out.println();
//            System.out.println();
        }
    }
}

/*
입력값 : 5 17
출력값 : 2
 */
