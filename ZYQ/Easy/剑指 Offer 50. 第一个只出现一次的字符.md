### 剑指 Offer 50. 第一个只出现一次的字符

#### [剑指 Offer 50. 第一个只出现一次的字符](https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/)



```java
class Solution {
    public char firstUniqChar(String s) {
        if(s.length()<=0)return ' ';
        int [] temp = new int [26];
        char [] chs=s.toCharArray(); 
        for(char ch:chs){
            temp[ch-'a']+=1;
        }
        for(char ch:chs){
            if(temp[ch-'a']==1) return ch;
        }
        return ' ';
    }
}
```



简单题我重拳出击：击败99.4%的玩家