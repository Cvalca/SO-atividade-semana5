
public class Processo {
	
	private int pid;
	private String nome;
	private String tipo;
	private int tempo;
	private int turnround = 0;
	private int espera = 0;
    private int entrada;

	public Processo(int pid, String nome, String tipo, int tempo, int entrada) {
		this.pid = pid;
		this.nome = nome;
		this.tipo = tipo;
		this.tempo = tempo;
		this.entrada = entrada;
	}
	
	@Override
	public boolean equals(Object obj) {
		Processo outro = (Processo) obj;
		if(outro == null) {
			return false;
		}
		if(this.pid == outro.pid) {
			return true;
		}
		return false;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo -= tempo;
	}

	public int getTurnround() {
		return turnround;
	}

	public void setTurnround(int turnround) {
		this.turnround += turnround;
	}
	
	public int getEspera() {
		return espera;
	}

	public void setEspera(int espera) {
		this.espera += espera;
	}
	
	public int getEntrada() {
		return entrada;
	}

	public void setEntrada(int entrada) {
		this.entrada = entrada;
	}
	
}
