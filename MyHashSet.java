import java.util.LinkedList;

class MyHashSet {
	private LinkedList<Integer>[] bucketArray;

	private int keyRange;

	/** Initialize your data structure here. */
	public MyHashSet() {
		this.keyRange = 769;
		this.bucketArray = new LinkedList[this.keyRange];
		for (int i = 0; i < this.keyRange; ++i)
			this.bucketArray[i] = new LinkedList();
	}

	protected int _hash(int key) {
		return (key % this.keyRange);
	}

	public void add(int key) {
		int bucketIndex = this._hash(key);
		this.bucketArray[bucketIndex].addFirst(Integer.valueOf(key));
	}

	public void remove(int key) {
		int bucketIndex = this._hash(key);
		this.bucketArray[bucketIndex].remove(Integer.valueOf(key));
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		int bucketIndex = this._hash(key);

		return this.bucketArray[bucketIndex].contains(Integer.valueOf(key));
	}
}