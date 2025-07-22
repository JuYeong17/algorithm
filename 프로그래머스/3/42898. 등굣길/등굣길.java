class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] newboard = new int[n+1][m+1];
        int mod = 1000000007;
        for(int[] puddle: puddles){
            int x = puddle[0];
            int y = puddle[1];
            newboard[y][x] = -1;
        }
        newboard[1][1] = 1; 
        for(int i=1; i<newboard.length;i++){
            for (int j=1; j< newboard[0].length;j++){
                if(newboard[i][j] == -1){
                    continue;
                }
                if(newboard[i-1][j] >0){
                    newboard[i][j] = (newboard[i-1][j] + newboard[i][j] ) % mod;
                }
                if(newboard[i][j-1] >0){
                    newboard[i][j] = (newboard[i][j-1]+ newboard[i][j]) % mod;
                }
            }
        }
        return newboard[n][m];
    }
}