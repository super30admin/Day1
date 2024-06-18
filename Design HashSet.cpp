// Approach: first, i thought of creating an array of max size given in the question (10^6). but, that would take so much space. thought about it for some time, but didn't have any idea. so looked at the leetcode solution, understood separate chaining and hashing concepts, and used linked list to solve this problem
// Time Complexity : O(1) - amortized, O(n) - worst
// Space Complexity : O(n)

class MyHashSet {
private:
	int prime;
	vector<list<int>> table;

	int hash(int key) {
		return key % prime;
	}

	list<int>::iterator search(int key) {
		int h = hash(key);
		return find(table[h].begin(), table[h].end(), key);
	}

public:
	MyHashSet() : prime(10007), table(prime) {}
	
	void add(int key) {
		int h = hash(key);
		if (!contains(key))
			table[h].push_back(key);
	}
	
	void remove(int key) {
		int h = hash(key);
		auto it = search(key);
		if (it != table[h].end())
			table[h].erase(it);
	}
	
	bool contains(int key) {
		int h = hash(key);
		return search(key) != table[h].end();
	}
};