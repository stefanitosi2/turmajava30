import java.util.Scanner;

public class Lista2Exercicio3 {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		int idade;
		
		//10-14 infantil
		//15-17 juvenil
		//18-25 adulto

		
		System.out.printf("Qual sua idade : ");
		idade = leia.nextInt();
		
		if(idade>=10 && idade<=14)
		{
			System.out.printf("Voce se encaixa na classifica��o infantil");
		}
		else if(idade >=15 && idade <=17)
		{
			System.out.printf("Voce se encaixa na classifica��o juvenil");
		}
		else if(idade >=18 && idade <=25)
		{
			System.out.printf("Voce se encaixa na classifica��o adulto");
		}
		else 
		{
			System.out.printf("Voce n�o se  encaixa em nenhuma classifica��o ");
		}
		
		
		
	}

}
