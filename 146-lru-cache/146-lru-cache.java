class LRUCache {
Node head=new Node(0,0);
    Node tail=new Node(0,0);
    HashMap<Integer,Node> hm=new HashMap<>();
    int cap;
    
    public LRUCache(int capacity) {
         cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)==true)
        {
            Node node=hm.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        else
        {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)==true)
        {
            remove(hm.get(key));
        }
        
        if(hm.size()==cap)
        {
            remove(tail.prev);
        }
        
        insert(new Node(key,value));
    }
    
    public void remove(Node node)
    {
        hm.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    
    public void insert(Node node)
    {
        hm.put(node.key,node);
        Node headNext=head.next;
        head.next=node;
        node.prev=head;
        node.next=headNext;
        headNext.prev=node;
    }
    
    
    
    
    
    class Node{
        Node next;
        Node prev;
        int val;
        int key;
        
        Node(int key, int val)
        {
            this.key=key;
            this.val=val;
        }
    }
    
    
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */