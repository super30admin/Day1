/*
Approach- using a double hashing method here with arrays as the data structure
the primary key is found using % and the secondary key is found using /
so that the values both of those functions give are different.
 */

/**
 *  MyHashSet : MyHashSet
 *
 * @author : Kavya Mandaliya (kmandali@cisco.com)
 * @version : 1.0 (Oct 22, 2024)
 * @since : 1.0 (Oct 22, 2024)
 *
 */
class MyHashSet {
 boolean set[][];
 int primarySize = 1000;
 int secondarySize = 1001;
 
 public MyHashSet() {
  set = new boolean[primarySize][];
 }
 
 private int getPrimaryKey(int key){
  return key % primarySize;
 }
 
 private int getSecondaryKey(int key){
  return key/secondarySize;
 }
 
 public void add(int key) {
  int val = getPrimaryKey(key);
  if(set[val] == null){
   set[val] = new boolean[secondarySize];
  }
  int secondary = getSecondaryKey(key);
  set[val][secondary] = true;
 }
 
 public void remove(int key) {
  int val = getPrimaryKey(key);
  if(set[val] == null){
   return;
  }
  int secondary = getSecondaryKey(key);
  set[val][secondary] = false;
 }
 
 public boolean contains(int key) {
  int val = getPrimaryKey(key);
  if(set[val] == null){
   return false;
  }
  int secondary = getSecondaryKey(key);
  return set[val][secondary];
 }
 
 public static void main(String[] args) {
  MyHashSet set = new MyHashSet();
  set.add(1);
  set.add(2);
  set.add(3);
  set.remove(2);
  System.out.println(set.contains(1));
  System.out.println(set.contains(2));
 }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
