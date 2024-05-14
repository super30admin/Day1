import java.util.Stack;
class MinStack {

    //Using one stack
    //Time Complexity = O(1)
    //Space Complexity = O(n)

    Stack<Integer> stack = new Stack<Integer>();
    int min = Integer.MAX_VALUE;

    void push(int x) {
        //if the new element is smaller than the current min, push the current min onto stack
        //so as to maintain the current min when new element is popped

        if(x <= min) {
            stack.push(min);
            min = x;
        }

        stack.push(x);
    }

    void pop() {
        //if the popped element is the min, then pop the last extra min element again and set that to current min
        if(stack.pop() == min) min = stack.pop();
    }

    int top() {
        return stack.peek();
    }

    int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(5);
        obj.push(1);
        obj.push(2);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_3);
        System.out.println(param_4);
    }

}