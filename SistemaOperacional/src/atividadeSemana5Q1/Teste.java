package atividadeSemana5Q1;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array1 = {1,2,3,4,5}; //15 SOMA
		int[] array2 = {2,3,4,5,6}; //20 SOMA
		int[] array3 = {2,3,4,5,10}; // 24 SOMA 
		int[] array4 = {10,3,4,5,6}; // 28 SOMA
		int[] array5 = {2,3,10,5,6}; // 26 SOMA
		
		MinhaThreadSoma t1 = new MinhaThreadSoma("#1", array1);
		MinhaThreadSoma t2 = new MinhaThreadSoma("#2", array2);
		MinhaThreadSoma t3 = new MinhaThreadSoma("#3", array3);
		MinhaThreadSoma t4 = new MinhaThreadSoma("#4", array4);
		MinhaThreadSoma t5 = new MinhaThreadSoma("#5", array5);
//		MinhaThreadSoma t6 = new MinhaThreadSoma("#6", array1);
//		MinhaThreadSoma t7 = new MinhaThreadSoma("#7", array2);
//		MinhaThreadSoma t8 = new MinhaThreadSoma("#8", array3);
//		MinhaThreadSoma t9 = new MinhaThreadSoma("#9", array4);
//		MinhaThreadSoma t10 = new MinhaThreadSoma("#10", array5);
//		
//		MinhaThreadSoma t11 = new MinhaThreadSoma("#11", array1);
//		MinhaThreadSoma t12 = new MinhaThreadSoma("#12", array2);
//		MinhaThreadSoma t13 = new MinhaThreadSoma("#13", array3);
//		MinhaThreadSoma t14 = new MinhaThreadSoma("#14", array4);
//		MinhaThreadSoma t15 = new MinhaThreadSoma("#15", array5);		
//		MinhaThreadSoma t16 = new MinhaThreadSoma("#16", array1);
//		MinhaThreadSoma t17 = new MinhaThreadSoma("#17", array2);		
//		MinhaThreadSoma t18 = new MinhaThreadSoma("#18", array3);
//		MinhaThreadSoma t19 = new MinhaThreadSoma("#19", array4);
//		MinhaThreadSoma t20 = new MinhaThreadSoma("#20", array5);
	}

}
