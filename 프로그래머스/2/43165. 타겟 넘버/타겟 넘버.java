class Solution {
    int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return count;
    }
    void dfs(int index, int result, int[] numbers, int target){
        if(index == numbers.length){
            if(target == result) {
                count ++;
            }
           return;
        }
        dfs(index +1, result + numbers[index],numbers, target);
        dfs(index +1, result - numbers[index],numbers, target);
    }
}