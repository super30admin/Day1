import java.util.Stack;

// class MinStack {

//    Stack<Integer> stack;
//    Stack<Integer> minStack;
//    // have a minStack to keep track of the minimum value at every step
//    // when we push a value, we push it to the minStack if it is smaller than the current minimum
//    // when we pop a value, we pop it from the minStack as well
//     public MinStack() {
//         stack = new Stack<>();
//         minStack = new Stack<>();
//     }
    
//     public void push(int val) {
//         if (minStack.isEmpty() || val < minStack.peek()){
//             minStack.push(val);
//         } else {
//             minStack.push(minStack.peek());
//         }
//         stack.push (val);
        
//     }
    
//     public void pop() {
       
//         stack.pop();
//         minStack.pop(); 
//     }
    
//     public int top() {
       
//         return stack.peek(); 
//     }
    
//     public int getMin() {
       
//         return minStack.peek() ; 
//     }
// }

// second attempt - single stack method
class MinStack {

    Stack<Integer> stack;
 //    Stack<Integer> minStack;
     int min;
     public MinStack() {
         stack = new Stack<>();
         // minStack = new Stack<>();
         min = Integer.MAX_VALUE;
     }
     
     public void push(int val) {
         //  if (minStack.isEmpty() || val < minStack.peek()){
         //     minStack.push(val);
         // } else {
         //     minStack.push(minStack.peek());
         // }
         // stack.push (val);
        if (val <= min){
         stack.push(min);
         min = val;
        }
        stack.push (val);
     }
     
     public void pop() {
         // stack.pop();
         // minStack.pop();
         int popped = stack.pop();
         if (popped ==min){
             min = stack.pop();
         }
     }
     
     public int top() {
         return stack.peek();
     }
     
     public int getMin() {
 
         // return minStack.peek() ;
         return min;
     }
 }
 
 /**
  * Your MinStack object will be instantiated and called as such:
  * MinStack obj = new MinStack();
  * obj.push(val);
  * obj.pop();
  * int param_3 = obj.top();
  * int param_4 = obj.getMin();
  */

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */