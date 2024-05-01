from collections import deque


class MinStack:

    def __init__(self):
        self.st = deque()
        self.minHeap = []

    def push(self, val: int) -> None:
        self.st.append(val)
        if len(self.minHeap) > 0 and self.minHeap[0] < val:
            heappush(self.minHeap, self.minHeap[0])
        else:
            heappush(self.minHeap, val)

    def pop(self) -> None:
        if len(self.st) != 0:
            self.st.pop()
            heappop(self.minHeap)

    def top(self) -> int:
        if len(self.st) > 0:
            return self.st[-1]

    def getMin(self) -> int:
        return self.minHeap[0]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

# Time Complexity :O(1)
# Space Complexity: O(2n)
