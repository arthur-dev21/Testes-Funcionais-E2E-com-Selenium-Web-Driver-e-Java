package br.com.arthur.suite;

import br.com.arthur.core.*;
import br.com.arthur.pages.*;
import br.com.arthur.tests.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContaTest.class,
        MovimentacaoTest.class,
        RemoverMovimentacaoContaTest.class,
        SaldoTest.class,
        ResumoTest.class

})
public class SuiteGeral {

	private static LoginPage loginPage = new LoginPage();

    @BeforeClass
	public static void incializa(){
		loginPage.acessarTelaInicial();
		loginPage.setEmail("arthurkenned21@gmail.com");
		loginPage.setSenha("123");
		loginPage.entrar();
	}

	@AfterClass
	public static void finalizar(){
		DriverFactory.killDriver();
	}

}
