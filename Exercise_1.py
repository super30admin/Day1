// Time Complexity :   O(1)
// Space Complexity :   O(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Runtime error, syntax error


// Your code here along with comments explaining your approach
class MyHashSet(object):

    def __init__(self):
        self.bucket = 1000
        self.bucketitems = 1000
        self.bucketArray = [[]*self.bucketitems] * self.bucket
        print("Type of bucketArray: ", type(self.bucketArray[0]))

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucketIndex = key % 1000
        print("Here bucketIndex: ", (key % 1000) )
        bucketItemIndex = key // 1000
        print("Here bucketItemIndex: ", (key // 1000) )
        if (not self.bucketArray[bucketIndex]):
            if bucketIndex == 0:
                #print("Here: ", self.bucketitems + 1 )
                self.bucketArray[bucketIndex] = [False] * (self.bucketitems + 1)
            else:
                self.bucketArray[bucketIndex] = [False] * self.bucketitems
        self.bucketArray[bucketIndex][bucketItemIndex] = True


    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucketIndex = key % 1000
        bucketItemIndex = int(key // 1000)
        if (self.bucketArray[bucketIndex] == None):
            return 
        self.bucketArray[bucketIndex][bucketItemIndex] = False

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        bucketIndex = key % 1000
        bucketItemIndex = key // 1000
        if (self.bucketArray[bucketIndex] == None):
            return False
        return self.bucketArray[bucketIndex][bucketItemIndex]
