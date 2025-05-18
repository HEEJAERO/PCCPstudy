class Solution {
    public int solution(String[][] book_time) {
   int answer = 0;
        int[] timeLine = new int[1500];

        for(String[] time:book_time){
            int startMin = Integer.parseInt(time[0].substring(0,2))*60 +  Integer.parseInt(time[0].substring(3,5));
            //System.out.println(startMin);
            int endMin = Integer.parseInt(time[1].substring(0,2))*60 +  Integer.parseInt(time[1].substring(3,5));
            //System.out.println(endMin);
            for(int i=startMin;i<endMin+10;i++){
                timeLine[i]++;
                if(timeLine[i]>answer) answer = timeLine[i];
            }
        }

        return answer;
    }
}