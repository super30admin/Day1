public class problem1 {

//    explanation: In this problem to implement hashset we consume the concept of double hash operation. Starting by creating 2d array
//    and initializing the buckets sizes as 10^3 for, except primarybuckets due to test case issue . Caluating primaryhash by % operation
//    and to calculate secondary hash by / operation . we do so to calculate the index for the key



    class myHashSet{
        int primaryBuckets;
        int secondaryBuckets;
        boolean[][] storage;
        public myHashSet(){
            this.primaryBuckets=1001;
            this.secondaryBuckets=1000;
            storage = new boolean[primaryBuckets][];
        }
        private int getPrimaryHash(int key)
        {
            return key%primaryBuckets;
        }
        private int getSecondaryHash(int key)
        {
            return key/secondaryBuckets;
        }
        public void add(int key)
        {
            int primaryIndex= getPrimaryHash(key);
            if (storage[primaryIndex] == null)
            {
                storage[primaryIndex]= new boolean[secondaryBuckets];
            }
            int secondaryIndex= getSecondaryHash(key);
            storage[primaryIndex][secondaryIndex]=true;
        }
        public void remove(int key)
        {
            int primaryIndex= getPrimaryHash(key);
            if (storage[primaryIndex] == null)
            {
                return;
            }
            int secondaryIndex= getSecondaryHash(key);
            storage[primaryIndex][secondaryIndex]=false;
        }
        public boolean contains(int key)
        {
            int primaryIndex= getPrimaryHash(key);
            if (storage[primaryIndex] == null)
            {
                return false;
            }
            int secondaryIndex= getSecondaryHash(key);
            return storage[primaryIndex][secondaryIndex];
        }

    }

}
