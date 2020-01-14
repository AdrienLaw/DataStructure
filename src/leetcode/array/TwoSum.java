package leetcode.array;

import java.util.HashMap;

public class TwoSum {
    /**
     * 两个数组之和，是否等于一个 目标数
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hashMap.containsKey(complement))
                return new int[] { hashMap.get(complement),i };
            hashMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("Don't fake me");
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] ints = {2, 4, 3, 8};
        int[] sum = twoSum.twoSum(ints, 6);
        for (int i : sum) {
            System.out.println(sum[i]);
        }
    }

}

