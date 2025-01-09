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