'''
    Initialised a python list of length 1000 with dummy nodes. 
    Each of these element is the hashKey and the element consists of a linked list of values. 
    The values will be manipulated from these linkedlists.
'''

class ListNode:
    def __init__(self, key=-1, next=None):
        self.key = key
        self.next = next

class MyHashSet:

    def __init__(self):
        self.hashSet = [ListNode(0) for i in range(1000)]

    def hash(self, key: int):
        return key % len(self.hashSet)

    def add(self, key: int) -> None:
        cur = self.hashSet[self.hash(key)]
        new_node = ListNode(key)

        while cur.next:
            if cur.next.key == key:
                return
            cur = cur.next

        cur.next = new_node

    def remove(self, key: int) -> None:
        cur = self.hashSet[self.hash(key)]

        while cur.next: 
            if cur.next.key == key:
                cur.next = cur.next.next
                return

            cur = cur.next

    def contains(self, key: int) -> bool:
        cur = self.hashSet[self.hash(key)]

        while cur.next:
            if cur.next.key == key:
                return True

        return False