'''
Time complexity:
push: O(1)
pop: O(1)
top: O(1)
getMin: O(1)

Space complexity: O(n) where n in total number of pop operations

'''

class MinStack:

  def __init__(self):
    self.currentMin = float('inf')
    self.minStack = [ self.currentMin ]

  def push(self, val: int) -> None:
    if val <= self.currentMin:
      self.minStack.append(self.currentMin)
      self.currentMin = val
    self.minStack.append(val)

  def pop(self) -> None:
    poppedValue = self.minStack.pop()
    if poppedValue == self.currentMin:
      nextMin = self.minStack.pop()
      self.currentMin = nextMin

  def top(self) -> int:
    return self.minStack[-1]

  def getMin(self) -> int:
    return self.currentMin

# Your MinStack object will be instantiated and called as such:
obj = MinStack()
print('Push 7')
obj.push(7)

print('Push 3')
obj.push(3)

print('Push 4')
obj.push(4)

print('Push 5')
obj.push(5)

print('top():', obj.top())
print('getMin():', obj.getMin())

print('Push 4')
obj.push(4)

print('Push 8')
obj.push(8)

print('top():', obj.top())
print('getMin():', obj.getMin())

print('Push -4')
obj.push(-4)

print('Push -4')
obj.push(-4)

print('Push 0')
obj.push(0)

print('top():', obj.top())
print('getMin():', obj.getMin())

print('pop()')
obj.pop()

print('top():', obj.top())
print('getMin():', obj.getMin())

print('pop()')
obj.pop()

print('top():', obj.top())
print('getMin():', obj.getMin())

print('pop()')
obj.pop()

print('top():', obj.top())
print('getMin():', obj.getMin())

print('pop()')
obj.pop()

print('top():', obj.top())
print('getMin():', obj.getMin())
