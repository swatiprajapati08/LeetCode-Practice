
https://nados.io/question/find-itinerary-from-tickets?zen=true


import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		HashMap<String, Boolean> checkMap = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}

		//write your code here
		for(String src:map.keySet()){
			String  des = map.get(src);
			checkMap.put(des,false); // destination can't be starting point

			if(!checkMap.containsKey(src))
			checkMap.put(src,true);
		}
		
		String spos ="";
		for(String s: checkMap.keySet()){
			if(checkMap.get(s) == true){
			spos = s;
			break;}
		}
		
		
		while(true){
			if(map.containsKey(spos)){
				System.out.print(spos+" -> ");
				spos = map.get(spos);
			}else{
				System.out.print(spos+".");
				break;
			}
		}
		

	}
}
