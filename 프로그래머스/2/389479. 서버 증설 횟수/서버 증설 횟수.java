class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[players.length];
        for(int i=0;i<players.length;i++){
            while(players[i] >= (servers[i]+1) * m){
                for(int j=0;j<k;j++){
                    if(i+j < players.length) servers[i+j] += 1;
                }
                answer++;
            }
        }
        return answer;
    }
}