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
    1) Having 2 stacks: (I) We are storing minimum value in min stack even if it doesn't change,
                        (II) Other approach within this is to not repeat min values in minStack, check new Java class => MinStackDoubleStackWithoutMinRepetitions

    2) Having single stack: If the requirement is to not store min value always and only store when it changes, we can use this approach and single stack

   (I) We are implementing 1st approach using 2 stacks. This is the current approach where min is repeated in minStack

    elementStack               minStack
    3              ->           3
    12             ->           4
    4              ->           4
    9              ->           5
    5              ->           5
                               Infinity

   (II) In this the min value is not repeatedly stored in minStack

 */

import java.util.Stack;

class MinStackDoubleStackWithMinRepetitions {

    Stack<Integer> elementStack; //To Store the elements
    Stack<Integer> minStack; //To store minimum
    int min;

    public MinStackDoubleStackWithMinRepetitions()
    {
        this.elementStack = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minStack.push(min);
    }

    public void push(int val)
    {
        /*
        (I)
        Before pushing, we need to compare the incoming element with min value, then push the element in elementStack and min in minStack
        */
        min = Math.min(val, min);
        elementStack.push(val);
        minStack.push(min);
    }

    public void pop()
    {
        /*
        (I)
        As when we push the value in stack, we also push the minimum associated with it, basically the min at that point, so when we try to pop,
        we have to pop from both the stack and then assign the value of min to previous min which may or may not be the same value
        */
        elementStack. pop();
        minStack.pop();
        min = minStack.peek();
    }

    public int top() {
        //This will be giving the current value present in elementStack
        return elementStack.peek();
    }

    public int getMin() {
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