import java.util.Scanner;

public class Lista3Exercicio2 {

	public static void main(String[] args) {
		
		//Ler 10 números e imprimir quantos são pares e quantos são ímpares. (FOR)
		
		Scanner leia = new Scanner (System.in);
		int numero, par=0, impar=0;
		
		
		for(int x =1; x <=10; x++)
		{
			System.out.println("Digite o numero: ");
			numero = leia.nextInt();
			if(numero%2==0)
			{
				par++;
			}
			
				
			}
		impar = 10 - par;
		
		System.out.printf("Quantidade de pares %d\n", par);
		System.out.printf("Quantidade de impares %d\n", impar);
		}

	}


