
/*
Leetcode - https://leetcode.com/problems/min-stack/

*/type MinStack struct {
    // stack contains all the elements as they are being pushed
	stack   []int
    // minimum stack , contains the minimum element
    // -2 , 0, -3 (contents of stack)
    // -2 , -2, -3 (contents of minimum stack)
	minimum []int
}

/** initialize your data structure here. */
func Constructor() MinStack {
	return MinStack{
		stack:   []int{},
		minimum: []int{},
	}
}

func (this *MinStack) Push(x int) {
	this.stack = append(this.stack, x)
	if len(this.minimum) == 0 {
		this.minimum = append(this.minimum, x)
	} else {
		this.minimum = append(this.minimum, min(this.minimum[len(this.minimum)-1], x))
	}
}

func (this *MinStack) Pop() {
	this.stack = this.stack[:len(this.stack)-1]
	this.minimum = this.minimum[:len(this.minimum)-1]
}

func (this *MinStack) Top() int {
	return this.stack[len(this.stack)-1]
}

func (this *MinStack) GetMin() int {
	return this.minimum[len(this.minimum)-1]
}

func min(a, b int) int {
	if a < b {
		return a
	}

	return b
}