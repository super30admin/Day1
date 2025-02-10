class MyHashSet{
    constructor(){
        this.buckets =1000;// this refers to new created instance MyHashSet
        this.bucketItems =1000;
        this.storage = new Array(this.buckets);
    }

    hash1(value){
        return value%this.buckets;
    }

    hash2(value){
        return Math.floor(value/this.bucketItems);
    }

    add(value){
        let bucket = this.hash1(value);
        let bucketItem = this.hash2(value);

        if(!this.storage[bucket]){
                this.storage[bucket]=new Array(this.bucketItems).fill(false);
        }

        this.storage[bucket][bucketItem]=true;
    }
    remove(value) {
        let bucket = this.hash1(value);
        let bucketItem = this.hash2(value);
        
        // If the bucket exists, set the value to false (remove it)
        if (this.storage[bucket]) {
            this.storage[bucket][bucketItem] = false;
        }
    }

    contains(value) {
        let bucket = this.hash1(value);
        let bucketItem = this.hash2(value);
        
        // Return true if the bucket and item exist and are set to true
        return this.storage[bucket] !== undefined && this.storage[bucket][bucketItem];
    }
}

const hashSet = new MyHashSet();

hashSet.add(1);
hashSet.add(2);
console.log(hashSet.contains(1)); // returns true
console.log(hashSet.contains(3)); // returns false
hashSet.add(2);
console.log(hashSet.contains(2)); // returns true
hashSet.remove(2);
console.log(hashSet.contains(2)); // returns false
