package Classe;

import programas.Animal;

public class Cavalo extends Animal {
	
	private boolean corre;

	public Cavalo(boolean corre) {
		super();
		this.corre = corre;
	}

	public boolean isCorre() {
		return corre;
	}

	public void setCorre(boolean corre) {
		this.corre = corre;
	}
	
	

}
