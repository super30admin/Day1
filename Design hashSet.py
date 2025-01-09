class MyHashSet(object):

    def __init__(self):
        self.hashSet = {}  # Using a dictionary to simulate a set

    def add(self, key):
        self.hashSet[key] = True  # Add the key with value True to indicate presence

    def remove(self, key):
        if key in self.hashSet:
            self.hashSet.pop(key)  # Remove the key from the dictionary

    #def remove(self, key):
     #   if key in self.hashSet:
      #     del self.hashSet[key]  # Remove the key from the dictionary


    def contains(self, key):
        return key in self.hashSet  # Check if the key exists in the dictionary
    

    #Add hashset 
    #here I used dictionary for simplicity. 
    #It only adds the non duplicate entries
    
    #Remove element
    #If the value is present then only remove from the hashset

    #Contains
    #Here it will check boolean if the element is present

    #Time complexity
    #Here it is only O(1) 

    #Space complexity is also O(1)
