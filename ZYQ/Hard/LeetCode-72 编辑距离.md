### LeetCode-72 编辑距离



经典dp问题

i，j表示word1长度为i，word2长度为j的时候，word1转换成word2所需的最少操作

首先分两种大情况：

1. word1的i位置的字符，与word2 的 j位置的字符相等

2. 上述情况不相等

   对于第一种情况，只需dp[i] [j] = d[i-1] [j-1]  因为字符相等，不需要做新的替换、删除、 插入操作

   对于第二种情况，有三种操作能让他们相等：

   （1）删除一个字符。那么dp[i] [j] = dp[i-1] [j] + 1 

   （2）替换word1[i]的字符，让它和word2[j]相等。  那么 dp[i] [j] = dp[i-1] [j-1] + 1

   （3）插入一个字符，该字符等于word2[j]。那么 dp[i] [j] = dp[i] [j-1] + 1

```java
class Solution {
    public int minDistance(String word1, String word2) {
        // dp[i][j] 表示：word1长度为i的时候，word2长度为j的时候，word1转换成word2所需的最少操作数。
        int length1 = word1.length();
        int length2 = word2.length();

        int [][] dp = new int [length1+1][length2+1];
        // 初始化
        for(int i=1;i<=length1;i++){
            dp[i][0]=dp[i-1][0]+1;
        }
        for(int j=1;j<=length2;j++){
            dp[0][j]=dp[0][j-1]+1;
        }

        for(int i=1;i<=length1;i++){
            for(int j=1;j<=length2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                }
            }
        }
        return dp[length1][length2];
    }
}
```

