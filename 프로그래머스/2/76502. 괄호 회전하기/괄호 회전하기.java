
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int length = s.length();
        StringBuffer str = new StringBuffer(s);

        for(int i=0;i<length;i++){
            Stack<Character> stack = new Stack<>();
            stack.add(str.charAt(0));
            for(int j=1;j<length;j++){
                if(stack.isEmpty()) stack.add(str.charAt(j));
                else{
                    switch (stack.peek()){
                        case '{' ->{
                            if(str.charAt(j)=='}') stack.pop();
                            else stack.add(str.charAt(j));
                        }
                        case '[' ->{
                            if(str.charAt(j)==']') stack.pop();
                            else stack.add(str.charAt(j));
                        }
                        case '(' ->{
                            if(str.charAt(j)==')') stack.pop();
                            else stack.add(str.charAt(j));
                        }
                        default -> stack.add(str.charAt(j));
                    }
                }

            }
            if(stack.isEmpty()) answer++;
            str.append(str.charAt(0));
            str.deleteCharAt(0);
            //System.out.println(str);
        }

        return answer;
    }
}