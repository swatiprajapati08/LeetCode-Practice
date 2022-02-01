class LRUCache {
    Node head;
    Node tail;
    HashMap<Integer,Node> hm;
    int size = 0,capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        hm = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!hm.containsKey(key))
            return -1;
        else{
            Node curr = hm.get(key);
            
            //remove at
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            
            //add in front
            curr.prev = head;
            curr.next = head.next;
            curr.prev.next = curr;
            curr.next.prev = curr;
            
            return curr.value;
        }
        
    }
    
    public void put(int key, int value) {
       
        if(hm.containsKey(key)== false){
            Node curr = new Node(key,value);
            if(size == capacity){
                //remove form last
                Node temp = tail.prev;
                temp.prev.next = tail;
                tail.prev = temp.prev;
                
                hm.remove(temp.key);
            }
            else size++;
            
            
             //put in hashMap
            hm.put(key,curr);
            
            //add at head
            curr.prev = head;
            curr.next = head.next;
            curr.prev.next = curr;
            curr.next.prev = curr;
          
        }
        else{
            
            Node curr = hm.get(key);
            curr.value = value;
            
            //remove at
            
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            
            //at first
            
            curr.prev = head;
            curr.next = head.next;
            curr.prev.next = curr;
            curr.next.prev = curr;
        }
    }
}
class Node{
    int key;
    int value;
    Node prev;
    Node next;
    
    Node(int key,int value){
        this.key = key;
        this.value = value;
        
    }
}