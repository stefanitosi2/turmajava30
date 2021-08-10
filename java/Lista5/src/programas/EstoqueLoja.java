package programas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class EstoqueLoja {

	public static void main(String[] args) {
	Scanner leia = new Scanner (System.in);
	
	
	ArrayList<String> produtos = new ArrayList();
	
	produtos.add("Blusa");
	produtos.add("Calça");
	produtos.add("Sapatos");
	
	int i;
	
	int n = produtos.size();
	
	  System.out.printf("Mostrando os itens da loja\n");
		for(i=0; i<n; i++)
		{
			System.out.printf("Posição %d- %s\n",i,produtos.get(i));
		}


	System.out.println("Infome a posição a ser excluida:");
	i = leia.nextInt();
	
	try
	{
		produtos.remove(i);	
	}
	catch (IndexOutOfBoundsException e)
	{
		System.out.printf("Erro: posição invalida (%s)" , e.getMessage());
		
	}
	
	i = 0;
	for(String atualizar: produtos)
	{
		System.out.printf("Posição %d- %s\n",i,atualizar);
		i++;
	}
	 System.out.printf("Percorrendo\n ");
	 i = 0;
	 Iterator<String> iterator = produtos.iterator();
	 while(iterator.hasNext())
	 {
		 System.out.printf("Posição %d- %s\n",i, iterator.next());
		 i++;
	 }	
		

	}

}
