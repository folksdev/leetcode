import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromSortedArray {

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array/

    public static void main(String[] args) {
        System.out.println("result : " + removeDuplicates(new int[] {-3,-1,0,0,0,3,3}));
    }

    public static int removeDuplicates(int[] nums) {
        Set<Integer> a = Arrays.stream(nums).boxed().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        int[] nums2 = a.stream().mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < a.size(); i++) {
            if (nums[i] != nums2[i]){
                nums[i] = nums2[i];
            }
        }

        return a.size();
    }
}
