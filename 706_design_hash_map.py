class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None


class LinkedList:
    def __init__(self):
        self.root = None

    def add(self, key, value):
        cur = self.root
        if not cur:
            self.root = Node(key, value)
        else:
            while cur:
                if cur.key == key:
                    cur.value = value
                    return
                elif cur.next is None:
                    cur.next = Node(key, value)
                    return
                cur = cur.next

    def remove(self, key):
        prev = self.root
        cur = self.root
        while cur:
            if cur.key == key:
                prev.next = cur.next
                return
            prev = cur
            cur = cur.next

    def get(self, key):
        cur = self.root
        while cur:
            if cur.key == key:
                return cur.value
            cur = cur.next
        return -1


class MyHashMap:
    """
        Time Complexity:
            O(1)
            if we can make sure the linked list chain is of certain size.
            If it extends we double the size of the hastable and rehash all the values.
        Space Complexity:
            O(m + n)
            'm' is the size of the hash table and 'n' is the number of nodes
        // Did this code successfully run on Leetcode :
            Yes
        // Any problem you faced while coding this :
            Was trying various approach. Was stuck at adjusting pointers
        // Your code here along with comments explaining your approach
            I am using the chaining method to create a hash map.
            A list of linked lists is used to store each key and value using
            a simple hash function.
    """

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.max = 1000
        self.hash_table = [LinkedList()] * self.max

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        self.hash_table[self._get_hash(key)].add(key, value)

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        return self.hash_table[self._get_hash(key)].get(key)

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        self.hash_table[self._get_hash(key)].remove(key)

    def _get_hash(self, index: int) -> int:
        return index % self.max


"""
 Approach 1
"""
# class MyHashMap:
#
#     def __init__(self):
#         """
#         Initialize your data structure here.
#         """
#         self.arr = []
#
#     def put(self, key: int, value: int) -> None:
#         """
#         value will always be non-negative.
#         """
#         for data in self.arr:
#             if data[0] == key:
#                 self.arr.remove(data)
#         self.arr.append((key, value))
#
#     def get(self, key: int) -> int:
#         """
#         Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
#         """
#         for data in self.arr:
#             if data[0] == key:
#                 return data[1]
#         return -1
#
#     def remove(self, key: int) -> None:
#         """
#         Removes the mapping of the specified value key if this map contains a mapping for the key
#         """
#         self.arr = list(filter(lambda item: item[0] != key, self.arr))
#
#
# # Your MyHashMap object will be instantiated and called as such:
# # obj = MyHashMap()
# # obj.put(key,value)
# # param_2 = obj.get(key)
# # obj.remove(key)

"""
 Approach 2
"""

# class MyHashMap:
#
#     def __init__(self):
#         """
#         Initialize your data structure here.
#         """
#         self.arr = [None for i in range(1000000)]
#
#     def put(self, key: int, value: int) -> None:
#         """
#         value will always be non-negative.
#         """
#         self.arr[key] = value
#         return self.arr[key]
#
#     def get(self, key: int) -> int:
#         """
#         Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
#         """
#         if key < len(self.arr) and self.arr[key] is not None:
#             return self.arr[key]
#         return -1
#
#     def remove(self, key: int) -> None:
#         """
#         Removes the mapping of the specified value key if this map contains a mapping for the key
#         """
#         if key < len(self.arr):
#             self.arr[key] = None
#
#
#
# # Your MyHashMap object will be instantiated and called as such:
# # obj = MyHashMap()
# # obj.put(key,value)
# # param_2 = obj.get(key)
# # obj.remove(key)


# class MyHashMap:
#
#     def __init__(self):
#         """
#         Initialize your data structure here.
#         """
#         self.arr = []
#
#     def put(self, key: int, value: int) -> None:
#         """
#         value will always be non-negative.
#         """
#         if len(self.arr) < key:
#             self.arr += [None for _ in range(len(self.arr), key + 1)]
#         self.arr[key] = value
#         return self.arr[key]
#
#     def get(self, key: int) -> int:
#         """
#         Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
#         """
#         if key < len(self.arr) and self.arr[key] is not None:
#             return self.arr[key]
#         return -1
#
#     def remove(self, key: int) -> None:
#         """
#         Removes the mapping of the specified value key if this map contains a mapping for the key
#         """
#         if key < len(self.arr):
#             self.arr[key] = None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
