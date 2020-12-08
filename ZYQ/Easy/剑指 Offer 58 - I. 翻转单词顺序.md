#### 剑指 Offer 58 - I. 翻转单词顺序

#### [剑指 Offer 58 - I. 翻转单词顺序](https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/)

```java
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String [] arr = s.trim().split(" ");
        for(int i=arr.length-1; i>=0;i--){
            if(!arr[i].equals(""))
            sb.append(arr[i].trim()+" ");
        }
        return sb.toString().trim();
    }
}
```

point： 记得判断一下空字符串，因为split()函数在遇到连续的x>1个空格的时候，会返回x-1个空字符串。

