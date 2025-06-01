
import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer =0;
        //Deque<String> deque = new ArrayDeque<>();
        Queue<String> queue = new LinkedList<>();
        int length = cities.length;
        if(cacheSize==0) return length*5;
        for(String city:cities){
            city = city.toLowerCase();
            if(queue.contains(city)){
                queue.remove(city);
                answer += 1;
            }else {
                if(cacheSize == queue.size()){
                    queue.poll();
                }
                answer += 5;
            }
            queue.add(city);
            //System.out.println(queue);
        }

        return answer;
    }
}