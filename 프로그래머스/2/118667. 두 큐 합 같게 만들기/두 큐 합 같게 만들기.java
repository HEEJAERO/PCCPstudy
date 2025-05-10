import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
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
        long total = sum1+sum2;
     
        int cnt = queue1.length + queue2.length + 1;

        int tmp;
        boolean possible = false;
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
                possible=true;
                break;
            }
        }
        if(possible)return answer;
        else return -1;
        
    }
}