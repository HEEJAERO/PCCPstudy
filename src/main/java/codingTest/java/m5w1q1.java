package codingTest.java;

import java.util.LinkedList;
import java.util.Queue;

public class m5w1q1 {

    // 두 큐 합 같게 만들기
    // Level 3
    /*
        queue1 = [3, 2, 7, 2]  -> 14
        queue2 = [4, 6, 5, 1]  -> 16
        [1, 2, 1, 2] -> 6
        [1, 10, 1, 2]	-> 14

        불가능한 경우 -1 리턴
        1. 합이 홀수인경우
        2. 하나의 인자가 전체합의 절반을 넘는경우
        3. 3 3 3 3 3 14 요런경우도 불가능
     */
    public static void main(String[] args) {
        int[] q1 = {1, 2, 1, 2};
        int[] q2 = {1, 10, 1, 2};

        System.out.println("출력값은 " + solution(q1,q2) + "입니다!");
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        long max = 0;
        long min = Long.MAX_VALUE;
        for(int a:queue1) {
            q1.offer(a);
            sum1 += a;
            if(max<a) max =a;
            if(min>a) min = a;
        }
        for(int b:queue2) {
            q2.offer(b);
            sum2 += b;
            if(max<b) max =b;
            if(min>b) min = b;
        }
        if(sum1==sum2)return 0;

        int cnt = queue1.length + queue2.length + 1; // 한사이클을 다 돌았는지 체크

        int tmp;
        while(cnt >= answer && !q1.isEmpty()&&!q2.isEmpty()){
            answer ++;
            if(sum1>sum2){
                tmp = q1.remove();
                q2.offer(tmp);
                sum1 -= tmp;
                sum2 += tmp;
            } else {
                tmp = q2.remove();
                q1.offer(tmp);
                sum2 -= tmp;
                sum1 += tmp;
            }
            if(sum1==sum2) {
               return answer;
            }
        }
        return -1;

    }
}
