// 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

// 示例1:

// 输入: pattern = "abba", str = "dog cat cat dog"
// 输出: true

//用hahsmap存放，pattern中每个单词作为一个key，str中的子字符串作为value即可。显然相同的key要有相同的value，否则不通过
//这里可以有两种作法：1.用hashset来判断value是否重复来完成双向鉴定。2.双向映射，即把key和value倒过来，两边都ok即说明符合要求
class Solution{
    public boolean wordPattern(String pattern, String str) {
        HashSet<String> set = new HashSet<>();
        HashMap<Character,String>map =new HashMap<>();
        String[] arr = str.split(" ");
        char[] a = pattern.toCharArray();
        if(arr.length!=a.length)
            return false;
        for(int i=0;i<a.length;i++)
        {
            if(map.containsKey(a[i]))
            {
                if(!map.get(a[i]).equals(arr[i]))
                    return false;
            }
            else{
                if(set.contains(arr[i]))
                    return false;
                else
                {
                    map.put(a[i],arr[i]);
                    set.add(arr[i]);
                }
            }
        }
        return true;
    }
}