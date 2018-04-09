package mymap;

public class MyMap {

	 public static void main(String[] args) throws InterruptedException {
		 HashMapG<Integer, String> map=new HashMapG<>();
		 
		 map.put(1,"Gaurav");
		 map.put(9,"Samim");
		 map.put(11,"Tamim");
		 map.put(10,"Amir");
		 map.put(5,"Yamini");
		 map.put(6,"Ten");
		 map.put(16,"Gam");
		 map.put(26,"Dam");
		 	
		 System.out.println("Log :Getting "+map.get(11));
		 System.out.println("Getting "+map.get(26));
		 
		 System.out.println("Getting "+map.get(10));
	

		 
		 
	 }
}
