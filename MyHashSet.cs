public class MyHashSet
{

    Dictionary<int, int> hashSet;
    public MyHashSet()
    {
        hashSet = new Dictionary<int, int>();
    }

    public void Add(int key)
    {
        if (hashSet.ContainsKey(key))
        {
            Console.WriteLine("This element is already present");
            return;
        }
        hashSet.Add(key, key);
    }

    public void Remove(int key)
    {
        if (!hashSet.ContainsKey(key))
        {
            Console.WriteLine("This element is not present");
            return;
        }
        hashSet.Remove(key);
    }

    public bool Contains(int key)
    {
        return hashSet.ContainsKey(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.Add(key);
 * obj.Remove(key);
 * bool param_3 = obj.Contains(key);
 */