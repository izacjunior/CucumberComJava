package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", 
				glue = "steps", 
				plugin = { "pretty", "html:target/report.html",
				"json:target/report.json" }, 
				monochrome = false, 
				tags = {"@unitarios"},
				snippets = SnippetType.CAMELCASE, 
				dryRun = false, 
				strict = false)
public class RunnerTest {

	
	
	// RETIRAR AS CORES OU NAO - monochrome = true
	// GERAR RELATORIOS - plugin = {"pretty", "html:target/report.html"}
	// RODAR SOMENTE ESSE COM ESSA ANOTAÇÃO - tags = "@esse",
	// PARA GERAR CENARIO DO CUCUMBER - dryRun = false

}
