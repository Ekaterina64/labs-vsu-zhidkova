import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] formulas = new String[] { "(sin(90)+4*exp(0))*abs(-5)" , "2+2*2", "2+X*2" };
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение переменной: ");
        double val = scanner.nextDouble();
        Calculator p = new Calculator(val);
        for( int i = 0; i < formulas.length; i++){
            try{
                System.out.println( formulas[i] + "=" + p.Parse( formulas[i] ));
            }catch(Exception e){
                System.err.println( "Error while parsing '"+formulas[i]+"' with message: " + e.getMessage() );
            }
        }
    }
}
