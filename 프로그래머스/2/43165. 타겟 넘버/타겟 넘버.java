class Solution {
    int answer =0 ;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }
    private void dfs(int[] numbers, int depth, int target, int calc){
        if(depth == numbers.length){
            if(calc == target){
                answer ++;
            }
        } else{
            dfs(numbers, depth+1, target, calc + numbers[depth]);
            dfs(numbers, depth+1, target, calc - numbers[depth]);
        }
    }
}