### LeetCode-20 有效的括号

#### [20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char ch : s.toCharArray()){
            switch (ch){
                case '(':stack.push(')');break;
                case '[':stack.push(']');break;
                case '{':stack.push('}');break;
                default:if(stack.isEmpty() || ch!=stack.pop())return false;
            }
        }
        if(!stack.isEmpty())return false;
        return true;
    }
}
```

值得注意的点：我们可以换个思维，当匹配到左括号'('的时候，我们把右括号放到栈里面，这样在遇到右括号的时候可以直接比较栈顶元素。

而不是说遇到什么就把什么压入栈中。思维很重要= =