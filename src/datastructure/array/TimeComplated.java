package datastructure.array;

public class TimeComplated {
    public static int sum(int[] nums){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
