Explain your approach in **three sentences only** at top of your code

# Design-1

## Problem 1:(https://leetcode.com/problems/design-hashset/)

First created 1000 length array of pointers with pointers initialized to null.
Implemented double hashing and found out exact constant place for each element in the array.
In add operation added the element in that place in remove operation removed the element from same location by setting it to false and lastly in contains operation checked the value at the computed location and returned the value



## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)

First initialize 2 stacks. Initialize min variable with maximum integer value.
With every push operation push an element in first stack and if the element is less than or equal to current minimum then push it into min stack as well.
In pop operation if the element popping out from first stack is current minimum then pop one element from min stack as well.
We are storing current minimum in min variable so we can always return min in getMin method.
In peek method we can just peek from main stack.



