package atividadeSemana5Q2;

import java.util.Comparator;

public class OrdenarPrioridade implements Comparator<Processo>{

	@Override
	public int compare(Processo o1, Processo o2) {
		if(o1.getPrioridade() > o2.getPrioridade()) {
			return -1;
		}
		else if(o1.getPrioridade() < o2.getPrioridade()) {
			return 1;
		}
		return 0;
	}
	
	
}
