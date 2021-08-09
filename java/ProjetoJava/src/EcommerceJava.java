//VERSÃƒO 1.0

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Calendar;

public class EcommerceJava {
	
	final static int DIVERSIDADE_PRODUTOS = 10;
	final static int ESTOQUE_INICIAL = 10;
	final static int LIMITE_NOTAS = 3;
	
	static int[] xVetor = new int [LIMITE_NOTAS];
	static int[][] estoqueSelecionadoMatriz = new int [LIMITE_NOTAS][DIVERSIDADE_PRODUTOS];
	static int[] quantidadeFaturasVetor = new int [LIMITE_NOTAS];
	
	static double[] valorFaturaVetor = new double [LIMITE_NOTAS];
	
	static String[][] codigoMatriz = new String[LIMITE_NOTAS][DIVERSIDADE_PRODUTOS];
	static String[][] valorMatriz = new String[LIMITE_NOTAS][DIVERSIDADE_PRODUTOS];
	static String[][] produtoMatriz = new String[LIMITE_NOTAS][DIVERSIDADE_PRODUTOS];
	
	int[] horasAtualVetor = new int[LIMITE_NOTAS];
	int[] minutoAtualVetor= new int[LIMITE_NOTAS];
	
	static String[] formataEstoqueSelecionado = new String[DIVERSIDADE_PRODUTOS];
	static String[] formataValorTotal = new String[DIVERSIDADE_PRODUTOS];
	static double[] formataImposto = new double[DIVERSIDADE_PRODUTOS];
	static String formataCodigo;
	
	static LocalDate anoCalendario; 
	static LocalDate[] anoCalendarioVetor= new LocalDate[LIMITE_NOTAS];
	static int horaCalendario;
	static int[] horaCalendarioVetor = new int[LIMITE_NOTAS];
	static int minutoCalendario;
	static int[] minutoCalendarioVetor = new int[LIMITE_NOTAS];
	static int 
	formataValorTotalNumero;
	
	
	public static void main(String[] args) {
		// variÃ¡veis do cÃ³digo e produto:
				String[] codigo = new String[DIVERSIDADE_PRODUTOS];
				String[] produto = new String[DIVERSIDADE_PRODUTOS]; 
				String codigoDigitado;

				String auxQuantidadeCompra; //  Auxilia para saber se o valor em "leia(quantidadeCompra) Ã© inteiro ou nÃ£o".
				
				//variÃ¡veis relacionadas ao interesse de fazer, continuar as compras ou voltar ao inÃ­cio: 
				char fazerCompras,
				continuarCompras = 'S',
				respostaVoltarInicio = 'N';

				/* vetor do preÃ§o (valor) dos produtos: 
				 *  NOTA: estÃ¡ em cadeia apenas para auxiliar na formataÃ§Ã£o da pÃ¡gina
				 *  colocando um espaÃ§o no fim do nÃºmero, mas depois serÃ¡ convertido. Caso
				 *  ocorra uma troca, valor Ã© usado na funÃ§Ã£o pÃ¡gina de compras e na conta
				 *  do valor total da compra.*/
				String[] valor = new String[DIVERSIDADE_PRODUTOS];


				// variÃ¡veis com os valores: total da compra e fatura a pagar. 
				double 
				valorTotalCompra = 0.00, 
				valorFatura = 0.0;

				// quantidade de parcelas do pagamento
				int 
				quantidadeFaturas = 0;
				
				// variÃ¡veis do estoque e vetor do carrinho: 
				int[] estoqueSelecionado = new int[DIVERSIDADE_PRODUTOS];
				int quantidadeEstoque = ESTOQUE_INICIAL;
				int quantidadeCompra = 0; 
				int[] carrinho = new int[DIVERSIDADE_PRODUTOS]; 
				int[] estoqueInicial = new int[DIVERSIDADE_PRODUTOS]; 
				
				// variÃ¡veis das respostas:
				char opcaoPagamento;
				
				// variÃ¡vel auxiliar dos Ã­ndices e laÃ§os:
				int 
				x = 0;

				// variÃ¡vel para validar o cÃ³digo digitado
				boolean 
				validarCodigo = true;

				// variÃ¡vel para saber se o carrinho estÃ¡ vazio.
				int
				carrinhoVazio = 0;

				// variÃ¡vel para saber se jÃ¡ ocorreu alguma compra.
				boolean 
				primeiraCompra = true;

				//descobrir qual nota fiscal Ã©:
				int 
				contadorNotaFiscal = 1;
				
				String numeroNotaFiscal = "0";
				
				int validaContador = 0;

				
				// DETERMINAÃ‡ÃƒO DOS ELEMENTOS DA LOJA --------------------------------------------------------- //
				produto[0] = "Bola de volei          "; valor[0] = " 54.99"; 
				produto[1] = "CalÃ§a legging          "; valor[1] = " 69.99";
				produto[2] = "Caneleira de peso 5kg  ";	valor[2] = " 59.99";
				produto[3] = "Chuteira feminina      ";	valor[3] = "139.99";
				produto[4] = "Chuteira masculina     ";	valor[4] = "139.99";
				produto[5] = "Halter emborrachado 2kg";	valor[5] = " 49.99";
				produto[6] = "Luva para goleiro      ";	valor[6] = "159.99";
				produto[7] = "Prancha de surf        ";	valor[7] = "889.99";
				produto[8] = "Regata para musculaÃ§Ã£o ";	valor[8] = " 29.99";
				produto[9] = "Skate                  ";	valor[9] = "249.99";

				
				// Valores para estoque inicial e cÃ³digo:
				for(x=0 ; x < DIVERSIDADE_PRODUTOS ; x++) {
					codigo[x] = "G2-"+(x+1);
					estoqueSelecionado[x] = 0;
					estoqueInicial[x] = ESTOQUE_INICIAL;
				}
				// FIM DA DETERMINAÃ‡ÃƒO DOS ELEMENTOS DA LOJA ------------------------------------------------- //	


				/* NOTA: Para a validaÃ§Ã£o de dados, como entrada de nÃºmeros e caracteres, foi utilizada uma estrutura 
				 *  baseada em laÃ§os do tipo (faÃ§a-enquanto) seguidos de condicionais. Esses laÃ§os podem ser Ãºteis para 
				 *  se guiar ao longo do cÃ³digo. Ao todo sÃ£o 10, numerados.
				*/

			
	
		
		Scanner leia = new Scanner(System.in);
		
		
	// (faÃ§a - enquanto) responsÃ¡vel pelo retorno ao inÃ­cio da pÃ¡gina, apÃ³s a compra.
	do {
		limpa();
		cabecalho(3);
		
		do {
			if (numeroNotaFiscal == "0") 
			{
				System.out.println("  â–º Deseja fazer compras?[S/N]: ");
				fazerCompras = leia.next().toUpperCase().charAt(0);	
			}
		
			else
			{
				if(contadorNotaFiscal == LIMITE_NOTAS)
				{
					do{
							System.out.println(" â–º VocÃª fez muitas compras hoje!!");
							System.out.println(" â–º Volte amanhÃ£ para ver o estoque atualizado.");
							System.out.println(" â–º Deseja visualizar suas notas fiscais anteriores? [V]");
							System.out.println(" â–º Ou digite [N] para sair: ");
							fazerCompras = leia.next().toUpperCase().charAt(0);	
						
							if(fazerCompras != 'N' && fazerCompras != 'V') {
								cabecalho(3);
								System.out.println("Resposta invÃ¡lida.\n");
							}
						
					
						} while (fazerCompras != 'N' && fazerCompras != 'V'); 	
				}
				else
				{
					
					System.out.println("  â–º Deseja fazer compras?[S/N] ");
					System.out.println(" â–º Ou deseja visualizar sua(s) nota(s) fiscal(is) anterior(es)? [V]: ");
					fazerCompras = leia.next().toUpperCase().charAt(0);	
				}
				if(fazerCompras == 'N')
				{
					respostaVoltarInicio = 'N';
				}
				if (fazerCompras == 'V') 
				{
					
					do {
						validaContador = 0;
						System.out.println(" Digite o nÃºmero da nota fiscal (exemplo: 1, 2, 3...) de acordo com a data de emissÃ£o: ");
						
						numeroNotaFiscal = leia.next();
						
						try{
				            int number = Integer.parseInt(numeroNotaFiscal);
				           
				        }
				        catch (NumberFormatException ex){
				        	System.out.println("Digite um valor vÃ¡lido! Um nÃºmero inteiro: ");
				        	validaContador++;
				        }
						
					} while( validaContador > 0 || (Integer.parseInt(numeroNotaFiscal) >= contadorNotaFiscal) );
						if (Integer.parseInt(numeroNotaFiscal) >= contadorNotaFiscal) 
						{
							System.out.println(" Digite um valor vÃ¡lido! VocÃª sÃ³ tem " + Integer.toString(contadorNotaFiscal-1) +" nota(s) fiscal(is).");
						}
						
						
						else if (Integer.parseInt(numeroNotaFiscal) <= contadorNotaFiscal) 
						{
							notaFiscal(x, estoqueSelecionado, valorFatura, quantidadeFaturas, codigo, valor, produto, Integer.parseInt(numeroNotaFiscal), contadorNotaFiscal); 
							System.out.println("\n Voltar para o Ã­nicio?[S/N]: ");
							respostaVoltarInicio = leia.next().toUpperCase().charAt(0);	
						}
						
						
					
				}	
			}
			primeiraCompra = true;
			
			
			if (fazerCompras == 'S') {
				
				// 4 - (faÃ§a - enquanto) valida a pergunta continuar compras.
				do {
					// chama a pÃ¡gina de compra durante a compra.
					paginaDeCompras(x, codigo, produto, valor, estoqueInicial, carrinho, estoqueSelecionado, carrinhoVazio);

					// prÃ³xima pergunta Ã© referente a continuar comprando, sÃ³ deve aparecer apÃ³s a primeira compra.
					/* (faÃ§a - enquanto) responsÃ¡vel pelo retorno caso a resposta 
					 *  de continuarCompras seja invÃ¡lida, forÃ§ando o usuÃ¡rio a digitar certo.*/
					 
					// 5 - (faÃ§a - enquanto) valida se a resposta de continuar compras Ã© ou "S" ou "N".
					do {
						if (primeiraCompra == false) {
							System.out.print("  â–º Continuar a compra? [S/N]: ");
							continuarCompras = leia.next().toUpperCase().charAt(0);
						}
						if (continuarCompras == 'S' || primeiraCompra == true) {
			
							// 6 - (faÃ§a - enquanto) valida se a resposta para o cÃ³digo digitado.
							do {
							
								if (validarCodigo == false) {
									System.out.print("  CÃ³digo invÃ¡lido!");
								}
								//a variÃ¡vel recebe falso para se caso entrar no prÃ³ximo "se".
								validarCodigo = false;
								
								leia.nextLine();
								// momento de escolher o produto desejado.
								System.out.print("\n  â–º Digite o cÃ³digo do produto desejado: ");
								codigoDigitado = leia.next().toUpperCase();
							
				
								// (laÃ§o para e condicional se) responsÃ¡veis por escrever o produto do cÃ³digo solicitado.
								for(x=0 ; x < DIVERSIDADE_PRODUTOS ; x++) { 
									
									if(codigoDigitado.equals(codigo[x])) {
										validarCodigo = true;
										quantidadeCompra = 0;
										linha(4);
										System.out.print("â•‘ "+ codigo[x]+"\tâ”‚ "+produto[x]+"\tâ”‚ "+valor[x]+"\t  â”‚ "+estoqueInicial[x]+"\t\t\tâ•‘\n");
										linha(5);
										
										// 7 - (laÃ§o faÃ§a - enquanto) valida o estoque selecionado.
										do {
										
											if (quantidadeCompra > estoqueInicial[x]) {
												linha(10);
												System.out.print("Quantidade indisponÃ­vel.\nTemos somente "+ estoqueInicial[x] +" no estoque!\n");
											}
											if (estoqueSelecionado[x] != 0) {
											System.out.print("  â–º Produto jÃ¡ escolhido! Altere a quantidade desejada: ");
											} 

											// 8 - (faÃ§a - enquanto) valida se a quantidade do estoque digitada foi um nÃºmero inteiro.
											do {
												validaContador = 0;
												System.out.print("\n  â–º Digite a quantidade desejada: ");
												auxQuantidadeCompra = leia.next();
												
												try{
										            int number = Integer.parseInt(auxQuantidadeCompra);
										            if (Integer.parseInt(auxQuantidadeCompra) < 0) {
														System.out.println("Digite um valor vÃ¡lido! Um nÃºmero inteiro positivo: ");
													}
										        }
										        catch (NumberFormatException ex){
										        	System.out.println("Digite um valor vÃ¡lido! Um nÃºmero inteiro: ");
										        	validaContador++;
										        }
												
											
											} while (validaContador > 0 || Integer.parseInt(auxQuantidadeCompra) < 0);
											quantidadeCompra = Integer.parseInt(auxQuantidadeCompra);
											
											
										// (FIM) 7 - (laÃ§o faÃ§a - enquanto) valida o estoque selecionado.	
										} while (quantidadeCompra > estoqueInicial[x] || quantidadeCompra < 0);
			
										// os produtos selecionados para a compra sÃ£o retirados do estoque:
										estoqueSelecionado[x] = quantidadeCompra;
										carrinho[x] = 1;
										primeiraCompra = false;
									}
									
								}
								
							// (FIM) 6 - (faÃ§a - enquanto) valida se a resposta para o cÃ³digo digitado.	
							} while (validarCodigo == false);
						}
						
						else if (continuarCompras == 'N') {
							
							for (x=0 ; x < DIVERSIDADE_PRODUTOS ; x++) {
								
								// aqui Ã© necessÃ¡rio converter o valor para um nÃºmero real.
								valorTotalCompra += ( Double.parseDouble(valor[x]) * estoqueSelecionado[x]);
							}
							
	//PÃ�GINA DE FINALIZAÃ‡ÃƒO DA COMPRA ------------------------------------------------------------------------------------------------------------------------------------------------------------- //
							linha(8);
							System.out.printf("â•‘ â–º Valor total da compra: R$ %.2f\t\t\t\t\t\tâ•‘\n", valorTotalCompra );
							System.out.printf("â•‘   Imposto de 9%% embutido no valor total: R$ %.2f\t\t\t\tâ•‘\n", ((valorTotalCompra / 100.0) * 9.0));
							linha(9);
							System.out.printf("â•‘ â–º OpÃ§Ãµes de pagamento:\t\t\t\t\t\t\tâ•‘\n");
							System.out.printf("â•‘     1 - Pagamento Ã  vista com 10%% de desconto: R$ %.2f\t\t\tâ•‘\n", ((valorTotalCompra / 100) * 90));
							System.out.printf("â•‘     2 - No cartÃ£o com acrÃ©scimo de 10%%: R$ %.2f\t\t\t\tâ•‘\n",((valorTotalCompra / 100) * 110));
							System.out.printf("â•‘     3 - 2x com 15%% de acrÃ©scimo, valor de cada parcela: R$ %.2f\t\tâ•‘\n",((valorTotalCompra / 200) * 115));
							linha(7);
							
							// 9 - (faÃ§a - enquanto) que valida se a opÃ§Ã£o de pagamento Ã© vÃ¡lida.				
							do {
							
								System.out.printf("Escolha a sua opÃ§Ã£o de pagamento: ");
								opcaoPagamento = leia.next().charAt(0);
								
								if (opcaoPagamento != '1' && opcaoPagamento != '2' && opcaoPagamento != '3') {
									System.out.printf("Digite uma opÃ§Ã£o vÃ¡lida!\n");	
								}
							// (FIM) 9 - (faÃ§a - enquanto) que valida se a opÃ§Ã£o de pagamento Ã© vÃ¡lida.
							} while(opcaoPagamento != '1' && opcaoPagamento != '2' && opcaoPagamento != '3');
							
							if (opcaoPagamento == '1') {
								valorFatura = ((valorTotalCompra / 100) * 90);
								quantidadeFaturas = 0;
							}
							else if (opcaoPagamento == '2') { 
								valorFatura = ((valorTotalCompra / 100) * 110);
								quantidadeFaturas = 1;
							}
							else {
								valorFatura = ((valorTotalCompra / 200) * 115);
								quantidadeFaturas = 2;
							}
						}
						
						else {
							System.out.print("\n  Digite um valor vÃ¡lido para a resposta!\n");
						}
					// (FIM) 5 - (faÃ§a - enquanto) valida se a resposta de continuar compras Ã© ou "S" ou "N".
					} while (continuarCompras != 'S' && continuarCompras != 'N');
	// FIM - PÃ�GINA DE FINALIZAÃ‡ÃƒO DA COMPRA ------------------------------------------------------------------------------------------------------------------------------------------------------------- //


				// (FIM) 4 - (faÃ§a - enquanto) valida a pergunta continuar compras.
				} while (continuarCompras == 'S');

				for (x=0 ; x < DIVERSIDADE_PRODUTOS ; x++) {
				// novo estoque inicial Ã© formado pelos produtos que nÃ£o foram retirados da compra anterior.
				estoqueInicial[x] -= estoqueSelecionado[x];

				// no fim da compra o carrinho se esvazia
				carrinho[x] = 0; 
				}
				
	//NOTA FISCAL APÃ“S A COMPRA SER FINALIZADA ---------------------------------------------------------------------------------------------------------------------------------------------------------- //
				paginaDeCompras(x, codigo, produto, valor, estoqueInicial, carrinho, estoqueSelecionado, carrinhoVazio);

				notaFiscal(x, estoqueSelecionado, valorFatura, quantidadeFaturas, codigo, valor, produto, Integer.parseInt(numeroNotaFiscal)+1, contadorNotaFiscal);
				contadorNotaFiscal ++;
				numeroNotaFiscal = Integer.toString(contadorNotaFiscal-1);
	// (FIM) NOTA FISCAL APÃ“S A COMPRA SER FINALIZADA --------------------------------------------------------------------------------------------------------------------------------------------------- //
				
				
				do {
				// 10 - (faÃ§a - enquanto) valida a resposta para voltar Ã  pÃ¡gina inicial.
					System.out.print("\n Voltar para a pÃ¡gina inicial? [S/N]: ");
					respostaVoltarInicio = leia.next().toUpperCase().charAt(0);
					
					if (respostaVoltarInicio == 'N') {
						System.out.print("  ATÃ‰ BREVE!!!");
						break;
					}
					else if (respostaVoltarInicio != 'S') {
						System.out.print("Digite uma resposta vÃ¡lida!\n");
					}

				// (FIM) 10 - (faÃ§a - enquanto) valida a resposta para voltar Ã  pÃ¡gina inicial.	
				} while(respostaVoltarInicio != 'N' && respostaVoltarInicio != 'S');
				
			}
			
			// condicional responsÃ¡vel pela respostas [S/N]
			else if (fazerCompras == 'N') {
				System.out.print("  ATÃ‰ BREVE!!!");
				break;
			} 
			else {
				limpa();
				cabecalho(3);
				System.out.print("  Digite uma resposta vÃ¡lida!\n");
			}
			
		// 1 - (laÃ§o faÃ§a - enquanto) valida "fazer compras".
		} while (fazerCompras != 'N' && fazerCompras != 'S');
		

	//a compra foi finalizada, entÃ£o quando retornar ao inÃ­cio, o estoque selecionado serÃ¡ igual a zero.
	for (x=0 ; x < DIVERSIDADE_PRODUTOS ; x++) {
		estoqueSelecionado[x] = 0;
	}
	
	// a compra foi finalizada, entÃ£o quando retornar ao inÃ­cio, a resposta continuar compras volta a ser SIM.
	continuarCompras = 'S';

	//(laÃ§o faÃ§a - enquanto) responsÃ¡vel por retornar ao inÃ­cio apÃ³s a compra.	
	} while(respostaVoltarInicio == 'S');
	
	leia.close();
}


// FIM DO PROGRAMA -------------------------------------------------------------------- //

		
		
			

	
	
		//cabecalho (inteiro linhaPrincipal)
	public static void cabecalho(int linhaPrincipal)  {
		System.out.println("\t\t      â–º PORTO GOL ACESSÃ“RIOS ESPORTIVOS â—„");
		System.out.println("\t Desconto real, qualidade constante, satisfaÃ§Ã£o por inteiro !");
		linha(linhaPrincipal);	
	}
	
	
	// FUNÃ‡ÃƒO PÃ�GINA DE COMPRAS --------------------------------------------------------------------------------------------------------------------------------------------------------------------- //
		// Chama a "loja" com seus produtos e o carrinho.
		public static void paginaDeCompras (int x, String codigo[], String produto[], String valor[], int estoqueInicial[], int carrinho[], int estoqueSelecionado[], int carrinhoQuantidade ) {
			
			limpa();
			cabecalho(4);
			System.out.println("â•‘ CÃ³d\tâ”‚ Produto\t\t\tâ”‚ Valor\t\t  â”‚ Estoque\t\tâ•‘");
			linha(6);
						
			/* (laÃ§o para) que cria as informaÃ§Ãµes presentes abaixo do menu: 
			cÃ³digos, produtos, valores e estoque.*/
			for(x=0 ; x < DIVERSIDADE_PRODUTOS ; x++) { 
							
				System.out.print("â•‘ "+ codigo[x]+"\tâ”‚ "+produto[x]+"\tâ”‚ "+valor[x]+"\t  â”‚ "+estoqueInicial[x]+"\t\t\tâ•‘\n");	
						
			}
						
			// carrinho de compras.
			linha(1);
			System.out.printf("â•‘ Carrinho de compras\t\t\t\t\t\t\t\tâ•‘\n");
			System.out.printf("â•‘         â”Œâ”�\t\t\t\t\t\t\t\t\tâ•‘\n");
			System.out.printf("â•‘  â”Œâ”¬â”¬â”¬â”¬â”¬â”�âŒ¡ \t\t\t\t\t\t\t\t\tâ•‘\n");
			
			carrinhoQuantidade = 0;
			
			for(x=0 ; x < DIVERSIDADE_PRODUTOS ; x++) {
				if (carrinho[x] == 1 && estoqueSelecionado[x] != 0) {
						carrinhoQuantidade++;
				}
			}
			if (carrinhoQuantidade == 0) {
				System.out.printf("â•‘  â””_____/ \t\t\t\tâ–º Seu carrinho estÃ¡ vazio â—„\t\tâ•‘\n");
			}
			else  {
				System.out.printf("â•‘  â””_____/ \t\t\t\tâ–º Adicione mais produtos! â—„\t\tâ•‘\n");
			}
			System.out.print("â•‘    Ïƒ  Ïƒ ["+carrinhoQuantidade+"]\t\t\t\t\t\t\t\t\tâ•‘\n");
			System.out.printf("â•‘\t\t\t\t\t\t\t\t\t\tâ•‘\n");
			for(x=0 ; x < DIVERSIDADE_PRODUTOS ; x++) {
				if (carrinho[x] == 1 && estoqueSelecionado[x] != 0) {
					System.out.print("â•‘ "+ codigo[x]+"\tâ”‚ "+produto[x]+"\tâ”‚ "+valor[x]+"\t  â”‚["+ estoqueInicial[x]+ "] QTDE - \t"+ estoqueSelecionado[x]+ "\tâ•‘\n");
				}
			}
			linha(7);
		}
			 {
				
				
			}
		// FIM DA FUNÃ‡ÃƒO PÃ�GINA DE COMPRAS --------------------------------------------------------------------------------------------------------------------- //	
	
			 public static void linha(int tipoLinha) {
		
		if(tipoLinha == 0) {
			
			System.out.println("â•‘-------------------------------------------------------------------------------â•‘");
		}
		else if(tipoLinha == 1) {
			
			System.out.println("â•Ÿâ”€â”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â•¢");
			
		}
		
		else if(tipoLinha == 6) { 
			System.out.println("â•Ÿâ”€â”€â”€â”€â”€â”€â”€â”¼â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¼â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¼â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â•¢");
			
		}
		
		else if(tipoLinha == 3) {
			
			System.out.println("\nâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�");
			
		}
		
		else if(tipoLinha == 4) {
			
			System.out.println("\nâ•”â•�â•�â•�â•�â•�â•�â•�â•¤â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•¤â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•¤â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—");
			
		}
		
		else if(tipoLinha == 5) {
			
			System.out.println("â•šâ•�â•�â•�â•�â•�â•�â•�â•§â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•§â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•§â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�");

		}

		else if(tipoLinha == 7) {
			
			System.out.println("â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�");
		
		}
		
		else if(tipoLinha == 8) {
			
			System.out.println("â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—");
			
		}
		
		else if(tipoLinha == 9) {
		
			System.out.println("â•Ÿâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â•¢");
		}
		
		else if(tipoLinha == 10) {
			
			System.out.println("â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€");
			
		}
		
	}
	// FUNÃ‡ÃƒO LIMPA ---------------------------------------------------------------------------------------------- //

	public static void limpa() {
	
		for(int x = 0; x < 50; x++ ) {
			System.out.println("");
		}
	
	}
//FUNÃ‡ÃƒO LIMPA ---------------------------------------------------------------------------------------------- //
	

	// FUNÃ‡ÃƒO NOTA FISCAL ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- //
	/* cria a nota fiscal no fim da compra e armazena valores de notas anteriores,
	por meio de matrizes, quando a pessoa pedir apertando a tecla [V].*/

	public static void notaFiscal (int x, int estoqueSelecionado[], double valorFatura, int quantidadeFaturas, String codigo[], String valor[], String produto[], int numeroNotaFiscal, int contadorNotaFiscal) {

		// se o numero da Nota for igual ao do contador, significa que Ã© uma nova nota, ou seja, novos valores serÃ£o guardados.
		// Caso nÃ£o seja igual, quer dizer que a pessoa estÃ¡ querendo uma nota passada, entÃ£o o valor jÃ¡ havia sido guardado previamente.
		if (numeroNotaFiscal == contadorNotaFiscal) {
			
			anoCalendario = LocalDate.now();
			horaCalendario = Calendar.HOUR;
			minutoCalendario = Calendar.MINUTE;
			
	
			for (int colunaMatriz = 0 ; colunaMatriz < DIVERSIDADE_PRODUTOS ; colunaMatriz ++) {
				estoqueSelecionadoMatriz[numeroNotaFiscal][colunaMatriz] = estoqueSelecionado[colunaMatriz];
				
				codigoMatriz[numeroNotaFiscal][colunaMatriz] = codigo[colunaMatriz];
				
				valorMatriz[numeroNotaFiscal][colunaMatriz] = valor[colunaMatriz];
				
				produtoMatriz[numeroNotaFiscal][colunaMatriz] = produto[colunaMatriz];
			}	
			
			xVetor[numeroNotaFiscal] = x;
			
			valorFaturaVetor[numeroNotaFiscal] = valorFatura;
			
			quantidadeFaturasVetor[numeroNotaFiscal] = quantidadeFaturas;
			
			anoCalendarioVetor[numeroNotaFiscal] = anoCalendario;
			
			horaCalendarioVetor[numeroNotaFiscal] = horaCalendario;
			
			minutoCalendarioVetor[numeroNotaFiscal] = minutoCalendario;
		}		
	System.out.printf("\n â–º NOTA FISCAL ---------------------------------------------------------------\n");
	System.out.printf("â”Œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”�\n");
	System.out.printf("â”‚ â”Œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”� â”‚\n");
	System.out.printf("â”‚ â”‚                  â”‚ DANFE              â”‚ CÃ³digo de Barras                  â”‚ â”‚\n");
	System.out.printf("â”‚ â”‚ Porto-Gol.com.br â”‚ 0 - entrada        â”‚ ||| ||| | ||||| || || ||||| ||    â”‚ â”‚\n");
	System.out.printf("â”‚ â”‚                  â”‚ 1 - saÃ­da          â”‚                                   â”‚ â”‚\n");
	System.out.printf("â”‚ â””â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”˜ â”‚\n");
	System.out.printf("â”‚ â”Œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”� â”‚\n");
	System.out.printf("â”‚ â”‚ Natureza da operaÃ§Ã£o        â”‚ NÃºmero de Protocolo                         â”‚ â”‚\n");
	System.out.printf("â”‚ â”‚ Venda de mercadorias        â”‚ xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx     â”‚ â”‚\n");
	System.out.printf("â”‚ â””â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”˜ â”‚\n");
	System.out.printf("â”‚  DestinatÃ¡rio/ remetente                                                      â”‚\n");
	System.out.printf("â”‚ â”Œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”�â”Œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”� â”‚\n");
	System.out.printf("â”‚ â”‚ Nome/ RazÃ£o Social    â”‚ CPF                     â”‚â”‚ Data de emissÃ£o        â”‚ â”‚\n");
	System.out.printf("â”‚ â”‚ XXXXXXXXXXXXXX        â”‚ XXX.XXX.XXX-XX          â”‚â”‚ \t%s\t      â”‚ â”‚\n", anoCalendarioVetor[numeroNotaFiscal]);
	System.out.printf("â”‚ â”œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¤â”œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¤ â”‚\n");
	System.out.printf("â”‚ â”‚ EndereÃ§o          â”‚ Bairro/ Distritoâ”‚ CEP       â”‚â”‚ Data de SaÃ­da/ Entrada â”‚ â”‚\n");
	System.out.printf("â”‚ â”‚ xxx xxxxxxxxxxx   â”‚ xxxx xxxx       â”‚ xxxxx-xxx â”‚â”‚ \t%s\t      â”‚ â”‚\n", anoCalendarioVetor[numeroNotaFiscal]);
	System.out.printf("â”‚ â”œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”€â”¬â”€â”´â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¤â”œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¤ â”‚\n");
	System.out.printf("â”‚ â”‚ MunicÃ­pio  â”‚ UF â”‚ CEP        â”‚ Fone             â”‚â”‚ Hora da SaÃ­da          â”‚ â”‚\n");
	System.out.printf("â”‚ â”‚ xxxxxxx    â”‚ XX â”‚ xxxxx-xxx  â”‚ xxxxx-xxxx       â”‚â”‚   %s:%s\t\t      â”‚ â”‚\n", horaCalendarioVetor[numeroNotaFiscal], minutoCalendarioVetor[numeroNotaFiscal]);
	System.out.printf("â”‚ â””â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”˜â””â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”˜ â”‚\n");
	System.out.printf("â”‚  Valor das Faturas                                                            â”‚\n");
	System.out.printf("â”‚ â”Œâ”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”€â”€â”€â”€â”� â”‚\n");
	System.out.printf("â”‚ â”‚ NÃºmero    â”‚ Vencimento                       â”‚ Valor              â”‚ QTD   â”‚ â”‚\n");
	System.out.printf("â”‚ â”‚ XXXXXX    â”‚ xx/xx/xxxx                       â”‚ %.2f\t      â”‚\t%d     â”‚ â”‚\n", valorFaturaVetor[numeroNotaFiscal], quantidadeFaturasVetor[numeroNotaFiscal]);
	System.out.printf("â”‚ â””â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”€â”˜ â”‚\n");
	System.out.printf("â”‚  Itens da Nota Fiscal                                                         â”‚\n");
	System.out.printf("â”‚ â”Œâ”€â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”¬â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”� â”‚\n");
	System.out.printf("â”‚ â”‚ CÃ³d.  â”‚ Produto                 â”‚ QTDE.â”‚ Valor Un.â”‚ Valor Tot.â”‚ Imposto   â”‚ â”‚\n");
					

	// SÃ©rie de formataÃ§Ãµes para que valores com diferentes nÃºmeros de caracteres nÃ£o quebrem o layout da pÃ¡gina.				
	for(x=0 ; x < DIVERSIDADE_PRODUTOS ; x++) {
		
		if (estoqueSelecionadoMatriz[numeroNotaFiscal][x] != 0) {
						
				if (numeroNotaFiscal == contadorNotaFiscal) {
					if (x <= 8) {
					formataCodigo = codigoMatriz[numeroNotaFiscal][x] + " ";
					}
					else {
					formataCodigo = codigoMatriz[numeroNotaFiscal][x];
					}
										
					if (estoqueSelecionadoMatriz[numeroNotaFiscal][x] <= 9) {
					formataEstoqueSelecionado[x] = estoqueSelecionadoMatriz[numeroNotaFiscal][x] + " ";
					}
					else {
					formataEstoqueSelecionado[x] = estoqueSelecionadoMatriz[numeroNotaFiscal][x] +"";	
					}
			
					formataValorTotal[x] = String.valueOf((Double.parseDouble(valorMatriz[numeroNotaFiscal][x]) * estoqueSelecionadoMatriz[numeroNotaFiscal][x]));
										
					formataImposto[x] =  ((Double.parseDouble(formataValorTotal[x]) / 100) * 9);
										
		 
					formataValorTotalNumero = ( String.valueOf((Double.parseDouble(valorMatriz[numeroNotaFiscal][x]) * estoqueSelecionado[x]))).length();
					
					while (formataValorTotalNumero <= 7) {
					formataValorTotalNumero ++;
					formataValorTotal[x] += " ";
					}
					
				}					
					if (formataImposto[x] >= 10) {
						System.out.printf("â”‚ â”‚ %s â”‚ %s â”‚  %s  â”‚  %s  â”‚ %s  â”‚ %.2f     â”‚ â”‚\n", formataCodigo, produtoMatriz[numeroNotaFiscal][x], formataEstoqueSelecionado[x], valorMatriz[numeroNotaFiscal][x], formataValorTotal[x], formataImposto[x]);	
					}
					else {
						System.out.printf("â”‚ â”‚ %s â”‚ %s â”‚  %s  â”‚  %s  â”‚ %s  â”‚ %.2f      â”‚ â”‚\n", formataCodigo, produtoMatriz[numeroNotaFiscal][x], formataEstoqueSelecionado[x], valorMatriz[numeroNotaFiscal][x], formataValorTotal[x], formataImposto[x]);
					}
				}
	}
	System.out.printf("â”‚ â””â”€â”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”´â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”˜ â”‚\n");
	System.out.printf("â””â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”˜\n");
					
	}
	// FIM DA FUNÃ‡ÃƒO NOTA FISCAL ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- //

	/* NÃ³s somos alunes da Generation Brasil, esse Ã© o nosso estudo sobre princÃ­pios da lÃ³gica de programaÃ§Ã£o feito em Portugol.
	 *  Equipe:
	 *  Ana Carolina Gonzales 
	 *  Andrei Felipe
	 *  FÃ¡bio Campaner Suzuki
	 *  Marcos Coutinho
	 *  Stefani Tosi
	 *  VinÃ­cios Lisboa
	 } */ 

}



