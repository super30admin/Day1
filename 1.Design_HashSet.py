'''
Time Complexity:
    add() - O(1)
    contains() - 0(1)
    remove() - 0(1)

Space Complexity:
    average - 0(sqrt(10^6))  

Approach:
    We used DOUBLE HASHING techinique here
'''
class MyHashSet:

    def __init__(self):
        self.__index = 1000
        self.__primaryList = [None]*self.__index
    
    # define hash function 1
    def __hashModulo(self, key: int) -> int:
        return key % self.__index
    
    # define hash function 2
    def __hashQuotient(self, key:int) -> int:
        return key // self.__index

    def add(self, key: int) -> None:
        
        # get modulo index
        idx_modulo = self.__hashModulo(key)
        
        # get quotient index
        idx_quotient = self.__hashQuotient(key) 

        if self.__primaryList[idx_modulo] == None:
            # we dont have double hashing

            if idx_modulo == 0:
                # edge case -- store last possible key
                self.__primaryList[idx_modulo] = [False]*(self.__index+1)
            else:
                self.__primaryList[idx_modulo] = [False]*(self.__index)
        
        # now mark the second index as True
        self.__primaryList[idx_modulo][idx_quotient] = True

    def remove(self, key: int) -> None:
        # get modulo index
        idx_modulo = self.__hashModulo(key)
        
        if self.__primaryList[idx_modulo] == None:
            # we don't have anything to store for double hashing
            return

        # get quotient index
        idx_quotient = self.__hashQuotient(key) 

        # set the index to false
        self.__primaryList[idx_modulo][idx_quotient] = False
        

    def contains(self, key: int) -> bool:
        
        # get modulo index
        idx_modulo = self.__hashModulo(key)
        
        if self.__primaryList[idx_modulo] == None:
            # we don't have anything to store for double hashing
            return False

        # get quotient index
        idx_quotient = self.__hashQuotient(key) 

        # set the index to false
        return self.__primaryList[idx_modulo][idx_quotient]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)