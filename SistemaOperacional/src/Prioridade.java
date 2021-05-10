import java.util.ArrayList;

public class Prioridade {
	
	private ArrayList<Processo> listaDeProcessos;
	
	public Prioridade(ArrayList<Processo> listaDeProcessos) {
		super();
		this.listaDeProcessos = listaDeProcessos;
	}
	
	public ArrayList<Processo> getListaDeProcessos() {
		return listaDeProcessos;
	}

	public void setListaDeProcessos(ArrayList<Processo> listaDeProcessos) {
		this.listaDeProcessos = listaDeProcessos;
	}

	public void escalonar(ArrayList<Processo>  listaDeProcessos, int quantum) {
		
	}

}
