class Node:
    def __init__(self, key=None):
        self.key = key
        self.next = None

class MyHashSet(object):

    def __init__(self):
        self.arr = [Node() for _ in range(10**4)]

    def add(self, key):
        cur = self.arr[key % len(self.arr)]
        while cur.next:
            if cur.next.key == key:  
                return
            cur = cur.next
        cur.next = Node(key)  

    def remove(self, key):
        cur = self.arr[key % len(self.arr)]
        while cur.next:
            if cur.next.key == key:
                cur.next = cur.next.next  
                return
            cur = cur.next

    def contains(self, key):
        cur = self.arr[key % len(self.arr)]
        while cur.next:
            if cur.next.key == key:
                return True
            cur = cur.next
        return False 
