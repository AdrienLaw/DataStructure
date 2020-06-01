package leetcode.array;

/**
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 *
 */
public class RemoveDuplicatesFromArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 1){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        int i = 0;
        int j = 1;
        int count = 1;
        while(j < nums.length){
            if (nums[j] == nums[i]){
                j++;
            }else{
                int b = nums[i+1];
                nums[i+1] = nums[j];
                nums[j] = b;
                i++;
                j++;
                count++;
            }
        }
        return count;
    }



    public static void main(String[] args) {
        RemoveDuplicatesFromArray removeDuplicatesFromArray = new RemoveDuplicatesFromArray();
        int[] ints = {1,1,2,4,5,6,7,2};
        int duplicates = removeDuplicatesFromArray.removeDuplicates(ints);
        System.out.println(duplicates);

    }
}
