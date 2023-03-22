package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hide_and_seek {
    int time[] = new int[100001];
    boolean[] visited = new boolean[100001];

    public void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        queue.offer(start);
        time[start] = 0;
        visited[start] = true;

        int min = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            int n = queue.poll();
//            System.out.println("n : " + n + ", time : " + time[n]);
            if (n == end) {
                System.out.println(Math.min(min,time[n]));
                return;
            };
            if(n * 2 <= 100001 && visited[n*2] == false) {
                queue.offer(n * 2);
                time[n*2] = time[n];
                visited[n*2] = true;
//                System.out.printf("n * 2 = %d, time[n*2] = %d%n", n*2, time[n*2]);
            }
            if(n - 1 >= 0 && visited[n-1] == false)  {
                queue.offer(n - 1);
                time[n-1] = time[n] + 1;
                visited[n-1] = true;
//                System.out.printf("n - 1 = %d, time[n-1] = %d%n", n-1, time[n-1]);
            }
            if(n + 1 <= 100001 && visited[n+1] == false) {
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
