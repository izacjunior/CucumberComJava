package steps;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import entidades.AluguelService;
import entidades.Filme;
import entidades.NotaAluguel;

public class AlugarFilmesStpes {

	private Filme filme;
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel nota;
	private String erro;
	
	
	@Dado("^um filme com estoque (\\d+) unidades$")
	public void umFilmeComEstoqueUnidades(int arg1) throws Throwable {
	   filme = new Filme();
	   filme.setEstoque(arg1);
	}

	@Dado("^que o preco do aluguel seja R\\$ (\\d+)$")
	public void queOPreODoAluguelSejaR$(int arg1) throws Throwable {
	  filme.setAluguel(arg1);
	}

	@Quando("^alugar$")
	public void alugar() throws Throwable {
	   try {
		nota = aluguel.alugar(filme);
	   }catch (RuntimeException e) {
		   erro = e.getMessage();
	   }
	}

	@Entao("^o preco do aluguel sera R\\$ (\\d+)$")
	public void oPreODoAluguelSeraR$(int arg1) throws Throwable {
		assertEquals(arg1,nota.getPreco());
	}

	@Entao("^a data de entrega sera no dia seguinte$")
	public void aDataDeEntregaSeraNoDiaSeguinte() throws Throwable {
	  
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,1);
		
		Date dataRetorno = nota.getDataEntrega();
		Calendar calRetorno = Calendar.getInstance();
		calRetorno.setTime(dataRetorno);
		assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
		assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.MONTH));
		assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.YEAR));
		
	}

	@Entao("^o estoque do filme sera (\\d+) unidade$")
	public void oEstoqueDoFilmeSeraUnidade(int arg1) throws Throwable {
	    
		assertEquals(arg1, filme.getEstoque());
	}
	
	@Entao("^nao sera possivel por falta de estoque$")
	public void naoSeraPossivelPorFaltaDeEstoque() throws Throwable {
	   assertEquals("FILME SEM ESTOQUE", erro);
	}
	
}
