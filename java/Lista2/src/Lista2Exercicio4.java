import java.util.Scanner;

public class Lista2Exercicio4 {

	public static void main(String[] args) {
		Scanner leia=new Scanner(System.in);
		
		int numero;
		
		System.out.print("Digite um numero inteiro: ");
		numero = leia.nextInt();
		
		if(numero == 0)
		{
			System.out.print("Numero neutro ");
		}
		else if(numero < 0)
		{
			System.out.print("Numero diditado é invalido ");
		}
		else 
		{
			if(numero%2==0)
			{
				System.out.print("Numero par e sua raiz quadrada é "+Math.sqrt(numero));
				Math.sqrt(numero);

			}
			
			else
			{
				System.out.print("Numero impar e o valor elevado ao quadrado é " +Math.pow(numero,numero));
				Math.pow(numero,numero);
			}
			
			
		}
		
	}

}
