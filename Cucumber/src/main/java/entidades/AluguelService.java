package entidades;

import java.util.Calendar;

import utils.DateUtils;

public class AluguelService {
	
	public NotaAluguel alugar(Filme filme) {
		if(filme.getEstoque() == 0)throw new RuntimeException("FILME SEM ESTOQUE");
		
		NotaAluguel nota = new NotaAluguel();
		nota.setPreco(filme.getAluguel());
		nota.setDataEntrega(DateUtils.obterDataDiferecaDias(1));
		filme.setEstoque(filme.getEstoque() - 1);
		return nota;
		
	}

}
