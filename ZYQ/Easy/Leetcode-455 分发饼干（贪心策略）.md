Leetcode-455 分发饼干（贪心策略）

解决思路：用尽可能小的饼干，满足胃口尽可能大的孩子。

1. 将两个数组排序

2. 从前往后逐个比较两个数组的元素，如果size>grid，则说明当前饼干能满足当前孩子，那么计数器size++，grid++。如果不能满足，那么该饼干就没有实际用途，size++。因此无论如何一轮遍历过程中size都会加一，最终grid下标就是我们的答案（满足了几个孩子，grid下标i就在哪）。



```java
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(g == null || s ==null) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        int glen=g.length;
        int slen=s.length;
        while(i<g.length && j<s.length){
            if(g[i]<=s[j]){
                i++;
            }
            j++;
        }
        return i;
    }
}
```

