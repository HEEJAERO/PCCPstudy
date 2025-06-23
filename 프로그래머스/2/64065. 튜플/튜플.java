import java.util.*;
class Solution {
public int[] solution(String s) {
        int[] answer ;
        String[] strings= s.split("\\{|\\}");

        Map<String, Integer> map = new HashMap<>();
    
        for (String str : strings) {
            if(!str.equals("") && !str.equals(",")){
                String[] nums = str.split(",");
                for (String num : nums) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey()));
        answer = new int[map.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = Integer.parseInt(entryList.get(i).getKey());
        }
        return answer;
    }
}