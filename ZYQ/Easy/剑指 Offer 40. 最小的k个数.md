### 剑指 Offer 40. 最小的k个数

#### [剑指 Offer 40. 最小的k个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)

1.  维护一个大小为k的最大堆，遍历一次数组，小的放进来，大于堆顶元素的就跳过。

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int [] res = new int [k];
        if(k<=0)return res;
        PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>(){
            public int compare(Integer num1, Integer num2){
                return num2-num1;
            }
        });
        for(int i=0;i<k;i++){
            pq.offer(arr[i]);
        }
        for(int j=k;j<arr.length;j++){
            if(arr[j]<pq.peek()){
                pq.poll();
                pq.offer(arr[j]);
            }
        }
        for(int i=0;i<res.length;i++){
            res[i]=pq.poll();
        }
        return res;
    }
}
```

21ms

2. Arrays.sort() 让面试官直接明天发朋友圈嘲笑面试者的智商

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int [] res = new int [k];
        for(int i=0;i<k;i++){
            res[i]=arr[i];
        }
        return res;
    }
}

```

8ms

3. 快速排序思路分治法

   ```java
   class Solution {
       public int[] getLeastNumbers(int[] arr, int k) {
           randomizedSelected(arr, 0, arr.length - 1, k);
           int[] vec = new int[k];
           for (int i = 0; i < k; ++i) {
               vec[i] = arr[i];
           }
           return vec;
       }
   
       public void randomizedSelected(int[] arr, int l, int r, int k) {
           if (l >= r) {
               return;
           }
           int pos = randomizedPartition(arr, l, r);
           int num = pos - l + 1;
           if (k == num) {
               return;
           } else if (k < num) {
               randomizedSelected(arr, l, pos - 1, k);
           } else {
               randomizedSelected(arr, pos + 1, r, k - num);
           }
       }
   
       // 基于随机的划分
       public int randomizedPartition(int[] nums, int l, int r) {
           int i = new Random().nextInt(r - l + 1) + l;
           swap(nums, r, i);
           return partition(nums, l, r);
       }
   
       public int partition(int[] nums, int l, int r) {
           int pivot = nums[r];
           int i = l - 1;
           for (int j = l; j <= r - 1; ++j) {
               if (nums[j] <= pivot) {
                   i = i + 1;
                   swap(nums, i, j);
               }
           }
           swap(nums, i + 1, r);
           return i + 1;
       }
   
       private void swap(int[] nums, int i, int j) {
           int temp = nums[i];
           nums[i] = nums[j];
           nums[j] = temp;
       }
   }
   ```

   

我觉得这道题最不河狸的地方

就是为什么直接Arrays.sort()

比建堆快多了。。。