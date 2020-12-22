### LeetCode-155 最小栈

#### [155. 最小栈](https://leetcode-cn.com/problems/min-stack/)

解法1： 栈本身直接存一个数组

```java
class MinStack {
    Stack<int []> stack = new Stack();

    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(new int []{x,x});
        }
        else{
            stack.push(new int [] {x,Math.min(x,stack.peek()[1])});
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}
```



解法2： 辅助栈

```java
class MinStack {
    Stack<Integer> mainStack = new Stack();
    Stack<Integer> supStack = new Stack();

    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        if(mainStack.isEmpty() || x<supStack.peek()){
            supStack.push(x);
        }
        else{
            supStack.push(supStack.peek());
        }
        mainStack.push(x);
    }
    
    public void pop() {
        mainStack.pop();
        supStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return supStack.peek();
    }
}
```

