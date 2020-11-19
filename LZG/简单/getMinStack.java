//实现getMin栈，要求pop、push、getMin操作时间复杂度都是O(1);

 public class Stack1{
        private Stack<Integer> StackData;
        private Stack<Integer> StackMin;

        public Stack1(){
            this.StackData=new Stack<Integer>();
            this.StackMin=new Stack<Integer>();
        }
        
        public int getmin(){
            if(this.StackMin.isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            return this.StackMin.pop();
        }

        public void push(int newNum){
            if(this.StackMin.isEmpty())
            {
                this.StackMin.push(newNum);
            }else if(newNum<=this.getmin()){
                this.StackMin.push(newNum);
            }
            this.StackData.push(newNum);
        }
        public int pop(){
            if(this.StackData.isEmpty()){
                throw new RuntimeException("stack is Empty");
            }
            int value =this.StackData.pop();
            if(value == this.getmin()){
                this.StackMin.pop();
            }
            return value;
        }


    }