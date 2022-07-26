package br.com.arthur.tests;

import br.com.arthur.core.*;
import br.com.arthur.pages.*;
import org.junit.*;

public class RemoverMovimentacaoContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void testExcluirConta_ComMovimentacao(){
        menuPage.acessarTelaListarConta();

        contasPage.clicarExcluirConta(Propriedades.NOME_CONTA_ALTERADA);
        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());

    }
}
