// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, while creating an initial storage bucket array

// Your code here along with comments explaining your approach

var MyHashSet = function () {
  this.primaryBucket = 1000;
  this.secondaryBucket = 1000;
  this.storage = this.createStorage(this.primaryBucket, this.secondaryBucket);
};

MyHashSet.prototype.createStorage = function (rows, columns) {
  let array = new Array(rows);

  for (let i = 0; i < rows; i++) {
    array[i] = new Array(columns).fill(false); // Fill each inner array with 'false'
  }

  return array;
};

MyHashSet.prototype.getPrimaryIndex = function (key) {
  return key % this.storage.length;
};

MyHashSet.prototype.getSecondaryIndex = function (key) {
  return key / this.storage.length;
};

/**
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.add = function (key) {
  let primaryIndex = this.getPrimaryIndex(key);
  if (this.storage[primaryIndex] == null) {
    this.storage[primaryIndex] = [];
  }
  let secondaryIndex = this.getSecondaryIndex(key);
  this.storage[primaryIndex][secondaryIndex] = true;
};

/**
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.remove = function (key) {
  let primaryIndex = this.getPrimaryIndex(key);
  if (this.storage[primaryIndex] == null) {
    return;
  }
  let secondaryIndex = this.getSecondaryIndex(key);
  this.storage[primaryIndex][secondaryIndex] = false;
};

/**
 * @param {number} key
 * @return {boolean}
 */
MyHashSet.prototype.contains = function (key) {
  let primaryIndex = this.getPrimaryIndex(key);
  if (this.storage[primaryIndex] == null) {
    return false;
  }
  let secondaryIndex = this.getSecondaryIndex(key);
  return this.storage[primaryIndex][secondaryIndex] || false;
};

test("Scenario #1:", () => {
  var obj = new MyHashSet();
  obj.add(1001);
  obj.add(1006);
  expect(obj.contains(1001)).toStrictEqual(true);
  expect(obj.contains(1006)).toStrictEqual(true);
});
