class MaxStack {

    TreeMap<Integer,ArrayList<Node>> tree;
    Node head;
    Node tail;
    public MaxStack() {
        head = new Node(-1);
        tail = new Node(-1);
        tree = new TreeMap<>();
        head.next = tail;
        tail.prev = head;
    }

    /*
     * @param number: An integer
     * @return: nothing
     */    
    public void push(int x) {
     
     Node temp = new Node(x);

     //add at last
      temp.prev = tail.prev;
      temp.next = tail;
      tail.prev.next = temp;
      tail.prev = temp;


      if(!tree.containsKey(x)){
          ArrayList<Node> list = new ArrayList();
          tree.put(x,list);
      }
      //add in arraylist
      tree.get(x).add(temp);

    }

    public int pop() {
       //delete prev;
        Node curr = tail.prev;
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

      //remove from tree
      ArrayList<Node> arr = tree.get(curr.val);
      arr.remove(arr.size() - 1);

      if(arr.size() == 0)
      tree.remove(curr.val);
      else
      tree.put(curr.val,arr);
      return curr.val;
    }

    /*
     * @return: An integer
     */    
    public int top() {
       return tail.prev.val;
    }

    /*
     * @return: An integer
     */    
    public int peekMax() {
        // write your code here
        return tree.lastEntry().getKey();
    }

    /*
     * @return: An integer
     */    
    public int popMax() {
      int key = peekMax();
     
      ArrayList<Node> arr = tree.get(key);
      Node curr = arr.get(arr.size() - 1);

      //remove from the dll
      curr.prev.next = curr.next;
      curr.next.prev = curr.prev;

      //remove from TreeMap
      arr.remove(arr.size() - 1);

      if(arr.size() == 0)
      tree.remove(curr.val);
      else
      tree.put(curr.val,arr);
      return curr.val;
    }
}

class Node{
    int val;
    Node next;
    Node prev;

    Node(int d){
        val = d;
    }
}
