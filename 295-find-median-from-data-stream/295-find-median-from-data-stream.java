class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
       if(min.size() > 0 && num > min.peek())
           min.add(num);
        else
            max.add(num);
        
        if(min.size() - max.size() == 2)
            max.add(min.remove());
        else if(max.size() - min.size() == 2)
            min.add(max.remove());
        
    }
    
    public double findMedian() {
        
          if(max.size() != min.size()) 
              return max.size() > min.size() ? max.peek() : min.peek();
          else 
            return (min.peek() + max.peek()) / 2.0;
       
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */