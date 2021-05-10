package atividadeSemana5Q1;

public class Calculadora {
	private int soma;
	public boolean emUso;
	public int id;
	
	public Calculadora (int id)
	{
		this.id = id;
	}
	public int somaArray (int[] array, String nome) {
		soma = 0;
		System.out.println(nome+" usando Calc "+id);
		for(int i = 0; i < array.length; i++) {
			soma += array[i];
			
			
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return soma;
	}
}
