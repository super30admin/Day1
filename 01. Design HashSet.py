class Node:
    def __init__(self, key):
        self.key = key
        self.next = None


class MyHashSet:

    def __init__(self):
        self.hashSet = [Node(0) for i in range(10 ** 4)]

    def add(self, key: int) -> None:
        curr = self.currElement(key)

        while curr.next:
            if curr.next.key == key:
                return
            curr = curr.next
        curr.next = Node(key)

    def remove(self, key: int) -> None:
        curr = self.currElement(key)

        while curr.next:
            if curr.next.key == key:
                curr.next = curr.next.next
                return
            curr = curr.next

    def contains(self, key: int) -> bool:
        curr = self.currElement(key)

        while curr.next:
            if curr.next.key == key:
                return True
            curr = curr.next

        return False

    def currElement(self, key):
        return self.hashSet[key % len(self.hashSet)]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
