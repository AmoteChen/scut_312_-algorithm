
import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *

 */
public class TwoNum {
    Scanner scanner = new Scanner(System.in);

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int j = 0; j < length; j++) {
        for (int i = 0; i < length; i++) {
            int another = target - nums[j];
            if (nums[i]==another && i!=j){
                int[] result ={j,i};

                return result;
                }
            }
        }
        return null;
    }
    //用于键盘获取数组
    public int[] getText(){
        String inputText = scanner.nextLine().toString();

        String arrayText = inputText.substring(1,inputText.length()-1);
        String[] arr  = arrayText.split(",");
        int[] array = new int[ arr.length];
        for (int i = 0; i <  arr.length; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }
        return array;
    }

public static void main(String[] args) {
    TwoNum tester = new TwoNum();
    System.out.println("请输入待测试数组：");
    int []array = tester.getText();
    System.out.println("请输入目标值：");
    int target = tester.scanner.nextInt();

    System.out.println(Arrays.toString(tester.twoSum(array,target)));

    }
}