class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        // 둘중 한쪽만 전부 나눌수있는 양의 정수 찾기?
        int length = arrayA.length;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        for(int i=1;i<length;i++){
            gcdA = gcd(gcdA,arrayA[i]);
            gcdB = gcd(gcdB,arrayB[i]);
        }
        boolean checkA = true, checkB = true;
        for(int i=0;i<length;i++){
            if(arrayB[i]%gcdA == 0) checkA = false;
            if(arrayA[i]%gcdB == 0) checkB = false;
        }
        if(checkA && checkB){
            answer = Math.max(gcdA,gcdB);
        }else if(checkA){
            answer = gcdA;
        }else if(checkB){
            answer = gcdB;
        }
        // 서로 나눌수있는지?
        return answer;
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}