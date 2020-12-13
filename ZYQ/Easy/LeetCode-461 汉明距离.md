### LeetCode-461 汉明距离

#### [461. 汉明距离](https://leetcode-cn.com/problems/hamming-distance/)

```java
class Solution {
    public int hammingDistance(int x, int y) {
        int temp = x^y;
        int count =0;
        while(temp != 0){
            count+=temp&1;
            temp>>=1;
        }
        return count;

    }
}
```

题目虽然简单但是可以复习异或、XOR操作。

统计二进制中1的个数，可以用右移+ and1 的操作来实现。