class Node {
    int key;
    int val;
    Node prev;
    Node next;
    
    Node(int key, int val, Node prev, Node next){
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}


class LRUCache {
    
    private int limit;
    private Map<Integer, Node> mp;
    private Node head;
    private Node tail;
    
    private void intializeList(Node head, Node tail){
        head.next = tail;
        tail.prev = head;
    }
    
    private void addNodeToFront(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    private void moveNodeToFront(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        
        addNodeToFront(node);
    }
    
    private void deleteLastNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
    
    
    public LRUCache(int capacity) {
        this.limit = capacity;
        this.mp = new HashMap<>();
        this.head = new Node(-1, -1, null, null);
        this.tail = new Node(-1, -1, null, null);
        intializeList(head, tail);
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)){
            return -1;
        }
        
        Node node = mp.get(key); 
        
        // move node to front
        moveNodeToFront(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            node.val = value;
            
            // move node to front
            moveNodeToFront(node);
            return;
        }
        
        if(limit == mp.size()){
            // delete last Node
            Node node = tail.prev;
            deleteLastNode(node);
            
            // delete from map
            mp.remove(node.key);
        }
        
        Node node = new Node(key, value, null, null);
        mp.put(key, node);
        
        // add Node to front
        addNodeToFront(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */