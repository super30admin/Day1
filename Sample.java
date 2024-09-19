// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
// self.arrayBucket = [[]] * 1000
// might seem like it creates 1000 individual empty lists, but what it actually does is create 1000 references to the same list.
// This means that modifying one of the sublists will affect all the others because they all refer to the same object in memory.
// Thus use self.arrayBucket = [[] for _ in range(1000)]
// Your code here along with comments explaining your approach
