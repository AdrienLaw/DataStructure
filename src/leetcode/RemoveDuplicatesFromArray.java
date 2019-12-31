package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicatesFromArray {
    public int removeDuplicates(int[] nums) {
        int int1 = 0;
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (integers.contains(nums[i])){
                int1++;
            }
            integers.add(nums[i]);
        }
        return int1;


    }

    public static void main(String[] args) {
        RemoveDuplicatesFromArray removeDuplicatesFromArray = new RemoveDuplicatesFromArray();
        int[] ints = {1,1,2,4,5,6,7,2};
        int duplicates = removeDuplicatesFromArray.removeDuplicates(ints);
        System.out.println(duplicates);

    }
}
