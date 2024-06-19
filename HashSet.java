// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : I faced an arrayindex out of bounds exception initially. Later this is corrected.

//Approach to solve this problem is to identify a position uniquely, Every element in input should have exactly one location corresponding to it.
//Initialize array to handle 1 million entries initially. Modulo & Division operations can be used interchangebly, 
//If input key is 100 then modulo operation results as 0 but the division returns 100.Hence a boolean value is set as true for [0][100] value.
class MyHashSet {
    boolean[][] hashset;
    int mainEntries;
    int subEntries;
// Initially set the bucket size (mainEntries), and subElements(subEntries) to 1000
    public MyHashSet() {
        mainEntries=1000;
        subEntries=1000;
//Size of the hashset during initialization would be 1000* 4 bytes, because null pointer occupies 4 bytes of memory
        this.hashset=new boolean[mainEntries][]; 
    }

    private int getPrimaryHashFunction(int key){
//return reminder using modulo operation
        return key%mainEntries;
    }

    private int getSecondaryHashFunction(int key){
//return quotient using modulo operation
        return key/subEntries;
    }
//adding value to hashset
    public void add(int key) {
        int primaryValue=getPrimaryHashFunction(key);         
    
        if(hashset[primaryValue]==null){
//For 1 million input key the primaryValue becomes zero and  
//hence only size of subarray is increased for that particular elment instead of entire array else initial subEntry size is used as is.
             if(primaryValue==0){
                 hashset[primaryValue]=new boolean[subEntries+1];
             } else{
                hashset[primaryValue]=new boolean[subEntries];
            }            
        }        
        int secondaryValue=getSecondaryHashFunction(key);
//mark the element as true in hashset for the input value
        hashset[primaryValue][secondaryValue]=true;
    }
	
 //Set the element in hashset to false when the value is removed 
    public void remove(int key) {
        int primaryValue=getPrimaryHashFunction(key);        
        if(hashset[primaryValue]==null){
            hashset[primaryValue]=new boolean[subEntries];
        }        
        int secondaryValue=getSecondaryHashFunction(key);
        hashset[primaryValue][secondaryValue]=false;
    }
	
 //If the hashset has the value array element value as true return true else false
    public boolean contains(int key) {
        int primaryValue=getPrimaryHashFunction(key);        
		//Avoid checking rest of the hashset if the array holds null
        if(hashset[primaryValue]==null){
           return false;
        }
        int secondaryValue=getSecondaryHashFunction(key);     
        if(hashset[primaryValue][secondaryValue]==true){
            return true;
        }
        return false;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
