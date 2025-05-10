class Solution {
    static int answer = Integer.MAX_VALUE;
    public int solution(int storey) {
        //int answer = 0;
        int max = 1000000000;
        //System.out.println(storey/max);
        while(storey/max==0) {
            max /= 10;
        }
        test(storey, max*10,0);


        return answer;

    }
   static void test(int num, int max, int now){
        if( max == 0 ){
            if(answer > now) answer =  now;
            return;
        }
        int tmp = num/max;
        test(num-max*tmp,max/10, now+tmp);
        test(max*(tmp+1)-num, max/10,now+tmp+1);
    }
}