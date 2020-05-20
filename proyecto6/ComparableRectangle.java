import edu.princeton.cs.algs4.*;
import java.util.Arrays;


public class ComparableRectangle implements Comparable<ComparableRectangle>{

    final double x0;
    final double y0;
    final double x1;
    final double y1;

    public ComparableRectangle(String line){

        String[] numbers = line.split(" ");
        if (numbers.length != 4){
            System.err.println("Los rectángulos introducidos no son válidos");
            System.exit(1);
        }

        x0 = Double.parseDouble(numbers[0]);
        y0 = Double.parseDouble(numbers[1]);
        x1 = Double.parseDouble(numbers[2]);
        y1 = Double.parseDouble(numbers[3]);

        if ((x0 < 0d || x0 > 1d) || (x1 < 0d || x1 > 1d) || (y0 < 0d || y0 > 1d) || (y1 < 0d || y1 > 1d)){
            System.err.println("Los rectángulos introducidos no son válidos");
            System.exit(1);
        }
        if (x0 > x1 || y0 > y1){
            System.err.println("Los rectángulos introducidos no son válidos");
            System.exit(1);
        }
    }

    public double getX(){ return (x1-x0); }
    public double getY(){ return (y1-y0); }
    public double getArea(){ return (this.getX()*this.getY()); }

    public void show(){
        StdOut.println(x0 + " " + y0 + " " + x1 + " " + y1);
    }

    public int compareTo(ComparableRectangle a){
        if (this.getArea() < a.getArea()){
            return -1;
        }
        else if (this.getArea() == a.getArea()){
            return 0;
        }
        else{
            return 1;
        }
    }
}