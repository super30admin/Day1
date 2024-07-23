// Did this code successfully run on Leetcode : Yes
var MyHashSet = function() {
    this.set = [];
};

/** 
 * @param {number} key
 * @return {void}
 */
// Time Complexity :O(n)
// Space Complexity :O(1) for function and O(n) for sorting n elements
MyHashSet.prototype.add = function(key) {
    if(!this.set.includes(key)) {
        this.set.push(key)
    } 
};

/** 
 * @param {number} key
 * @return {void}
 */
// Time Complexity :O(n)
// Space Complexity :O(n)
MyHashSet.prototype.remove = function(key) {
    this.set = this.set.filter(i => i!== key);
};

/** 
 * @param {number} key
 * @return {boolean}
 */
// Time Complexity: O(n)
// Space Complexity: O(1)
MyHashSet.prototype.contains = function(key) {
    if(this.set.includes(key)) return true
    else return false
};

/** 
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */