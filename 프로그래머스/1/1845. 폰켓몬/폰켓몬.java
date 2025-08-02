import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int keyCount = map.keySet().size();
    if((nums.length/2) > keyCount){
      return keyCount;
    }
    return nums.length/2;
  }
}