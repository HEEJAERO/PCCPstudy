class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int length = sticker.length;
        int[] dp1 = new int[length-1];
        int[] dp2 = new int[length];
        if(length==1) return sticker[0];
        else if(length==2) return Math.max(sticker[0],sticker[1]);
 
        // 0 번째 선택
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for(int i =2;i<length-1;i++){
            dp1[i] = Math.max(dp1[i-1],dp1[i-2]+sticker[i]);
        }
        // 1 번째 선택
        dp2[0] = 0;
        dp2[1] = sticker[1];

        for (int i = 2; i < length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        return Math.max(dp1[dp1.length-1], dp2[dp2.length-1]);
    }
}