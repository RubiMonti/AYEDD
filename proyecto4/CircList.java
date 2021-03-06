/*
Ejercicio 2 del proyecto 4

Este ejercicio consiste en crear una lista circular de tamaño variable.
En mi caso la voy a hacer con una lista elazada.
*/

public class CircList<Item>
{
    //Primero crearemos las variables y las clases que vamos a usar.
    private Node cursor;
    private int count;

    private class Node
    {
        private Item item;
        private Node next;
    }

    // Creo un metodo para comprobar que todo funciona correctamente en el main
    private String tostring()
    {
        if (count == 0)
            return ("CircList = null");
        String toreturn;
        toreturn = "CircList = ";
        toreturn += this.forwardCursor().toString();
        for (int i = 1; i < count; i++)
            toreturn += ", " + this.forwardCursor().toString();
        return (toreturn);
    }

    public CircList()
    {
        cursor = null;
        count = 0;
    }

    public boolean isEmpty()
    {
        return (cursor == null);
    }

    public int size()
    {
        return (count);
    }

    public void insert(Item item)
    {
        if (this.size() == 0)
        {
            cursor = new Node();
            cursor.item = item;
            cursor.next = cursor;
        }
        else if (this.size() == 1)
        {
            Node newcursor = new Node();
            newcursor.item = item;
            newcursor.next = cursor;
            cursor.next = newcursor;
        }
        else
        {
            Node old = new Node();
            old.item = cursor.next.item;
            old.next = cursor.next.next;
            cursor.next.item = item;
            cursor.next.next = old;
        }
        count++;
    }

    public Item cursor()
    {
        if (this.size() == 0)
            return (null);
        else
            return (cursor.item);
    }

    public Item forwardCursor()
    {
        if (this.size() == 0)
            return (null);
        else
        {
            Item toreturn;
            toreturn = cursor.item;
            cursor = cursor.next;
            return (toreturn);
        }
    }

    public Item popCursor()
    {
        if (this.size() == 0)
            return (null);
        else
        {
            Item toreturn;
            toreturn = cursor.item;
            if (this.size() == 1)
                cursor = null;
            else
            {
                cursor.item = cursor.next.item;
                cursor.next = cursor.next.next;
            }
            count--;
            return (toreturn);
        }
    }
}