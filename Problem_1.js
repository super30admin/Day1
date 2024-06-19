// Time Complexity : insert - O(1), delete - O(1), lookup - O(1) 
// Space Complexity : O(n) - n is number of items stored 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: 
// For this HashSet function used JS object data structure, which has O(1) lookup time. 
// Can be built using arrays too but search runtime for array is O(n) so switched to object

var MyHashSet = function () {
    this.data = {}
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.add = function (key) {
    if (!this.data[key])
        this.data[key] = null;
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.remove = function (key) {
    delete this.data[key];
};

/** 
 * @param {number} key
 * @return {boolean}
 */
MyHashSet.prototype.contains = function (key) {
    return this.data[key] !== undefined
};

/** 
 * Your MyHashSet object will be instantiated and called as such: */
var obj = new MyHashSet()
obj.add(1)
obj.add(2)
obj.remove(1)
var param_3 = obj.contains(1)
console.log(param_3)
