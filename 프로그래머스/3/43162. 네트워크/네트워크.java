import java.util.*;
class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                answer++;
                dfs(i,computers);
            }
        }
        return answer;
    }
    void dfs(int start, int[][] computers){
        Stack<Integer> stack = new Stack<>();
        stack.add(start);

        while(!stack.isEmpty()){
            int cur = stack.pop();
            int[] arr = computers[cur];
            for(int i=0;i<arr.length;i++){
                if(!visited[i] && arr[i] ==1){
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }
}