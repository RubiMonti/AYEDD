import java.util.Arrays;

import edu.princeton.cs.algs4.*;

public class SortRectangles {
    
    public static void main(String[] args){
        if (args.length != 1) {
            System.err.println("Demasiados argumentos");
            System.exit(1);
        }
        In in = new In(args[0]);
        String line;
        int count=0;
        ComparableRectangle[] rectangles = new ComparableRectangle[count];
        ComparableRectangle[] exchange = new ComparableRectangle[count];;

        while (in.hasNextLine()){
            count++;
            line = in.readLine();
            exchange = rectangles;
            rectangles = new ComparableRectangle[count];
            for (int c = 0; c < exchange.length;c++){
                rectangles[c] = exchange[c];
            }
            rectangles[count - 1] = new ComparableRectangle(line);
        }

        Arrays.sort(rectangles);
        for (int i = 0; i < rectangles.length;i++){
            rectangles[i].show();
        }
    }
}