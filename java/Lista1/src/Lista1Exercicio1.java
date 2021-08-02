import java.util.Scanner;

public class Lista1Exercicio1 {
	public static void main(String [] args)
	{
		
		
		int anoNascimento;
		int mesesNascimento;
		int diaNascimento;
		int resultadoIdade;
		
		Scanner leia = new Scanner(System.in);
		
		System.out.println("Digite seu ano de nascimento:");
		anoNascimento = leia.nextInt();
		
		resultadoIdade = 2021 - anoNascimento;
		
		System.out.println("Voce tem "+resultadoIdade+" anos ");
		
		mesesNascimento = anoNascimento * 12;
		
		System.out.println("Voce tem "+mesesNascimento+" meses ");
		
		diaNascimento = mesesNascimento * 365;
		
		System.out.println("Voce tem "+diaNascimento+" dias ");
		
		
		
		
				
	}
	
}
