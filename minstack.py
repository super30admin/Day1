class MinStack:

    def __init__(self):
        self.st = []
        self.minSt = []
        self.Min = int(sys.maxsize)
        self.minSt.append(self.Min)

    def push(self, val: int) -> None:
        if val <= self.Min:
            self.st.append(self.Min)
            self.Min = val
        self.st.append(val)

    def pop(self) -> None:
        popped = self.st.pop()
        if popped == self.Min:
            self.Min = self.st.pop()

    def top(self) -> int:
        return self.st[-1]

    def getMin(self) -> int:
        return self.Min
#time complexity - o(1)
#Space complexity - o(n)