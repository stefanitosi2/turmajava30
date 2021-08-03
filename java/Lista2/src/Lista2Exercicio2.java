import java.util.Scanner;

public class Lista2Exercicio2 {

	public static void main(String[] args) {
		Scanner leia = new Scanner (System.in);
		
		
		int numero1, numero2, numero3;
		
		System.out.printf("Digite o primeiro numero: ");
		numero1 = leia.nextInt();
		
		System.out.printf("Digite o segundo numero: ");
		numero2 = leia.nextInt();
		
		System.out.printf("Digite o terceiro numero: ");
		numero3 = leia.nextInt();
		
		if(numero1 <= numero2 && numero1 <= numero3)
		{
			
			System.out.println(numero1);
				if(numero2 <= numero3)
				{
					System.out.printf(numero2+"\n"+numero3);
				}
				else {
					System.out.printf(numero3+"\n"+numero2);
					}
				
		}
		
		if(numero2 <= numero1 && numero2 <= numero3)
		{
			System.out.println(numero2);
			if(numero1 <= numero3)
			{
				System.out.printf(numero1+"\n"+numero3);
			}
			else{
				System.out.printf(numero3+"\n"+numero1);
				}
		}
		
		if(numero3 <= numero2 && numero3 <= numero1)
		{
			System.out.println(numero3);
			if(numero2 <= numero1)
			{
				System.out.printf(numero2+"\n"+numero1);
			}
			else{
				System.out.printf(numero1+"\n"+numero2);
				}
		}
		
		
		
		
		

	}

}
