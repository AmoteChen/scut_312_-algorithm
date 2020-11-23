/*一个栈中元素为整型，现在将这个栈从顶到底按从大到小的顺序排序，只允许申请一个栈，不能申请额外的数据结构*/
public static void sortStackByStack(Stack<Integer> stack)
    {
        Stack<Integer> help=new Stack<>();
        while (!stack.isEmpty())
        {
            int cur = stack.pop();
            if (!help.isEmpty()) {
                while (cur > help.peek()&&!help.isEmpty()) {
                    stack.push(help.pop());
                }
            }
            help.push(cur);
        }
        while (!help.isEmpty())
        {
            stack.push(help.pop());//排序结束，放回原栈
        }
    }