import java.util.Iterator;

import javax.lang.model.util.ElementScanner6;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Comparator;

public class BagSort<Item extends Comparable<Item>> implements Iterable<Item>
{
    private Node first; // primer nodo de la lista
    private int n;
    private class Node
    {   // clase anidada privada para definir nodos
		Item item;
		Node next;
    }
    public boolean isEmpty() {  return first == null; }
    public int size()        {  return n;             }
    public void add(Item item)
    {   // Añadir item a la bolsa: igual que push() de la pila
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		n++;
    }

    public Iterator<Item> iterator()
    {  return new ListIterator();  }
    private class ListIterator implements Iterator<Item>
    {
		private Node current = first;
		public boolean hasNext() {  return current != null;  }
		public void remove() { }
		public Item next()
		{
	    	Item item = current.item;
	    	current = current.next;
	    	return item;
		}
    }

	private void mergesort(Node subfirst, Node sublast, Comparator comparator)
	{
		Node sub1 = first;
		Node sub2 = subfirst;
		System.err.println(sub1.item);
		System.err.println(sub2.item);
		Node exch;
		Node index;

		if (comparator.compare(sub1.item, sub2.item) <= 0){
			index = sub1;
			sub1 = sub1.next;
		}
		else{
			index = sub2;
			sub2 = sub2.next;
		}
		while (sub1 != subfirst && sub2 != sublast.next){
			if (comparator.compare(sub1.item, sub2.item) <= 0){
				index.next = sub1;
				sub1 = sub1.next;
			}
			else{
				index.next = sub2;
				sub2 = sub2.next;
			}
			index = index.next;	
		}
		if (sub1 == subfirst){
			while (sub2 != sublast.next){
				exch = sub2.next;
				index.next = sub2;
				sub2 = exch;
				index = index.next;
			}
		}
		if (sub2 == sublast.next){
			while (sub1 != subfirst){
				exch = sub1.next;
				index.next = sub1;
				sub1 = exch;
				index = index.next;
			}
			index.next = sublast.next;
		}
		StdOut.println("\nMergesort: ");
		Node iterator_m = first;
		while (iterator_m.next != null)
		    StdOut.println(iterator_m.item);
	}

    public void sort(Comparator comparator)
    {
		if (this.size() == 0){
			System.err.println("Nada que ordenar");
			return;
		}
		if (this.size() == 1) { return; }
		Node actual = first;
		Node subfirst = null;
		Node sublast = null;

		while (actual.next != null)
		{
			if (comparator.compare(actual.item, actual.next.item) <= 0)
				actual = actual.next;
			else
			{
				subfirst = actual;
				actual = actual.next;
				while (actual.next != null)
				if (comparator.compare(actual.item, actual.next.item) <= 0) 
					actual = actual.next;
				else
				{
					sublast=actual;
					mergesort(subfirst, sublast, comparator);
					subfirst = null;
					sublast = null;
					break;
				}
			}
		}
		if (subfirst == null) { return; }
		else if (sublast == null) {
			sublast = actual;
			mergesort(subfirst, sublast, comparator);
		}
    }
		      
    public static void main (String[] args)
    {
		BagSort<String> b = new BagSort<String>();
		Comparator v = new Comparator<String>() {
			public int compare(String obj1, String obj2) {
				if (obj1 == obj2) {
					return 0;
				}
				if (obj1 == null) {
					return -1;
				}
				if (obj2 == null) {
					return 1;
				}
				return obj1.compareTo(obj2);
			  }
		};
		b.add("suarez");
		b.add("calvo sotelo");
		b.add("gonzalez");
		b.add("aznar");
		b.add("zapatero");
		b.add("rajoy");
		b.add("sanchez");
		StdOut.println("Unsorted: ");
		Iterator iterator = b.iterator();
		while (iterator.hasNext())
			StdOut.println(iterator.next());		
		
		b.sort(v);

		StdOut.println("\nSorted: ");
		iterator = b.iterator();
		while (iterator.hasNext())
		    StdOut.println(iterator.next());
	
    }
}    
