#Time Complexity : O(1) for add, remove and contains
#Space Complexity : Probably O(n), where n is the number of nodes located st that specific index
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


#Your code here along with comments explaining your approach


class ListNode:
    def __init__(self,key):
        self.key=key
        self.next=None
class MyHashSet:

    def __init__(self):
        self.size = [ListNode(0) for i in range(10**4)] 

    def add(self, key: int) -> None:
        index = key % len(self.size)
        curr = self.size[index]
        while curr.next:
            if curr.next.key==key:
                return
            curr = curr.next
        curr.next = ListNode(key)


    def remove(self, key: int) -> None:
        index = key%len(self.size)  

        curr = self.size[index]
        while curr.next:
            if curr.next.key==key:
                curr.next=curr.next.next
                return
            curr=curr.next
              

    def contains(self, key: int) -> bool:
        index = key % len(self.size)
        curr = self.size[index]
        while curr.next:
            if curr.next.key == key:
                print(curr.key)
                return True
            curr = curr.next
        return False



# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(2)
obj.contains(3)
obj.add(2)
obj.contains(2)
obj.remove(2)
obj.contains(2)