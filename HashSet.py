# Time Complexity : 
    # addition: O(n) - where n is the number of nodes in a linked list at an index of the parent list
    # remove: O(n) - where n is the number of nodes in a linked list at an index of the parent list
    # contains: O(n) - where n is the number of nodes in a linked list at an index of the parent list
# Space Complexity : O (n + m), n is the number of nodes, m is the number of buckets/length of the bucket list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I tried implementing Double Hashing as discussed in class, but didn't understand the rezising based on load factor completely. So, implemented chaining with LinkedList instead.

# Your code here along with comments explaining your approach:
    # - used Linked List Chaining to handle Collisions
    # - Base Data Strcuture is a List
    # - Chose a prime number as the length of the list, to minimise collisions, because the computed mod values will be random
    # - Hash Function Used is Value % Capacity (17)

# new node in a linked list
class NewNode():
    def __init__(self, value):
        self.data = value
        self.next = None

class MyHashSet(object):

    def __init__(self, capacity=17): # chose 17 (prime number) as the length of the list, to randomise collisions
        self.capacity = capacity
        self.size = 0 # size of the list, number of elements in the hash set
        self.bucketList = [None] * self.capacity

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = key % self.capacity # computing the index using the hash function
        if self.bucketList[index] is None:
            # no element exists, so we will add a new one
            self.bucketList[index] = NewNode(key)
            self.size += 1
        else:
            # an element exists at this index, collision
            current = self.bucketList[index] # existing linked list
            while(current):
                if current.data == key:
                    # element already exists
                    # do thing
                    return
                if current.next is None:
                    # last node reached, element did not exist
                    # create new node
                    current.next = NewNode(key)
                    self.size += 1
                    return
                current = current.next

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = key % self.capacity
        
        if self.bucketList[index] is None:
            # element does not exist
            return
        else:
            # linked list exists on that index
            prev = None
            current = self.bucketList[index] # linked list at that index
            while current:
                if current.data == key:
                    # element is found in the LL
                    if prev is None:
                        # its the first element in list
                        self.bucketList[index] = current.next
                        self.size -= 1
                        return

                    else:
                        # its not the first element
                        prev.next = current.next
                        current.next = None
                        self.size -= 1
                        return

                
                # this element is still not found, iterate further
                prev = current
                current = current.next
    

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        index = key % self.capacity
        if self.bucketList[index] is None:
            # element does not exist
            return False
        else:
            current = self.bucketList[index]
            while current:
                if current.data == key:
                    # element exists, return True
                    return True
                
                current = current.next

            # element not found
            return False

        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)