import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        int[][] p = {
            {3,1},
            {0,0},
            {0,1},
            {0,2}, 
            {1,0},
            {1,1},
            {1,2},
            {2,0},
            {2,1},
            {2,2},
            {3,0},
            {3,2}
        };
        StringBuilder result = new StringBuilder();
        int left = 10;
        int right = 11;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] == 1 || numbers[i] == 4 ||numbers[i] == 7){
                left = numbers[i];
                result.append("L");
            }
            else if(numbers[i] == 3 || numbers[i] == 6 ||numbers[i] == 9){
                right = numbers[i];
                result.append("R");
            }
            else{
                int ls = Math.abs((p[left][0] - p[numbers[i]][0])) + Math.abs((p[left][1] - p[numbers[i]][1]));
                int rs = Math.abs((p[right][0] - p[numbers[i]][0])) + Math.abs((p[right][1]-p[numbers[i]][1]));
                if(ls > rs) {
                    result.append("R");
                    right = numbers[i];
                }
                else if(ls < rs) {
                    result.append("L");
                    left =numbers[i];
                }
                else{
                    if(hand.equals("right")) {
                        right = numbers[i];
                        result.append("R");
                    }
                    else {
                        left =numbers[i];
                        result.append("L");
                    }
                }
            }
        }
        return result.toString();
    }
}