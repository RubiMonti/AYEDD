/*
Proyecto 4 ejercicio 4

Este ejercicio consiste en utilizar una circlist creada anteriormente 
para realizar una secuencia musical. El apartado obligatorio sera 
imprimiendo los sonidos en texto mientras que la parte opcional sera 
sacando los sonidos del ordenador.
*/

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdAudio;
import java.util.concurrent.TimeUnit;


public class SequencerSound
{
    static private String[] str_split(String s, char c)
    {
        // Esta funcion nos devuelve dos strings que son sacados de partir en dos el String pasado como parámetro por el carácter pasado como parametro.
        // El carácter pasado como parámetro se encuentra en el segundo string. En caso de no encontrar el carácter devolverá dos Strings con Error.
        String[] toreturn = new String[2];
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == c)
            {
                toreturn[0] = s.substring(0,i);
                toreturn[1] = s.substring(++i);
                return (toreturn);
            }
        }
        toreturn[0] = s;
        toreturn[1] = "Error";
        return (toreturn);
    }

    static private int strToInt(String integer)
    {
        int toreturn = 0;
        int sign = 1;
        if (integer.charAt(0) == '-')
            sign = -1;
        else
            toreturn = integer.codePointAt(0) - 48;
        for (int i = 1; i < integer.length(); i++)
        {
            if (integer.codePointAt(i) >= 48 && integer.codePointAt(i) <= 57)
            {
                toreturn *= 10;
                toreturn += integer.codePointAt(i) - 48;
            }
            else
            {
                System.err.println("El número introducido no es válido");
                System.exit(1);
            }
        }
        toreturn *= sign;
        return (toreturn);
    }

    public static void sleep(int milliseconds)
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

// create a note (sine wave) of the given frequency (Hz), for the given
// duration (seconds) scaled to the given volume (amplitude)
    public static double[] note(double hz,double duration,double amplitude)
    {
        int N = (int) (StdAudio.SAMPLE_RATE * duration);
        double[] a =new double[N+1];
        for(int i = 0; i <= N; i++)
        {
            a[i] = Math.sin(2*Math.PI*i*hz / StdAudio.SAMPLE_RATE); 
            a[i] *= amplitude;
        }
        return a;
    }

// play note for duration seconds
// return true if I could play
    public static final double FreqDo = 440.0;
    public static final double DefAmpl = 0.5;
    public static boolean playNote(String note,double duration)
    {
        String[] notes = {"Do","Re","Mi","Fa","Sol","La","Si"};
        //semiTones separation in a standard music octave
        int[] semiTones = { 0, 2, 4, 5, 7, 9, 11, 12};
        int idx = -1;
        for (int i = 0; i < notes.length; i++)
        {
            if (notes[i].equals(note))
            {
                idx = i;
                break;
            }
            else if(note.equals("-"))
            {
                idx = -2;
                break;
            }
        }
        if(idx == -1)
        {
            return false;
        }
        else if(idx > 0)
        {
            double hz = FreqDo*Math.pow(2, semiTones[idx] / 12.0);
            StdAudio.play(note(hz, duration/1000, DefAmpl));
        }
        else
        {
            // No logro conseguir hacer el silencio
            System.err.println("-");
            sleep(((int)duration)/1000);
        }
        return true;
    }

    public static void main(String[] args)
    {
        if (!(args.length == 2 || args.length == 3))
        {
            System.err.println("No se han introducido los suficientes parámetros.");
            System.exit(1);
        }
        boolean s = true;
        if (args[0].equalsIgnoreCase("-s"))
        {
            s = false;
            args[0] = args[1];
            args[1] = args[2];
        }
        In in = new In(args[1]);
        int wait = strToInt(args[0]);
        Loop loop = new Loop();
        String line;
        while (in.hasNextLine())
        {
            line = in.readLine();
            if (line.equalsIgnoreCase("nop"))
            {
                if (s)
                    System.out.println(loop.nop());
                else
                    playNote(loop.nop(), wait);
            }
            else if (line.equalsIgnoreCase("del"))
            {
                if (s)
                    System.out.println(loop.delete());
                else
                    playNote(loop.delete(), wait);
            }
            else
            {
                String order = str_split(line, ' ')[0];
                String complement = str_split(line, ' ')[1];
                if (order.equalsIgnoreCase("add"))
                {
                    if (s)
                        System.out.println(loop.add(complement));
                    else
                        playNote(loop.add(complement), wait);
                }
                else
                {
                    System.err.println("No se pudo reconocer la orden");
                    System.exit(1);
                }
            }
            if (s)
                sleep(wait);
        }
    }
}