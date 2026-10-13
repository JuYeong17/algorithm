import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int n = people.length;
        int left = 0;
        int right = people.length-1;
        while(left <= right){
            if(people[left] + people[right] <= limit){
                count++;
                left ++ ;
                right --;
            } else{
                count ++;
                right --;
            }
        }
        return count;
    }
}