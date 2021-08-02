import java.util.Scanner;

public class Lista1Exercicio4 {
	public static void main (String [] args)
	{
		
		int a,b,c,r,s,d;
		Scanner leia = new Scanner(System.in);
		
		System.out.println("Digite o valor de a:");
		a = leia.nextInt();
		System.out.println("Digite o valor de b:");
		b = leia.nextInt();
		System.out.println("Digite o valor de c:");
		c = leia.nextInt();
		
		r=(a + b)*(a + b);
		s=(b + c)*(b + c);
		d=(r + s)/2;
		
		System.out.println("O valor de D é : "+d);
		
		
		
		
		
		
				
		
	}
}
