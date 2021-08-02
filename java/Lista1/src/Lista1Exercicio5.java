import java.util.Scanner;

public class Lista1Exercicio5 {
	public static void main (String[] args)
	{
		double nota1 = 2.00;
		double nota2 = 3.00;
		double nota3 = 5.00;
		double mediaFinal;
		
		Scanner  leia=new Scanner(System.in);
		
		
		
		mediaFinal = (nota1 + nota2 + nota3)/3;
		
		System.out.println("Sua media final é " +mediaFinal);
		mediaFinal = leia.nextDouble();
		
				
		
	}

}
