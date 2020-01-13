package leetcode;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 *
 * -----------------
 *
 * 示例 2:
 *
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 注意这五个元素可为任意顺序。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 *
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {1,3,4,5,6,8,3};
        int value = 3;
        int element = removeElement(nums, value);
        System.out.println(element);
    }


    public static int removeElement(int[] nums, int val) {

        //当数组元素为0时直接返回null
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //定义一个可替换下标指针，从第一个元素开始
        int index = 0;
        //定义没有指定元素的数组长度
        int newLength = 0;

        //定义一个遍历指针，从第一个元素开始，要小于数组大小
        int p = 0;
        while (p < nums.length) {
            /**
             * 当前元素与指定数字不相等时，
             * 给index处下标赋值为p处下标的值，
             * 并且index+1和没有指定元素的数组长度加1
             */
            if (nums[p]!= val) {
                nums[index ++] = nums[p];
                newLength ++;
            }
            p ++;
        }
        return newLength;
    }
}
