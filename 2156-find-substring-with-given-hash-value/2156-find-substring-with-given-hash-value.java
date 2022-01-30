class Solution {
    
  private long power(long a, long b, long m) {
        a %= m;
        long res = 1;
        while (b > 0) {
            if (b%2==1)
                res = res * a % m;
            a = a * a % m;
            b >>= 1;
        }
        return res;
    }
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        
        System.out.println(s.length());
        long powerarr[] = new long[k];
        for(int i=0;i<k;i++)
            powerarr[i] = power(power,i,modulo);
        
//          if(s.length() == k){
//             int val = 0;
//             for(int j =0;j < k;j++){
//                int temp = s.charAt(j) -'a' + 1;
                        
//                val += (temp % modulo * powerarr[j] % modulo) % modulo;
//                 // System.out.println(val);
//             }
//             if(val % modulo == hashValue)
//                 return s;
//             else return "";
//          }
       
        for(int i =0; i <= s.length() - k;i++){
            long val =0;
              for(int j =i;j < i + k;j++){
                
               int temp = (s.charAt(j) -'a' + 1);
                        
               val += temp  * powerarr[j - i];
            
                // System.out.println(val);
            }
            
            // System.out.println(val);
            if(val % modulo  == hashValue)
                return s.substring(i,i+k);
        }
        return "";
    }
}