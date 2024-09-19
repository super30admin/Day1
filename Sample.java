// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// self.arrayBucket = [[]] * 1000
// might seem like it creates 1000 individual empty lists, but what it actually does is create 1000 references to the same list.
// This means that modifying one of the sublists will affect all the others because they all refer to the same object in memory.
// Thus use self.arrayBucket = [[] for _ in range(1000)]
// Your code here along with comments explaining your approach

// Both list and deque have O(1) time complexity for push, pop, and peek operations when used as stacks.
// Lists have some overhead due to occasional resizing when the list exceeds its capacity
//  (though this happens in amortized O(1) time, not per operation).
// deque is designed for efficient appending and popping from both ends, so if you need
// a stack with more flexibility or want to avoid the dynamic resizing of lists, deque is slightly better in terms
// of performance stability.