package mymap;

import java.util.Arrays;

public class HashMapG<K,V> {

	
	private static double loadf=0.75;
	static private int size;
	static private int load;
	static EntryG[] entrySet;
	
	
	
	
	public HashMapG() {
		size=16;
		load=0;
		entrySet=new EntryG[size];
		
	}
	

	public static class EntryG<K,V>{
		K key;
		V value;
		EntryG<K, V> entryG;
	}

	public int put(K key,V value) {
		
		
		
		
		int hash=(key.hashCode()%size);
		System.out.println("Bucket "+hash);
		if(entrySet[hash]!=null) {
			if(entrySet[hash].value!=value)
				load++;
			
			System.out.println("Collision "+hash+"  for "+value);
			EntryG tentry=new EntryG<>();
			tentry.key=key;
			tentry.value=value;
			tentry.entryG=null;
			entrySet[hash].entryG=tentry;
			load++;
		}
		else {
			//System.out.println(entrySet.length);
			EntryG tentry=new EntryG<>();
			tentry.key=key;
			tentry.value=value;
			entrySet[hash]=tentry;
			load++;
		}
			
		if((double)load/size>=loadf) {
			resize();			
		}
		
		return -1;
		// TODO Auto-generated method stub
		
	}
	

	private void resize() {
		
		//abhi nhi likha 
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(entrySet);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashMapG<?, ?> other = (HashMapG<?, ?>) obj;
		if (!Arrays.equals(entrySet, other.entrySet))
			return false;
		return true;
	}


	public V get(K key) throws InterruptedException {

		int hash=(key.hashCode()%size);
		if(entrySet[hash]==null)
			return null;
		else {
			System.out.println("key exists"+hash);
			EntryG temEntry=entrySet[hash];
			while(temEntry!=null) {
				System.out.println("entrySet[hash]"+entrySet[hash].value);
				System.out.println("getkey "+entrySet[hash].key);
				//Thread.sleep(10000);
				if(entrySet[hash].key.equals(key))
				{
					
					return (V) entrySet[hash].value;
				}
				else
				{
					temEntry=temEntry.entryG;

				}
			}
			
		}
		
		
		return null;
	}
	
	
	
	
	
}
