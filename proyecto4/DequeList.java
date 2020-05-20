/* 
Proyecto 4 ejercicio 1.

Este ejercicio consiste en crear un "deque", una pila que pueda ser utilizada por dos lados.

Este ejercicio tiene dos archivos, en uno de  ellos la clase se implementa con un array mientras que en el segundo programa
se usa una lista enlazada.
*/
import java.util.Iterator;

public class DequeList<Item>
{
    // Primero definiremos las variables que vamos a utilizar en el TAD
    private int count;
    private Node right;
    private Node left;

    private class Node
    {
        private Item item;
        private Node next;
        private Node prev;
    }

    public DequeList()
    {
        right = null;
        left = null;
        count = 0;
    }

    public boolean isEmpty()
    {
        return (right == null && left == null);
    }

    public int size()
    {
        return (count);
    }

    public void pushLeft(Item item)
    {
        Node old = left;
        left = new Node();
        left.item = item;
        left.next = null;
        if (right == null)
            right = left;
        else
            left.next = old;
        if (left.next == right)
            right.prev = left;
        count++;
    }

    public void pushRight(Item item)
    {
        Node old = right;
        right = new Node();
        right.item = item;
        right.prev = null;
        if (left == null)
            left = right;
        else
            right.prev = old;
        if (right.prev == left)
            left.next = right;
        count++;
    }

    public Item popLeft()
    {
        if (this.isEmpty())
            return (null);
        Item toreturn = left.item;
        if (left == right)
            right = null;
        left = left.next;
        count--;
        return(toreturn);
    }

    public Item popRight()
    {
        if (this.isEmpty())
            return (null);
        Item toreturn = right.item;
        if (left == right)
            left = null;
        right = right.prev;
        count--;
        return (toreturn);
    }

    private class reg_iterator implements Iterator<Item>
    {
        private Node it = left;
        public boolean hasNext() { return !(it.next == null); }
        public Item next() 
        {
            if (it == null)
                return null;
            Item toreturn;
            toreturn = it.item;
            it = it.next;
            return toreturn;
        }
    }

    private class rev_iterator implements Iterator<Item>
    {
        private Node it = right;
        public boolean hasNext() { return !(it.prev == null); }
        public Item next() 
        {
            if (it == null)
                return null;
            Item toreturn;
            toreturn = it.item;
            it = it.prev;
            return toreturn;
        }
    }

    public Iterator<Item> iterator()
    {
        return new reg_iterator();
    }

    public Iterator<Item> reverseIterator()
    {
        return new rev_iterator();
    }
}