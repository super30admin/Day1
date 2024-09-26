#Used Chaining linked list

class LinkedList:
    def __init__(self, key=None):
        self.value = key
        self.next = None
    
class MyHashSet:
    
    def __init__(self):
        self.size = 1000
        self.slots = [None] * self.size
            
    
    def add(self, key: int) -> None:
        hash_value = abs(int(key)) % self.size
        if self.slots[hash_value] == None:
            self.slots[hash_value] = LinkedList(key)
        else:
            curr = self.slots[hash_value]
            while curr is not None:
                if curr.value == key:
                    return 
                if curr.next is None:
                    break
                curr = curr.next
            curr.next = LinkedList(key)
                
    def add(self, key: int) -> None:
        hash_value = abs(key) % self.size
        if self.slots[hash_value] is None:
            self.slots[hash_value] = LinkedList(key)
        else:
            curr = self.slots[hash_value]
            while curr is not None:
                if curr.value == key:
                    return  
                if curr.next is None:  
                    break
                curr = curr.next
            curr.next = LinkedList(key)
    
    def traverse(self):
        for i in range(self.size):
            if self.slots[i] is None:
                print(f"Slot {i}: None")
            else:
                toShow = f"Slot {i}: "
                curr = self.slots[i]
                while curr is not None:
                    toShow += str(curr.value) + " -> "
                    curr = curr.next
                print(toShow + "None")  
                
    def remove(self, key: int) -> None:
        hash_value = abs(key) % self.size
        curr = self.slots[hash_value]
        if curr is None:
            print(key, " Not Found\n")
            return 
        
        if curr.value == key:
            self.slots[hash_value] = curr.next
            print(key, " Removed\n")
                
        while curr.next is not None:
            if curr.next.value == key:
                print(key, " Removed")
                curr.next = curr.next.next
                return
            elif curr.next is None:
                print("Not Present", hash_value)
                return
            curr = curr.next
        

    def contains(self, key: int) -> bool:
        hash_value = abs(key) % self.size
        curr = self.slots[hash_value]
        if curr is None:
            return False
        
        if curr.value == key:
            return True
                
        while curr is not None:
            if curr.value == key:
                return True
            
            elif curr.next is None:
                return False
            
            curr = curr.next
        