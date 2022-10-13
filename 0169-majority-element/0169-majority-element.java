class Solution {
    public int majorityElement(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > (nums.length / 2) )
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(0);
    }
}