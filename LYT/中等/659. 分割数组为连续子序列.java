// 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。

// 如果可以完成上述分割，则返回 true ；否则，返回 false 。

// 示例 1：

// 输入: [1,2,3,3,4,5]
// 输出: True
// 解释:
// 你可以分割出这样两个连续子序列 : 
// 1, 2, 3
// 3, 4, 5
//这tm是中等？？
//哈希表 + 最小堆
//哈希表的键为子序列的最后一个数字，值为最小堆，用于存储所有的子序列长度，最小堆满足堆顶的元素是最小的，因此堆顶的元素即为最小的子序列长度。
// 遍历数组，当遍历到元素 x 时，可以得到一个以 x 结尾的子序列。
// 如果哈希表中存在以 x-1结尾的子序列，则取出以 x-1 结尾的最小的子序列长度，将子序列长度加 1之后作为以 x结尾的子序列长度。此时，以x-1结尾的子序列减少了一个，以 x 结尾的子序列增加了一个。
// 如果哈希表中不存在以 x-1 结尾的子序列，则新建一个长度为 1 的以 x 结尾的子序列。
// 由于数组是有序的，因此当遍历到元素x 时，数组中所有小于 x 的元素都已经被遍历过，不会出现当前元素比之前的元素小的情况。
// 遍历结束之后，检查哈希表中存储的每个子序列的长度是否都不小于 3，即可判断是否可以完成分割。由于哈希表中的每条记录的值都是最小堆，堆顶元素为最小的子序列长度（以当前的键为最后一个数字的子序列），因此只要遍历每个最小堆的堆顶元素，即可判断每个子序列的长度是否都不小于 3。
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
        for (int x : nums) {
            if (!map.containsKey(x)) {
                map.put(x, new PriorityQueue<Integer>());
            }
            if (map.containsKey(x - 1)) {
                int prevLength = map.get(x - 1).poll();
                if (map.get(x - 1).isEmpty()) {
                    map.remove(x - 1);
                }
                map.get(x).offer(prevLength + 1);
            } else {
                map.get(x).offer(1);
            }
        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }
}