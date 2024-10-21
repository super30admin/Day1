// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//CODE 1:
//Used ArrayList approach to solve the problem and always added my elements to index 0.
//Since it required searching and shifting of elements.
//Time Complexity:O(N) and Space Complexity:O(N)
 class MyHashSet {
    ArrayList<Integer> list;//Used Integer arrayList for hashing
    public MyHashSet() {
     this.list=new ArrayList<>();
    }
    
    public void add(int key) {
        if(!list.contains(key))//checks to avoid repeated values
        list.add(key);
    }
    
    public void remove(int key) {
        list.remove(Integer.valueOf(key));//removes the object value directly
    }
    
    public boolean contains(int key) {
        if(list.contains(key))//check if contains
        return true;
        else return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */



//CODE 2:
// Successfully performed Minimum stack with linked list tried arraylist earlier but couldnt get O(1)
//Time Complexity:O(1)
//Space Complexity:O(N)
 class MinStack {
    Node head;// created linked list node with proper structure storing its value and minimum.
   
     class Node {
        int value;
        int min;
        Node next;

        Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    
    public MinStack() {
        head=null;// head is initialized to null.
        
        }

        
    public void push(int val) {
        if(head==null)
        {
           head=new Node(val,val);//if head is null value and minimum value will be same
        }
        else{//else we will compare and find the minimum and always store it with head so that easy to find
            int min=Math.min(head.min,val);
            Node temp=head;
            head=new Node(val,min);
            head.next=temp;

        }
    }
    
    public void pop() {//simply move the head to next node
       head=head.next;
    }
    
    public int top() {//simply read the head value
      return head.value;
    }
    
    public int getMin() {//since we always store the minimum value in head we just fetch the head.
        return head.min;
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