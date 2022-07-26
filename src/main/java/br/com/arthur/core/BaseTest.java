package br.com.arthur.core;

import static br.com.arthur.core.DriverFactory.getDriver;
//import static br.com.arthur.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import br.com.arthur.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	private LoginPage loginPage = new LoginPage();
	@Rule
	public TestName testName = new TestName();

	// esse metodo sera usada por todas suas classes filhas para fazer login antes da execuçao dos testes
	@Before
	public void incializa(){
		loginPage.acessarTelaInicial();
		loginPage.setEmail("arthurkenned21@gmail.com");
		loginPage.setSenha("123");
		loginPage.entrar();
	}
	
	@After
	public void finaliza() throws IOException{
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
				File.separator + testName.getMethodName() + ".jpg"));
		
		if(Propriedades.FECHAR_BROWSER) {
			DriverFactory.killDriver();
		}
	}

}
