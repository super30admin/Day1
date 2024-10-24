import java.util.Stack;

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
                        (II) Other approach within this is to not repeat min values in minStack, check new Java class => MinStackDoubleStackWithoutMinRepetitions

    2) Having single stack: If the requirement is to not store min value always and only store when it changes, we can use this approach and single stack

    2. Approach => Single Stack

    ElementStack: 5,9,4,4,11
        11
        4 -> curr element
        4 -> prev min
        4 -> curr element
        5 -> prev min
        9
        5
        Infinity
 */

class MinStackSingleStack {

    Stack<Integer> elementStack; //To Store the elements
    int min;

    public MinStackSingleStack()
    {
        this.elementStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val)
    {
        /*
        If min changes, we will be pushing previous minimum and set the minimum, if min doesn't change we are just pushing the value.
        Here we are also checking if min is equal to value, reason is, if we only push when min is greater than value, while popping the last min,
        it will not be present in stack {refer lecture video}
         */
        if(min >= val)
        {
            elementStack.push(min);
            min = val;
        }
        elementStack.push(val);
    }

    public void pop()
    {
        /*
            If the element we are popping is the current minimum, we will pop twice, but if the current element is not equal to min then only one element will be popped
            Thing to understand is elementStack.pop(), the first one is also popping the element along with comparing to min, so we do not have to explicitly write
            elementStack.pop() again in end as it will be incorrect {because it would be popping twice if the min is not equal and popping thrice is min is equal}

        */
        if(min == elementStack.pop()) {
            min = elementStack.pop();
        }
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