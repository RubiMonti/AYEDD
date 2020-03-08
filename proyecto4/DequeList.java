/* 
Proyecto 4 ejercicio 1.

Este ejercicio consiste en crear un "deque", una pila que pueda ser utilizada por dos lados.

Este ejercicio tiene dos archivos, en uno de  ellos la clase se implementa con un array mientras que en el segundo programa
se usa una lista enlazada.
*/

public class DequeList
{
    // Primero definiremos las variables que vamos a utilizar en el TAD
    private int count;
    private Node r_first;
    private Node l_first;

    private class Node
    {
        private Item item;
        private Node next;
    }

    public DequeList()
    {
        r_first = null;
        l_first = null;
        count = 0;
    }

    public boolean isEmpty()
    {
        return (r_first == null && l_first == null);
    }

    public int size()
    {
        return (count);
    }

    public void pushLeft()
    {
        
    }
}