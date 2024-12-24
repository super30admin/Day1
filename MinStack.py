class MinStack:

    def __init__(self):
        # initialise 2 stacks st,minst to store all elements and minimum value elements respectively
        self.st = []
        self.minst = []
        

    def push(self, val: int) -> None:
        # add elements at last in stack
        # time complexity: O(1)
        self.st.append(val)
        if not self.minst or val <= self.minst[-1]:
            # checks if the input is smaller than top element of minst and appends inaccrodingly.
            self.minst.append(val)
        

    def pop(self) -> None:
        # Pops elements from last in stack if we have elements else it returns -1
        # time complexity: O(1)
        if not self.st and not self.minst:
            return -1
        if self.minst[-1] == self.st[-1]:
            # pops element from minimum stack if the last element is equal to last element of main stack
            self.minst.pop()
        return self.st.pop()
        

    def top(self) -> int:
        # returns top element of main stack or -1 if main stack is empty
        # time complexity: O(1)
        if not self.st:
            return -1
        return self.st[-1]
        

    def getMin(self) -> int:
        # returns minimum element of min stack or -1 if min stack is empty
        # time complexity: O(1)
        if not self.st and not self.minst:
            return -1
        return self.minst[-1]
    
    def printStacks(self) -> None:
        # prints main stack and min stacks
        # time complexity: O(n)
        print("st:",self.st)
        print("minst:",self.minst)


s = MinStack()
while True:
    print('push <value>')
    print('pop')
    print('top')
    print('minvalue')
    print("quit")
    ip = input('What would you like to do? ').split()
    op = ip[0].strip().lower()
    if op == "push":
        s.push(int(ip[1]))
        s.printStacks()
    elif op == "pop":
        res = s.pop()
        if res == -1:
            print("Stack is empty")
        else:
            print("Popped element:",res)
            s.printStacks()
    elif op == "top":
        res = s.top()
        if res == -1:
            print("Stack is empty")
        else:
            print("top element:",res)
            s.printStacks()
    elif op == "minvalue":
        res = s.getMin()
        if res == -1:
            print("Stack is empty")
        else:
            print("minimum element:",res)
            s.printStacks()
    elif op == "quit":
        break