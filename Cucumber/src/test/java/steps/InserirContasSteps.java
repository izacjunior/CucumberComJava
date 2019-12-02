package steps;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class InserirContasSteps {

	private WebDriver driver;

//	@Dado("^que estou acessando a aplicacao$")
//	public void queEstouAcessandoAAplicacao() throws Throwable {
//
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\f799396\\Desktop\\Estudos\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get("https://srbarriga.herokuapp.com");
//		driver.manage().window().maximize();
//
//	}

	@Dado("^que desejo adicionar um conta$")
	public void queDesejoAdicionarUmConta() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\f799396\\Desktop\\Estudos\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://srbarriga.herokuapp.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("email")).sendKeys("izacjunior@gmail.com");
		driver.findElement(By.name("senha")).sendKeys("123456");
		driver.findElement(By.tagName("button")).click();

		//driver.findElement(By.linkText("reset")).click();
		
		driver.findElement(By.linkText("Contas")).click();
		

	}
	
	@Quando("^informo a conta \"([^\"]*)\"$")
	public void informoAConta(String arg1) throws Throwable {
	   		
		driver.findElement(By.linkText("Adicionar")).click();
		driver.findElement(By.id("nome")).sendKeys(arg1);
		driver.findElement(By.tagName("button")).click();

	}

//	@Quando("^informo o usuario \"([^\"]*)\"$")
//	public void informoOUsuario(String arg1) throws Throwable {
//
//		driver.findElement(By.id("email")).sendKeys(arg1);
//
//	}
//
//	@Quando("^a senha \"([^\"]*)\"$")
//	public void aSenha(String arg1) throws Throwable {
//		driver.findElement(By.id("senha")).sendKeys(arg1);
//
//	}

//	@Quando("^seleciono entrar$")
//	public void selecionoEntrar() throws Throwable {
//
//		driver.findElement(By.tagName("button")).click();
//
//	}
//
//	@Entao("^visualizo a pagina inicial$")
//	public void visualizoAPaginaInicial() throws Throwable {
//
//		String texto = driver.findElement(By.xpath("/html/body/footer/span")).getText();
//		assertEquals("Seu Barriga. Nunca mais esqueça de pagar o aluguel.reset", texto);
//	}

//	@Quando("^seleciono Contas$")
//	public void selecionoContas() throws Throwable {
//
//		driver.findElement(By.linkText("Contas")).click();
//
//	}
//
//	@Quando("^seleciono Adicionar$")
//	public void selecionoAdicionar() throws Throwable {
//
//		driver.findElement(By.linkText("Adicionar")).click();
//
//	}
//
//	@Quando("^informo a conta \"([^\"]*)\"$")
//	public void informoAConta(String arg1) throws Throwable {
//		driver.findElement(By.id("nome")).sendKeys(arg1);
//	}
//
//	@Quando("^seleciono Salvar$")
//	public void selecionoSalvar() throws Throwable {
//
//		driver.findElement(By.tagName("button")).click();
//	}

//	@Entao("^a conta e inserida com sucesso$")
//	public void aContaEInseridaComSucesso() throws Throwable {
//		String texto = driver.findElement(By.xpath("//div[@class='alert alert-success")).getText();
//		assertEquals("Conta adicionada com sucesso!", texto);
//	}
//
//	@Entao("^sou notificado que o nome da conta e obrigatorio$")
//	public void souNotificadoQueONomeDaContaEObrigatorio() throws Throwable {
//		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
//		assertEquals("Informe o nome da conta", texto);
//	}
//
//	@Entao("^sou notificado que ja existe uma conta com esse nome$")
//	public void souNotificadoQueJaExisteUmaContaComEsseNome() throws Throwable {
//		String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
//		assertEquals("Ja existe uma conta com esse nome!", texto);
//	}

	@Entao("^recebo a mensagem \"([^\"]*)\"$")
	public void receboAMensagem(String arg1) throws Throwable {
		String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
		assertEquals(arg1, texto);
	}

	@After(order = 1, value = { "@funcionais" })
	public void screenshot(Scenario cenario) throws IOException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("target/screenshot/" + cenario.getId() + ".jpg"));
	}

	@After(order = 0, value = { "@funcionais" })
	public void tearDown() {
		driver.quit();
		System.out.println("Terminando");
	}

}