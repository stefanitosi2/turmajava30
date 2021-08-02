import java.util.Scanner;

public class Lista1Exercicio3 {
	public static void main (String [] args)
	{
		int horas;
		int minutos;
		int segundos;
		
		Scanner leia=new Scanner(System.in);
		
		System.out.println("Digite o horario do evento em segundos");
		segundos=leia.nextInt();
		
		horas = segundos / 3600;
		minutos = (segundos/3600)/60;
		segundos = ((segundos%3600)%60);
		
		System.out.println("O eventou durou "+horas+" horas "+minutos+" minutos "+segundos+" segundos ");
		
				
		
		
		
		
	}
	

}
