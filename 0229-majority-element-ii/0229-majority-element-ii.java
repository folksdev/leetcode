
import java.util.stream.Collectors;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > (nums.length / 3))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}