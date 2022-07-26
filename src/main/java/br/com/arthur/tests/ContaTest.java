package br.com.arthur.tests;

import br.com.arthur.core.*;
import br.com.arthur.pages.*;
import org.junit.*;
import org.junit.runners.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void test1_InserirConta(){
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome("Conta do Teste1");
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void test2_AlterarConta(){
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarAlterarConta("Conta do Teste1");
		
		contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
	}

	@Test
	public void test3_InserirConta_ComOMesmoNome(){
		menuPage.acessarTelaInserirConta();

		contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		contasPage.salvar();

		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
	}



}
