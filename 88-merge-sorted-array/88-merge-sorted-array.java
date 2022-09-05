class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> l1 = new ArrayList<>(Arrays.stream(nums1).boxed().toList().subList(0, m));
        List<Integer> l2 = Arrays.stream(nums2).boxed().toList().subList(0, n);
        l1.addAll(l2);
        
        Collections.sort(l1);
        
        IntStream.range(0, m + n).forEach(i -> nums1[i] = l1.get(i));
    }
}