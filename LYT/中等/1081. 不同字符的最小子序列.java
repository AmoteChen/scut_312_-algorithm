// 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
// 示例 1：

// 输入："cdadabcc"
// 输出："adbc"
//与LeetCode 316题相同
class Solution {
    public String smallestSubsequence(String s) {
        int[] count = new int[256];
        Stack<Character>result = new Stack<>();
        char[] a = s.toCharArray();
        for(char b:a)
        {
            count[b]++;
        }
        boolean[] inStack = new boolean[256];
        for(char b:a)
        {
            count[b]--;
            if(inStack[b])
                continue;
            while(!result.isEmpty()&&result.peek()>b)
            {
                if(count[result.peek()]==0)
                    break;
                else
                {
                    inStack[result.pop()]=false;
                }
            }
            result.push(b);
            inStack[b]=true;
        }
        StringBuilder sb = new StringBuilder();
        while(!result.isEmpty())
        {
            sb.append(result.pop());
        }
        return sb.reverse().toString();        
    }
}