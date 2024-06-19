/*

Leetcode https://leetcode.com/problems/design-hashset/

In HashSet no duplicate elements are allowed
Time Complexity would be O(1) for add, contains 
Time Complexity would be O(1) for remove

Using map which is a data strcuture provided by golang to implement HashSet
map does not allow duplicate elements

*/type MyHashSet struct {
    store map[int]bool
}


func Constructor() MyHashSet {
    temp := make(map[int]bool)
    return MyHashSet{store : temp}
}


func (this *MyHashSet) Add(key int)  {
    this.store[key]= true
    
}

func (this *MyHashSet) Remove(key int)  {
    delete(this.store, key)
}


func (this *MyHashSet) Contains(key int) bool {
    if _, ok:=this.store[key]; ok {
        return true
    }
    return false
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Add(key);
 * obj.Remove(key);
 * param_3 := obj.Contains(key);
 */