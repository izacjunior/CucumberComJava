package runners;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", glue = "steps", plugin = { "pretty",
		"html:target/report.html", "json:target/report.json" }, monochrome = false, tags = {
				"@funcionais" }, snippets = SnippetType.CAMELCASE, dryRun = false, strict = false)

public class RuunerFuncionalTest {

	static WebDriver driver;
	
	@BeforeClass
	public static void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\f799396\\Desktop\\Estudos\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://srbarriga.herokuapp.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("email")).sendKeys("izacjunior@gmail.com");
		driver.findElement(By.name("senha")).sendKeys("123456");
		driver.findElement(By.tagName("button")).click();

		driver.findElement(By.linkText("reset")).click();
		
		driver.quit();
		
		
	}

}

// RETIRAR AS CORES OU NAO - monochrome = true
// GERAR RELATORIOS - plugin = {"pretty", "html:target/report.html"}
// RODAR SOMENTE ESSE COM ESSA ANOTAÇÃO - tags = "@esse",
// PARA GERAR CENARIO DO CUCUMBER - dryRun = false
