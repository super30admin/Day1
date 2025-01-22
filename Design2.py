'''
push pop getmin top O(1)
space complexity - O(n)

'''
class MinStack:
    def __init__(self):
        self.stack=[]
        self.minStack=[]
    
    def push(self,x ):
        self.stack.append(x)
        if not self.minStack or x<=self.minStack[-1]:
            self.minStack.append(x)
        else:
            # copy the top again in case of min value itself 
            self.minStack.append(self.minStack[-1]) 
            
    
    def pop(self):
        if self.stack:
            self.stack.pop()
            self.minStack.pop()
    
    def top(self):
        if self.stack:
            return self.stack[-1]
        return None
    
    def getMin(self):
        if self.minStack:
            return self.minStack[-1]
        return None