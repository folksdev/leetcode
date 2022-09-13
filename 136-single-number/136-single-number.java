import java.util.Optional;

class Solution {
    
   public int singleNumber2(int[] nums) {
        List<Integer> s = new ArrayList<>();
        s.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (s.contains(nums[i])){
                s.remove((Integer) nums[i]);
            } else {
                s.add(nums[i]);

            }
        }
        return s.get(0);
    }

    //Alternative
    public int singleNumber(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        for (Map.Entry<Integer, Long> e: map.entrySet()) {
            if (e.getValue() == 1) {
                return e.getKey();
            }
        }
        return -1;
    }
}