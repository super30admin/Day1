//TC: Add, Remove, Contains : O(1)
//SC: O(n x n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//* ORIGINAL APPROACH */

// class Node{
//     int data;
//     Node next;

//     public Node(int key){
//         this.data = key;
//         this.next = null;
//     }
// }

// class MyHashSet {

//     int size;
//     Node[] arr;

//     public MyHashSet() {
//         this.size = 100;
//         this.arr = new Node[size];
//     }

//     public void add(int key) {
//         int ind = key % size;
//         Node ptr = arr[ind];
//         if(!contains(key)){
//             if(ptr == null)
//                 arr[ind] = new Node(key);
//             else {
//                 while(ptr.next != null)
//                     ptr = ptr.next;
//                 ptr.next = new Node(key);
//             }
//         }
//     }

//     public void remove(int key) {
//         int ind = key % size;
//         if(contains(key)){
//             if(arr[ind].data == key){
//                 arr[ind] = arr[ind].next;
//             } else {
//                 Node ptr = arr[ind];
//                 Node prev = ptr;
//                 while(ptr != null){
//                     if(ptr.data == key){
//                         prev.next = ptr.next;
//                         break;
//                     }
//                     prev = ptr;
//                     ptr = ptr.next;
//                 }
//             }
//         }
//     }

//     public boolean contains(int key) {
//         int ind = key % size;
//         Node ptr = arr[ind];
//         while (ptr != null){
//             if(ptr.data == key)
//                 return true;
//             ptr = ptr.next;
//         }
//         return false;
//     }
// }

//* CLASS APPROACH */

class MyHashSet {

    boolean[][] hashSetArray;
    int horL;
    int verL;

    int hash1(int val){
        return val % horL;
    }

    int hash2(int val){
        return val / verL;
    }

    public MyHashSet() {
        horL = 1000;
        verL = 1000;
        hashSetArray = new boolean[horL][];
    }

    public void add(int key) {
        int hInd = hash1(key);
        if(hashSetArray[hInd] == null){
            if(hInd == 0){
                hashSetArray[hInd] = new boolean[verL+1];
            } else {
                hashSetArray[hInd] = new boolean[verL];
            }
        }
        int vInd = hash2(key);
        hashSetArray[hInd][vInd] = true;
    }

    public void remove(int key) {
        int hInd = hash1(key);
        if(hashSetArray[hInd] != null){
            int vInd = hash2(key);
            hashSetArray[hInd][vInd] = false;
        }
    }

    public boolean contains(int key) {
        int hInd = hash1(key);
        if(hashSetArray[hInd] == null)
            return false;
        int vInd = hash2(key);
        return hashSetArray[hInd][vInd];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */