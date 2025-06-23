import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int goal = 0;
        int length = priorities.length;

        Queue<Print> queue = new LinkedList<>();
        StringBuilder search =new StringBuilder();
        for(int i=0;i< length;i++){
           queue.add(new Print(priorities[i],i));
            //search.append(priorities[i]);
            if(location==i) goal = i;
            
        }
        Print tmp;
//        int seq = 0;
//        int start = 0;
//        while(true){
//
//        }
        int seq=0;

        for(int i=9;i>=1;i--){
            //System.out.println(start);
            int start = 0;

            for(int j=0;j<queue.size();j++){
                tmp = queue.poll();
                if(tmp.pq == i){
                    seq++;
                    start = j;
                    j--;
                    //System.out.println(start);
                   // System.out.println(tmp.id);
                    if(tmp.id == goal){
                        System.out.println(seq+" "+ goal);
                        answer = (seq);
                    }
                }else{
                    queue.add(tmp);
                    System.out.println(i + " " +tmp.id);
                }
            }
            for(int j=0;j<start;j++){
                queue.add(queue.poll());
            }
        }
        return answer;
    }
    class Print {
        int pq;
        int id;
        Print(int pq,int id){
            this.pq = pq;
            this.id = id;
        }
    }
}