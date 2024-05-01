package leetCode.Stack.Medium;

import java.util.Stack;

public class MinStack_155 {
    static class MinStack{
        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack(){
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val){
            stack.push(val);

            if(this.minStack.size() == 0 || val <= this.getMin()){
                this.minStack.push(val);
            }
        }

        public void pop(){
            int poppedVal = this.stack.pop();
            if(poppedVal == this.getMin())
                this.minStack.pop();
        }

        public int top(){
            // Since all calls are made on non-empty stack
            return this.stack.get(this.stack.size() - 1);
        }

        public int getMin(){
            return this.minStack.get(this.minStack.size() - 1);
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
