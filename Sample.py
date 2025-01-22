#Time Complexity : 
'''O(n) --> When we add / remove / return it can be needed to parse the entire dataset'''
#Space Complexity : 
'''O(n) --> As we store all the elements we have to parse the entire date'''
#Did this code successfully run on Leetcode :
'''Yes the code submission ran successfully'''
#Any problem you faced while coding this :
'''
Spent time to decide which data structure to use that can store the data. Decided to use list as it is
dynamic and can store string and integer values.
Could not decide the size of the list, looking at the constraints decided to go with 10^5
(as most of the inputs were 10^4) from the problem. 
'''
# Your code here along with comments explaining your approach
## Problem 1 - Design Hash set using in built hash table libraries.
class MyHashSet(object):

    def __init__(self):
        self.size_of_array = 10000  #Size of list based on the constraints
        self.input_array = [[] for _ in range(self.size_of_array)] #Store the data in list data structure

    def hash_function(self, key): #Using modulus function as it would return a unique value each time
        return key % self.size_of_array 
    
    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self.hash_function(key) #Hash function to know the index
        result_value = self.input_array[index] #Get the element 
        if key not in result_value: #Check if value exists at the index
            result_value.append(key) #Add the key to the list

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        index = self.hash_function(key) #Hash function to get index
        result_value = self.input_array[index] #Get the element
        if key in result_value: #Check if key exists in the list
            result_value.remove(key) #Remove the key from the list

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        index = self.hash_function(key) #Hash function to get index
        result_value = self.input_array[index] #Get the elememnt
        return key in result_value #Return key if exists from the list

##Problem 2 - Design Minstack that supports push, pop, top and retrieving the minimum element
class MinStack(object):

    def __init__(self):
        self.result_stack = [] #Define an empty stack
        self.min_value = float('inf') #Minimum element value as infinity

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if val <= self.min_value: #Compare the value with minimum value
            self.result_stack.append(self.min_value) #Push the minimum value into the stack
            self.min_value = val #Update minimum value by current element
        self.result_stack.append(val) #Push the current element in the stack

    def pop(self):
        """
        :rtype: None
        """
        top_element = self.result_stack[-1] #Get the topmost element of the stack
        self.result_stack.pop() #Remove the top element
        if self.min_value == top_element: #Check if the topmost value is minimum element
            self.min_value = self.result_stack[-1] #Update the minimum value by top element
            self.result_stack.pop() #Remove the top element from the stack

    def top(self):
        """
        :rtype: int
        """
        return self.result_stack[-1] #Return the topmost element

    def getMin(self):
        """
        :rtype: int
        """
        return self.min_value #Return the minimum value from the stack
