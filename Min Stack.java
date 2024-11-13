//with 2 stacks, TC-(1) sc-O(1)
// class MinStack {
//     Stack<Integer> st;
//     Stack<Integer> minSt;
//     int min;

//     public MinStack(){
//         this.st = new Stack<>();
//         this.minSt = new Stack<>();
//         this.min = Integer.MAX_VALUE;
//         minSt.push(min);
//     }
    
//     public void push(int val) {
//         min = Math.min(min, val);
//         st.push(val);
//         minSt.push(min);
  
//         }

    
//     public void pop() {
//         st.pop();
//         minSt.pop();
//         min = minSt.peek();
    
//     }
    
//     public int top() {
//         return st.peek();
       
//     }
    
//     public int getMin() {
//        return min;
//     }
// }

// with one stack

class MinStack {
    Stack<Integer> st;
    int min;

    public MinStack(){
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(min >= val){
            st.push(min);
            min = val;
        }
        st.push(val);
  
        }

    
    public void pop() {
        int el = st.pop();
        if(el == min){
            min = st.pop();
        }
    
    }
    
    public int top() {
        return st.peek();
       
    }
    
    public int getMin() {
       return min;
    }
}
 /* class ListNode {
 *     int val, min;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
           min = x;
 *         next = null;
 *     }
 */ 

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */