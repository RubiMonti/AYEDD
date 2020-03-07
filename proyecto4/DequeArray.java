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
    private int     l_first;
    private int     r_first;
    
    /* Comprobar todo lo que esta comentado aqui
    private int     iter;   

    //También vamos a crear las funciones del iterador
    private boolean hasNext() 

    */
    //Primero crearemos el constructor de dicha clase
    public DequeArray()
    {
        l_first = 0;
        r_first = array.length;
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
    }

    public void pushRight(Item item)
    {
        Item[] n_array = new Item[array.length + 1];
        for (int i = 0; i < array.length; i++)
            n_array[i] = array[i];
        n_array[n_array.length - 1] = item;
        array = n_array;
    }

    public Item popLeft()
    {
        Item toreturn;
        if (this.isEmpty())
        {
            try 
                { toreturn = array[0]; }
            catch (Exception e)
                { toreturn = null; }            
            Item[] n_array = new Item[array.length - 1];
            for (int i = 0; i < n_array.length; i++)
                n_array[i] = array[i + 1];
            array = n_array;
        }
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
        return (toreturn);
    }

    public Iterator<Item> iterator()
    {

    }
}