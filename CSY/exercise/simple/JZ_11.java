/***
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入:一个递增排序的数组的一个旋转
 * 输出:旋转数组的最小元素。
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 */






public class JZ_11 {

    public int minArray(int[] numbers) {
        int length = numbers.length;
        if (length == 1){
            return numbers[0];
        }
        for (int i = 0; i < length-1; i++) {
            if (numbers[i] > numbers[i+1]) {
                return numbers[i+1];
            }
        }
        return numbers[0];
    }
}

/***
 上述的过程是暴力的遍历法；
 时间复杂度：O(n)
 空间复杂度：O(1)

 如果用二分查找法呢？
 时间复杂度:O(log n)
 空间复杂度：O(1)
 左中右，前后都是两个有序数组，就看Mid跟最后的值的大小，判定mid是处于哪个数组
 */
