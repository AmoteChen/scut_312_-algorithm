import java.util.HashMap;

/***
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *输入: s = ""
 * 输出: 0
 */



public class UniqueString {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Integer, Character> catcher = new HashMap<Integer,Character>();

        int result = 1;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (catcher.containsValue(s.charAt(i))) {
                result = i-left;
                for(int key: catcher.keySet()){
                    if(catcher.get(key).equals(s.charAt(i))){
                        left = key+1;
                        int temp = lengthOfLongestSubstring(s.substring(left));
                        result = Math.max(result, temp);
                        return result;
                    }
                }
            } else {
                catcher.put(i, s.charAt(i));
                result = i-left+1;
            }
        }
        if(s.length() ==0){
            return 0;
        }
        return result;

    }

    public static void main(String[] args) {
        String test = "abcdefdghijklmn";
        UniqueString tester = new UniqueString();
        System.out.println(tester.lengthOfLongestSubstring(test));
    }
}
