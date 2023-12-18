class HashSet {

    private boolean [][]storage;
    int buckets; //primary index
    int bucketItems;//secondary index
    public HashSet() {
        buckets=1000;
        bucketItems=1000;
        storage=new boolean[buckets][];//we are not inititating nested array inorder avoid commintment for 1000000 value
    }
    private int hash1(int key){
        return key%buckets;
    }
    private int bucketItems(int key)
    {
        return key/bucketItems;
    }
    
    public void add(int key) {
        int bucket=hash1(key);
        if(storage[bucket]==null)
        {
            if(bucket==0)
            {
                storage[bucket]=new boolean[bucketItems+1];
            }
            else
            {
                storage[bucket]=new boolean[bucketItems];
            }
        }
        int bucketItem=bucketItems(key);
        storage[bucket][bucketItem]=true;
    }
    
    public void remove(int key) {

        int bucket=hash1(key);
        if(storage[bucket]==null)
        {
           return;
        }
        int bucketItem=bucketItems(key);
        storage[bucket][bucketItem]=false;
        
    }
    
    public boolean contains(int key) {
        int bucket=hash1(key);
       if(storage[bucket]==null)
       {
          return false;
       }
       int bucketItem=bucketItems(key);
       return storage[bucket][bucketItem];

   }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */