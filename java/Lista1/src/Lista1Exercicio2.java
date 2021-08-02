import java.util.Scanner;

public class Lista1Exercicio2 {
	public static void main (String [] args)
	{
		int anoNascimento;
		int mesNascimento;
		int diasNascimento;
		int resultadoAno;
		int restoMeses;
		int restoDias;
		
		Scanner leia=new Scanner(System.in);
		
		System.out.println("Digite os dias de seu nascimento:");
		diasNascimento = leia.nextInt();
		
		resultadoAno = diasNascimento / 365;
		System.out.println("Voce tem: "+resultadoAno+" anos ");
		
		restoMeses = diasNascimento % 365;
		mesNascimento = restoMeses / 30;
		System.out.println("Voce tem tem: "+mesNascimento+" meses ");
		
		restoDias = restoMeses % 30;
		
		System.out.println("Voce tem : "+restoDias+" dias ");
		
		
		
		
	}

}
