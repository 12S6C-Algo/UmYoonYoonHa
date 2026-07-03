import java.util.*;

class Solution {
    public int solution(String dirs) {
        String d = "UDRL";
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        boolean[][][] visited = new boolean[11][11][4];
        int r = 5, c = 5;
        int cnt = 0;
        for (int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            int idx = d.indexOf(ch);
            int nr = r + dr[idx];
            int nc = c + dc[idx];
            
            if (nr < 0 || nr > 10 || nc < 0 || nc > 10) continue;
            
            if (!visited[nr][nc][idx]) {
                visited[nr][nc][idx] = true;
                idx = idx <= 1 ? 1-idx : 5-idx;
                visited[r][c][idx] = true;
                cnt++;
            }
            r = nr;
            c = nc;
        }
        return cnt;
    }
}

// String 이용한 풀이 - 속도 훨씬 느림
// import java.util.*;
// class Solution {
//     public int solution(String dirs) {
//         String[] d = dirs.split("");
//         Set<String> s = new HashSet<>();
//         int r = 5;
//         int c = 5;
//         int cnt = 0;
//         for (int i = 0; i < d.length; i++) {
//             String dir = d[i];
//             int dr = 0;
//             int dc = 0;
//             if (dir.equals("U")) {
//                 if (r == 0) continue;
//                 dr = -1;
//             } else if (dir.equals("D")) {
//                 if (r == 10) continue;
//                 dr = 1;
//             } else if (dir.equals("L")) {
//                 if (c == 0) continue;
//                 dc = -1;
//             } else if (dir.equals("R")) {
//                 if (c == 10) continue;
//                 dc = 1;
//             }
//             int nr = r+dr;
//             int nc = c+dc;
//             String move = r+","+nr+","+c+","+nc;
//             String rev = nr+","+r+","+nc+","+c;
//             r = nr;
//             c = nc;
//             if (!s.contains(move)) {
//                 s.add(move);
//                 s.add(rev);
//                 cnt++;
//             } else {
//                 continue;
//             }   
//         }        
//         return cnt;
//     }
// }
