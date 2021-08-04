import java.util.Scanner;

public class Lista3Exercicio6 {

	public static void main(String[] args) {
		// Escrever um programa que receba vários números inteiros no teclado.
		//E no final imprimir a média dos números múltiplos de 3.
		//Para sair digitar 0(zero).(DO...WHILE)
		Scanner leia = new Scanner (System.in);
		
		int numero=0, contador=0;
		
		do 
		{
			System.out.println("Digite o numero um numero inteiro : ");
			numero= leia.nextInt();
			
			if(numero % 3 ==0 && numero>=0) 
			{
				
				contador++;
			}
			
			System.out.println("A quantidade de repetição de multiplos de 3 é : " +contador);	
			
			
		}while (numero<10);
	}
		
}		
		
		
		
		
		
		
		
		
	


