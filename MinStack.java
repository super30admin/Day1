class MinStack {
    int CapacityThreshold = 5;
    int[] arr;
    int itemCount = 0;
    int minItem;
    public MinStack() {
        this.arr = new int[CapacityThreshold];
    }

    /*
        Notes :
            1. Push pop from end
            2. Maintain min item on push and pop
    */
    private int getCurrentTipIndex() {
        if(this.itemCount > 0)
            return this.itemCount - 1;
        else
            return 0;
    }
    public void push(int val) {
        if(this.itemCount == this.CapacityThreshold) {

        }

        if(this.itemCount == 0) {
            this.minItem = val;
        } else {
            if(this.minItem > val) {
                this.minItem = val;
            }
        }
        this.itemCount = this.itemCount + 1;
        this.arr[this.getCurrentTipIndex()] = val;

    }

    public void pop() {
        if(this.itemCount > 0) {
            this.itemCount = this.itemCount -1;
            this.minItem = this.arr[0];
            for(int i =0;i<this.getCurrentTipIndex(); i++) {
                if(this.minItem > this.arr[i]) {
                    this.minItem = this.arr[i];
                }
            }
        } else {
            System.out.println("Empty Stack");
        }
    }

    public int top() {
        return this.arr[this.getCurrentTipIndex()];
    }

    public int getMin() {
        return this.minItem;
    }

    private static void printStats(MinStack stack) {
        // print top
        System.out.println("Min : " + stack.getMin());
        // print mins
        System.out.println("Top : " + stack.top());
    }
    public static void main(String[] args) {


        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
//        int min = minStack.getMin(); // return -3
//        System.out.println("Min : " + min);
        minStack.pop();
        System.out.println("After popping top");
        printStats(minStack);
//        int newTop = minStack.top();    // return 0
//        System.out.println("Top : " + newTop);
//        int min1 = minStack.getMin(); // return -2
//        System.out.println("Min : " + min1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */