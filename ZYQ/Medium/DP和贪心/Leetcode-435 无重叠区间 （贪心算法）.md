### Leetcode-435 无重叠区间 （贪心算法）

思路：用贪心策略反向来求：

1.  先根据区间的右端，给数组重新排序。这一步要重写comparator。

2.  从排好序的数组中选择结束最早的区间x（end最小的）

3.  把与x区间重合的区间删除

4.  重复2~3步直至最后一个区间

   这样我们得到的最终数组就是“最多的不重叠的区间”。而题目要求的是“需要移除的区间最少数量”。我们用原数组的长度length减去求得的“最多的不重叠的区间”，就能得到答案。

   优化：如何删除与x区间重合的区间？我们已经对数组排了序，因此如果下一个区间和x重合，

   那么下一个区间的start必定小于x区间的end。

   因此我们可以用一个count来计数，用current_end来表示当前选中的x区间的end值，

   然后我们遍历一次排好序的结果集，每次循环先更新start为当前的区间头，当start小于current_end的时候，说明当前区间和x区间不重叠，我们进行count++；用来计算“最多的不重叠区间”，并更新current_end。

   注意点：

   （1） 不要直接用count来求题目要求的“最少删除区间数”，这样思路不够清晰，容易出错。

   （2） 写在代码里了。给诸如current_end和start这种与具体的输入数据有关的变量赋初值的时候，一定要想清楚初值所有可能的取值范围，不要直接赋给0，默认人家大于零。区间也可以是[-100,-2]，不一定是大于零的。惯性思维很容易白给。

   AC代码：

   ```java
   public int eraseOverlapIntervals(int[][] intervals) {
       if(intervals.length == 0) return 0;
       Arrays.sort(intervals,new Comparator<int []>(){
           public int compare(int [] a, int [] b){
               return a[1]-b[1];
           }
       });
       int start =intervals[0][0];
       // 我大意了啊，没有闪：谁说current_end一定是从0开始的？[-100,-2]的current_end是小于0的。
       // 切记不要乱给变量赋初值
       // 原代码：int current_end = 0;
       // count = 0;
       int current_end = intervals[0][1];
       int count = 1;
       for(int [] interval : intervals){
           start = interval[0];
           if(start >= current_end){
               count++;
               current_end = interval[1];
           }
       }
       return intervals.length - count;
   }
   ```

ps：这个东西讲道理，一下子想不出来的，记住就好了。评论区有人论证这个方法的正确性，就不跟数学家们计较了

