/* 
Proyecto 4 ejercicio 1.

Este ejercicio consiste en crear un "deque", una pila que pueda ser utilizada por dos lados.

Este ejercicio tiene dos archivos, en uno de  ellos la clase se implementa con un array mientras que en el segundo programa
se usa una lista enlazada.
*/

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
            right.next = left;
        count++;
    }

    public void pushRight(Item item)
    {
        Node old = right;
        right = new Node();
        right.item = item;
        right.next = null;
        if (left == null)
            left = right;
        else
            right.next = old;
        if (right.next == left)
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
        right = right.next;
        count--;
        return (toreturn);
    }

    public static void main(String[] args)
    {
        DequeList int_deque = new DequeList();
        int n = 5;
        DequeList string_deque = new DequeList();
        String s = "klk";
        
        System.err.println("Item = " + int_deque.popLeft() + " Count = " + int_deque.size());
        int_deque.pushLeft(n);
        int_deque.pushLeft(++n);
        n = 70;
        int_deque.pushRight(n);
        System.err.println("Item = " + int_deque.popLeft() + " Count = " + int_deque.size());

        System.err.println("Item = " + string_deque.popLeft() + " Count = " + string_deque.size());
        string_deque.pushLeft(s);
        s = "Calvooooo";
        string_deque.pushLeft(s);
        s= "pelooooooo";
        string_deque.pushRight(s);
        System.err.println("Item = " + string_deque.popRight() + " Count = " + string_deque.size());
        System.err.println("Item = " + string_deque.popRight() + " Count = " + string_deque.size());
        System.err.println("Item = " + string_deque.popRight() + " Count = " + string_deque.size());
    }
}