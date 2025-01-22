class MyHashSet {
private boolean array[][];
private int sizeOfMainArray;
private int sizeOfInnerArray;
private int FirstHashFunction (int key)
{
        return key%sizeOfMainArray;
}
private int SecondHashFunction (int key)
{
        return key/sizeOfInnerArray;
}
    public MyHashSet() {
        this.sizeOfMainArray=1000;
        this.sizeOfInnerArray=1000;
        this.array = new boolean[sizeOfMainArray][];
    }
    
    public void add(int key) {
        int indexOfMainArray = FirstHashFunction(key);
        if(array[indexOfMainArray] == null)
        {
            if(indexOfMainArray==0)
            {
                array[indexOfMainArray]= new boolean[sizeOfInnerArray + 1];
            }
            else
            {
                array[indexOfMainArray]= new boolean[sizeOfInnerArray];
            }
        }
        int indexOfInnerArray = SecondHashFunction(key);
        array[indexOfMainArray][indexOfInnerArray] = true;
    }
    
    public void remove(int key) {
         int indexOfMainArray = FirstHashFunction(key);
        if(array[indexOfMainArray] == null)
        return;
        int indexOfInnerArray = SecondHashFunction(key);
        array[indexOfMainArray][indexOfInnerArray] = false;
    }
    
    public boolean contains(int key) {
        int indexOfMainArray = FirstHashFunction(key);
        if(array[indexOfMainArray] == null)
        return false;
        int indexOfInnerArray = SecondHashFunction(key);
        return array[indexOfMainArray][indexOfInnerArray];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */