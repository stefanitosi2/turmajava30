import java.util.Scanner;

public class Lista3Exercicio3 {

	public static void main(String[] args) {
		Scanner leia = new Scanner (System.in);
		
		int idade, menor21=0, maior50=0;
		
		System.out.println("Digite sua idade: ");
		idade = leia.nextInt();
		
	while(idade != -99)
	{
		
		if(idade < 21)
		{
			menor21 ++;
			
			
		}
		else if (idade > 50)
		{
			maior50 ++;
		}
		else {
			
			
		}
		System.out.println("Digite sua idade: ");
		idade = leia.nextInt();
		
		
		}
	System.out.println(" A quantidde de pessoas menor de 21 é : " + menor21);
	
	System.out.println(" A quantidde de pessoas maior de 50 é : " + maior50);
	}
	
	
	
	
	
	
	
	
	
	
	}


