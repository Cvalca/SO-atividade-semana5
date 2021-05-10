package atividadeSemana5Q1;

public class MinhaThreadSoma implements Runnable
{

	private String nome;
	private int[] nums;
	private static Calculadora calc1 = new Calculadora(1); 
	private static Calculadora calc2 = new Calculadora(2); 
	private static boolean recursoDisponivel;
	private boolean terminou = false;

	public MinhaThreadSoma (String nome, int[] nums)
	{
		this.nome = nome;
		this.nums = nums;
		new Thread(this, nome).start();
	}

	public static synchronized Calculadora calcManager(MinhaThreadSoma a) {
		System.out.println(a.nome+ " Entrou na região Crítica.");
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!calc1.emUso) {
			
			calc1.emUso = true;
			System.out.println(a.nome+ " saiu da região Crítica.");
			return calc1;
		}
		if(!calc2.emUso){
			calc2.emUso = true;
			System.out.println(a.nome+ " saiu da região Crítica.");
			return calc2;
		}
		System.out.println(a.nome+ " saiu da região Crítica.");
		return null;
	}
	@Override
	public void run() {
		System.out.println(this.nome+ " iniciada");
		while(!terminou) {


			Calculadora c = calcManager(this);
			if(c != null) {
				int soma = c.somaArray(this.nums, this.nome);
				System.out.println("Thread " + this.nome + " na calculadora "+ c.id + " é: " + soma);
				c.emUso = false;
				this.terminou = true;
			}

		}
		System.out.println(this.nome + " terminada");
	}
}
