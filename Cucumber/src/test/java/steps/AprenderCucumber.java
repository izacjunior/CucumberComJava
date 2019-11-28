package steps;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class AprenderCucumber {
	
			@Dado("^que criei o arquivo correntamente$")
		public void que_criei_o_arquivo_correntamente() throws Throwable {
		}

		@Quando("^executar$")
		public void executar() throws Throwable {
		}

		@Entao("^a especificacao deve finalizar$")
		public void a_especificacao_deve_finalizar() throws Throwable {

		}

		int contador = 0;

		@Dado("^que o valor do contador e (\\d+)$")
		public void que_o_valor_do_contador_e(int arg1) throws Throwable {
			contador = arg1;
		}

		@Quando("^eu incrementar em (\\d+)$")
		public void eu_incrementar_em(int arg1) throws Throwable {
			contador = contador + arg1;
		}

		@Entao("^o valor do contador sera (\\d+)$")
		public void o_valor_do_contador_sera(int arg1) throws Throwable {
			System.out.println(arg1);
			System.out.println(contador);
			assertEquals(arg1, contador);
		}

		// SITE PARA VERIFICAR REGEX - https://jex.im/regulex/

		Date entrega = new Date();

		@Dado("^que a entrega e dia (\\d+)/(\\d+)/(\\d+)$")
		public void que_a_entrega_e_dia(int dia, int mes, int ano) throws Throwable {

			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.DAY_OF_MONTH, dia);
			cal.set(Calendar.MONTH, mes - 1);
			cal.set(Calendar.YEAR, ano);
			entrega = cal.getTime();
		}

		@Quando("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
		public void a_entrega_atrasar_em_dias(int arg1, String tempo) throws Throwable {
			Calendar cal = Calendar.getInstance();
			cal.setTime(entrega);
			if (tempo.equals("dias")) {
				cal.add(Calendar.DAY_OF_MONTH, arg1);
			}
			if (tempo.equals("meses")) {
				cal.add(Calendar.MONTH, arg1);
			}
			entrega = cal.getTime();

		}

		@Entao("^a entrega sera efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
		public void a_entrega_sera_efetuada_em(String data) throws Throwable {

			DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			String dataFormatada = format.format(entrega);
			assertEquals(dataFormatada, data);
		}

	}


