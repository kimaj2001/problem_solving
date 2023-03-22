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
//
//
//import java.util.*;
//import java.io.*;
//
//public class Hide_and_seek {
//    static int K;
//    //소요되는 시간을 줄이기 위해서 visited 선언
//    static boolean[] visited;
//    static int min = Integer.MAX_VALUE;
//
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//        visited = new boolean[100_001];
//
//        bfs(N);
//
//        System.out.println(min);
//    }
//
//    static void bfs(int val){
//        Queue<Node> q = new LinkedList<>();
//        q.offer(new Node(val, 0));
//        visited[val] = true;
//
//        while(!q.isEmpty()){
//            Node a = q.poll();
//
//            if(a.x == K)
//                min = Math.min(min, a.time);
//
//            if(a.x*2<=100_000 && !visited[a.x*2]){
//                q.offer(new Node(a.x*2, a.time));
//                visited[a.x*2] = true;
//            }
//
//            if(a.x-1>=0 && !visited[a.x-1]){
//                q.offer(new Node(a.x-1, a.time + 1));
//                visited[a.x-1] = true;
//            }
//
//            if(a.x+1<=100_000 && !visited[a.x+1]){
//                q.offer(new Node(a.x+1, a.time + 1));
//                visited[a.x+1] = true;
//            }
//        }
//    }
//}
//class Node{
//    int x, time;
//
//    Node(int x, int time){
//        this.x = x;
//        this.time = time;
//    }
//}