class MyHashSet(object):
    class Node:
        def __init__(self, key):
            self.key = key
            self.next = None

    def __init__(self):
        print("in init")
        self.head = None
        self.tail = self.head

    def add(self, key):
        new_node = self.Node(key)
        if self.head == None:
            print("creating head", key)
            self.head = new_node
            self.tail = self.head
        else:
            print("creating next node: ", key)
            self.tail.next = new_node
            self.tail = new_node

    def remove(self, key):
        prev, curr = None, self.head
        if self.head is None:
            return
        if self.head and self.tail and key == self.tail.key and key == self.head.key:
            self.head = None
            self.tail = None
            return
        if key == self.head.key:
            self.head = self.head.next
            return
        if key == self.tail.key:
            itr = self.head
            while itr.next is not self.tail:
                itr = itr.next
            itr.next = None
        while curr is not self.tail:
            if curr.key == key:
                prev.next = curr.next
                curr.next = None
                return
            prev = curr
            curr = curr.next


    def contains(self, key):
        itr = self.head
        while itr is not None:
            if itr.key == key:
                return True
            itr = itr.next
        return False


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)