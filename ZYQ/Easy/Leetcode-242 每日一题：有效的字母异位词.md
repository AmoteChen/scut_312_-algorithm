Leetcode-242 每日一题：有效的字母异位词

[有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)

11.22 今天的每日一题是简单题，爷重拳出击

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length != t.length) return false;
        int [] map = new int [128];
        int [] map2 = new int [128];
        for(char ch : s.toCharArray()){
            map[ch]+=1;
        }
        for(char ch:t.toCharArray()){
            map2[ch]+=1;
        }
        for(int i=47;i<122;i++){
            if(map[i]!=map2[i]) return false;
        }
        return true;
    }
}
```

思路: ASCII码的范围就是1~128.其实比较47~122就能搞定大小写字母和数字了。题目字符串更是只有26个小写字母组成。

方法二：排序

