import java.util.Scanner;

public class Lista3Exercicio5 {

	public static void main(String[] args) {
		Scanner leia = new Scanner (System.in);
		//Crie um programa que leia um número do teclado até que encontre um número igual a zero. 
		//No final, mostre a soma dos números digitados.(DO...WHILE)
		
		int numero, soma=0;
		
		
		
		
		do
		{
			System.out.println("Digite o numero: ");
			numero= leia.nextInt();
			soma+=numero;
			
		}
		while (numero !=0);
		
			System.out.println("soma é : "+ soma);
			
		

	}

}
