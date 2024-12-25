class MinStack:

    def __init__(self):
        self.st = []
        self.minv = float('inf')
        

    def push(self, val: int) -> None:
        if val <= self.minv:
            self.st.append(self.minv)
            self.minv = val
        self.st.append(val)

    def pop(self) -> None:
        pval = self.st.pop()
        if self.minv == pval:
            self.minv = self.st.pop()
        
        

    def top(self) -> int:
        return self.st[-1]

    def getMin(self) -> int:
        return self.minv
    


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

    elif op == "pop":
        s.pop()

    elif op == "top":
        res = s.top()
        if res == -1:
            print("Stack is empty")
        else:
            print("top element:",res)
            
    elif op == "minvalue":
        res = s.getMin()
        if res == -1:
            print("Stack is empty")
        else:
            print("minimum element:",res)
            
    elif op == "quit":
        break