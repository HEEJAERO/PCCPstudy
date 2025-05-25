import java.util.*;
class Solution {
    public int solution(String[] maps) {
       int answer = 0;
        int lengthY = maps.length;
        int lengthX = maps[0].length();
        int[] dirY = new int[]{0,-1,0,1};
        int[] dirX = new int[]{1,0,-1,0};

        int[] start = new int[]{-1,-1};
        int[] now = new int[]{-1,-1,0};
        int[] lever = new int[]{-1,-1};
        int[] end = new int[]{-1,-1};

        char[][] cMaps = new char[lengthY][lengthX];
        boolean[][] visited = new boolean[lengthY][lengthX];
        boolean[][] visited2 = new boolean[lengthY][lengthX];
        for(int i=0;i<lengthY;i++){
           for(int j=0;j<lengthX;j++){
               cMaps[i][j] = maps[i].charAt(j);
               if(cMaps[i][j]=='S'){
                    start[0] = i;
                    start[1] = j;
                    now[0] = start[0];
                    now[1] = start[1];
               }else if(cMaps[i][j]=='L'){
                    lever[0] = i;
                    lever[1] = j;
               }else if(cMaps[i][j]=='E'){
                   end[0] = i;
                   end[1] = j;
               }else if(cMaps[i][j]=='X'){
                   visited[i][j] = true;
                   visited2[i][j] = true;
               }
           }

        }
        // S -> L
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{now[0],now[1],now[2]});
        System.out.println(now[0] + "," + now[1]);
        visited[now[0]][now[1]] =true;
        // L -> E
        boolean possible = false;
        while(!queue.isEmpty()){
            now = queue.poll();
            if(now[0] == lever[0] && now[1] == lever[1] ){
                System.out.println(now[0] + ",sss" + now[1] + " " + now[2]);
                answer += now[2];
                possible = true;
                break;
            }
            int tmpX;
            int tmpY;
            for(int i=0;i<4;i++){
                if(now[1]+dirX[i] >= 0 && now[1]+dirX[i] < lengthX && now[0]+dirY[i]>=0 && now[0]+dirY[i] <lengthY
                        && !visited[now[0]+dirY[i]][now[1]+dirX[i]]){
                    tmpX = now[1]+dirX[i];
                    tmpY = now[0]+dirY[i];
                    queue.offer(new int[]{tmpY,tmpX,now[2]+1});
                   // System.out.println(now[0] + ",sss , " + now[1] + " " +i +  " "+  (now[2]+1));
                    visited[tmpY][tmpX]=true;
                }
            }
        }
        if(!possible) return -1;

        now[2] = 0;
        queue = new LinkedList<>();
        possible = false;
        queue.add(new int[]{now[0],now[1],0});
        visited2[now[0]][now[1]] = true;
        // L -> E
        while(!queue.isEmpty()){
            now = queue.poll();
            if(now[0] == end[0] && now[1] == end[1] ){
                //System.out.println(now[0] + ",sss" + now[1] + " " + now[2]);
                answer += now[2];
                possible = true;
                break;
            }

            int tmpX;
            int tmpY;
            for(int i=0;i<4;i++){
                if(now[1]+dirX[i] >= 0 && now[1]+dirX[i] < lengthX && now[0]+dirY[i]>=0 && now[0]+dirY[i] <lengthY
                        && !visited2[now[0]+dirY[i]][now[1]+dirX[i]]){
                    tmpX = now[1]+dirX[i];
                    tmpY= now[0]+dirY[i];
                    visited2[tmpY][tmpX]=true;
                    queue.add(new int[]{tmpY,tmpX,now[2] + 1});
                }
            }
        }
        if(!possible) return -1;

        return answer;
    }
}