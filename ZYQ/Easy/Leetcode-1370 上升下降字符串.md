Leetcode-1370 上升下降字符串

思路：桶。小写字母一共26个，用26个桶来统计字符数量。然后每次从头到尾拿，再从尾到头拿，直到

桶空了为止。

```java
class Solution {
    public String sortString(String s) {
        int [] nums = new int [26];
        int length = s.length();
        for (char ch : s.toCharArray()
        ) {
            nums[ch-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index<length){
            for(int i=0;i<26;i++){
                if(nums[i]>0){
                    sb.append((char)(i+97));
                    nums[i]--;
                    index++;
                }
            }
            for(int j=25;j>=0;j--){
                if(nums[j]>0){
                    sb.append((char)(j+97));
                    nums[j]--;
                    index++;
                }
            }
        }
        return sb.toString();
    }
}
```

