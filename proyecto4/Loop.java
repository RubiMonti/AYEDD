/*
Proyecto 4 ejercicio 4

Este ejercicio consiste en utilizar una circlist creada anteriormente 
para realizar una secuencia musical. El apartado obligatorio sera 
imprimiendo los sonidos en texto mientras que la parte opcional sera 
sacando los sonidos del ordenador.
*/

public class Loop
{
    private CircList<String> sounds;

    public Loop()
    {
        sounds = new CircList();
    }

    public String add(String sound)
    {
        String toreturn;
        toreturn = sounds.cursor();
        sounds.insert(sound);
        sounds.forwardCursor();
        if (toreturn == null) {toreturn = "-";}
        return (toreturn);
    }

    public String delete()
    {
        String toreturn;
        toreturn = sounds.forwardCursor();
        sounds.popCursor();
        if (toreturn == null) {toreturn = "-";}
        return (toreturn);
    }

    public String nop()
    {
        String toreturn;
        toreturn = sounds.forwardCursor();
        if (toreturn == null) {toreturn = "-";}
        return (toreturn);
    }
}