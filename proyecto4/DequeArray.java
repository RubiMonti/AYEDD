/* 
Proyecto 4 ejercicio 1.

Este ejercicio consiste en crear un "deque", una pila que pueda ser utilizada por dos lados.

Este ejercicio tiene dos archivos, en uno de  ellos la clase se implementa con un array mientras que en el segundo programa
se usa una lista enlazada.
*/

public class DequeArray<Item> implements Iterable<Item>
{
    //Añadimos las variables que vamos a usar en el TAD
    private Item[]  array = new Item[0];
    private int     count;
    
    /* Comprobar todo lo que esta comentado aqui
    private int     iter;   

    //También vamos a crear las funciones del iterador
    private boolean hasNext() 

    */
    //Primero crearemos el constructor de dicha clase
    public DequeArray()
    {
        count = 0;
    }
    
    public boolean isEmpty()
    {
        return (array.length == 0);
    }

    public int size()
    {
        return count;
    }

    public void pushLeft(Item item)
    {
        Item[] n_array = new Item[array.length + 1];
        for (int i = 0; i < array.length; i++)
            n_array[i + 1] = array[i];
        n_array[0] = item;
        array = n_array;
        count = array.length;
    }

    public void pushRight(Item item)
    {
        Item[] n_array = new Item[array.length + 1];
        for (int i = 0; i < array.length; i++)
            n_array[i] = array[i];
        n_array[n_array.length - 1] = item;
        array = n_array;
        count = array.length;
    }

    public Item popLeft()
    {
        Item toreturn;
        try 
            { toreturn = array[0]; }
        catch (Exception e)
            { toreturn = null; }            
        Item[] n_array = new Item[array.length - 1];
        for (int i = 0; i < n_array.length; i++)
            n_array[i] = array[i + 1];
        array = n_array;
        count = array.length;
        return (toreturn);
    }

    public Item popRight()
    {
        Item toreturn;
        try 
            { toreturn = array[array.length - 1]; }
        catch (Exception e)
            { toreturn = null; }
        Item[] n_array = new Item[array.length - 1];
        for (int i = 0; i < n_array.length; i++)
            n_array[i] = array[i];
        array = n_array;
        count = array.length;
        return (toreturn);
    }

    private class reg_iterator implements Iterator<Item>
    {
        private int i = 0;
        public boolean hasNext() { return i <= n-1; }
        public Item next() { return array[i++]; }
    }

    private class rev_iterator implements Iterator<Item>
    {
        private int i = n-1;
        public boolean hasNext() { return i <= 0; }
        public Item next() { return array[i--]; }
    }

    public Iterator<Item> iterator()
    {
        return new reg_iterator();
    }

    public Iterator<Item> reverseIterator()
    {public static void main(String[] args)
        {
            DequeList int_deque = new DequeList();
            int n = 5;
            DequeList string_deque = new DequeList();
            String s = "klk";
            Iterator<String> pepe;
            
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
            string_deque.pushLeft(s);
            pepe = string_deque.iterator();
            System.err.println("iterator1 = " + pepe.hasNext());
            System.err.println("iterator1 = " + pepe.next());
            System.err.println("iterator2 = " + pepe.hasNext());
            System.err.println("iterator2 = " + pepe.next());
            System.err.println("iterator3 = " + pepe.hasNext());
            System.err.println("iterator3 = " + pepe.next());
            System.err.println("Item = " + string_deque.popLeft() + " Count = " + string_deque.size());
            System.err.println("Item = " + string_deque.popLeft() + " Count = " + string_deque.size());
            System.err.println("Item = " + string_deque.popLeft() + " Count = " + string_deque.size());
        }
}