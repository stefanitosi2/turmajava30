import java.util.Scanner;

public class Lista3Exercicio4 {

	public static void main(String[] args) {
		Scanner leia =new Scanner (System.in);
		
		//Variaveis
		int idade;
		char sexo; 
		char opcoes;
		int contadorPessoas=0;
		final int Limite_Pessoas_Entrevistados=150; //constante 
		char op=' ';
		int numeroPessoasCalmas=0;
		int numeroMulheresNervosa=0;
		int numeroHomensAgressivos=0;
		int numeroOutrosCalmos=0;
		int numeroPessoasNervosasMais40Anos=0;
		int numeroPessoasCalmasMenos18Anos=0;
		//entradas
		
		while(contadorPessoas < Limite_Pessoas_Entrevistados && op=='S') {
		System.out.print("Digite a idade : ");
		idade = leia.nextInt();
		
		System.out.print("(1-feminino / 2-masculino / 3-Outros :");
		sexo = leia.next().charAt(0);
		
		System.out.print("Digite a opção 1, se a pessoa era calma; 2, se a pessoa era nervosa e 3, se a pessoa era agressiva");
		opcoes = leia.next().charAt(0);
		contadorPessoas++;
		System.out.println("Continua S/N: ");
		op = leia.next().toUpperCase().charAt(0);
		
		if(opcoes == '1') {
			
			numeroPessoasCalmas++;
		}
		
		if(sexo =='1' && opcoes =='2') {
			numeroMulheresNervosa++;
			
			
		}
		if(sexo=='2'&& opcoes =='3')
		{
			numeroHomensAgressivos++;
		}
		
		if(sexo=='3' && opcoes =='1')
		{
			numeroOutrosCalmos++;
		}
		if(opcoes =='2' && idade>40)
		{
			numeroPessoasNervosasMais40Anos++;
		}
		
		if(opcoes =='1' && idade <18)
		{
			numeroPessoasCalmasMenos18Anos++;
		}
		
		}
		
		System.out.println("Pessoas calmas "+numeroPessoasCalmas);
		System.out.println("Mulheres nervosas "+numeroMulheresNervosa);
		System.out.println("Homens agressivos  "+numeroHomensAgressivos);
		System.out.println("Outros calmos "+numeroOutrosCalmos);
		System.out.println("Pessoas nervosas com mais de 40 anos "+numeroPessoasNervosasMais40Anos);
		System.out.println("Pessoas calmas com menos de 18 anos  "+numeroPessoasCalmasMenos18Anos);
		}
	}


