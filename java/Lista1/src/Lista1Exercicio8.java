import java.util.Scanner;

public class Lista1Exercicio8 {

	public static void main(String[] args) {
		
		double custoFabrica;
		double distribuidor;
		double imposto;
		double custoConsumidor;
		
		Scanner leia = new Scanner(System.in);
		
		System.out.println("Digite o valor do carro de custo da fabrica: ");
		custoFabrica = leia.nextDouble();
		
		custoConsumidor = ((custoFabrica*28/100) + (custoFabrica*45/100) + custoFabrica);
		
		System.out.println("O valor final para o consumidor é : "+custoConsumidor);
		
		

	}

}
