/*
Time Complexity : O(1) for user oriented functions no extra data structure is created in push, pop, top and getMin
Space Complexity : O(1) for user oriented functions as no extra data structure is created in push, pop, top and getMin
Did this code successfully run on Leetcode : Yes

Explanation:
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    Stack: LIFO, if we are being asked to not use stack then we can use ArrayList or LinkedList

    Constraint: Methods pop, top and getMin operations will always be called on non-empty stacks.
    So stack isEmpty() not required to check.

    The solution can be implemented with two approach:
    1) Having 2 stacks: (I) We are storing minimum value in min stack even if it doesn't change, check new Java class => MinStackDoubleStackWithMinRepetitions
                        (II) Other approach within this is to not repeat min values in minStack,

    2) Having single stack: If the requirement is to not store min value always and only store when it changes, we can use this approach and single stack

    (II) We are implementing 2nd approach using 2 stacks. In this the min value is not repeatedly stored in minStack.
         Here we are not using min constant

  elementStack               minStack
    3              ->
    12             ->
    4              ->           3
    9              ->           4
    5              ->           5
                               Infinity

 */

import java.util.Stack;

class MinStackDoubleStackWithoutMinRepetitions {

    Stack<Integer> elementStack; //To Store the elements
    Stack<Integer> minStack; //To store minimum

    public MinStackDoubleStackWithoutMinRepetitions()
    {
        this.elementStack = new Stack<>();
        this.minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val)
    {

        elementStack.push(val);

        // Only push to minStack if the new value is less than or equal to the current minimum
        if (val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop()
    {
        // If the element being popped is the current minimum, pop from minStack as well
        if (elementStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        elementStack.pop();
    }

    public int top() {
        //This will be giving the current value present in elementStack
        return elementStack.peek();
    }

    public int getMin() {
        return minStack.peek();
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