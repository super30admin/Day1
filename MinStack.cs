// Time Complexity : O(1) for all operations
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// we can use built in stack to implement min stack. We will keep track of min element in the stack. 
// When we push element, we will check if the element is less than or equal to min element, if yes, we will push the min element first and then the element.
// When we pop element, we will check if the element is equal to min element, if yes, we will pop the element twice.

public class MinStack {
      
    Stack<int> myStack;
    int min;

    public MinStack() {
      myStack = new Stack<int>();  
      min = Int32.MaxValue;
    }
    
    public void Push(int val) {
        if( val <= min)
        {
            myStack.Push(min);
            min = val;
        }
        myStack.Push(val);
    }
    
    public void Pop() {
       int popped = myStack.Pop();
       if(popped == min) 
       {
        min = myStack.Pop();
       }
    }
    
    public int Top() {
        return myStack.Peek();
    }
    
    public int GetMin() {
        return min;
    }
}
