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
        
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(-1);
    }
}