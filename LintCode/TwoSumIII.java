// 607 · Two Sum III - Data structure design   https://www.lintcode.com/problem/607/description

public class TwoSum {
   
    HashMap<Integer,Integer> hm = new HashMap<>();
    public void add(int number) {
       hm.put(number,hm.getOrDefault(number,0)+1);  // best case O(1) and Worst case O(N)
    }

    public boolean find(int value) {
          //Worst case O(N)
          for(int v:hm.keySet()){
              if(hm.containsKey(value - v)){
                  //complement ni hai khud ka
                  if(value - v != v)
                  return true;
                  else if(value - v == v && hm.get(value - v) >= 2)
                  return true; 

              }
          }
          return false;
          }
}

// -----------------------------------------------------------

public class TwoSum {

     ArrayList<Integer> arr;
     boolean isSorted;
     TwoSum(){
         arr = new ArrayList<>();
         isSorted = false;
     }
    public void add(int number) {
        arr.add(number);                 // O(1)
        isSorted = false;
    }

    public boolean find(int value) {                 
        if(isSorted == false){
            Collections.sort(arr);                      // already sorted O(N) if not O(N log N) bcz you have to sort it
            isSorted = true;
        }
        int i = 0, j = arr.size() - 1;
        while(i < j){
            int sum = arr.get(i) + arr.get(j);
            if(sum == value)
            return true;
            else if(sum > value) j--;
            else i++;
        }
        return false;
    }
}
