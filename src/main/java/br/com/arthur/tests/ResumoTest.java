package br.com.arthur.tests;

import br.com.arthur.core.*;
import br.com.arthur.pages.*;
import org.junit.*;
import org.junit.runners.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private ResumoPage resumoPage = new ResumoPage();

    @Test
    public void test1_ExcluirMovimentacao(){
        menuPage.acessarTelaResumo();

        resumoPage.excluirMovimentacao();

        Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
    }


    @Test
    public void test2_ResumoMensal(){
        menuPage.acessarTelaResumo();

        Assert.assertEquals("Seu Barriga - Extrato",DriverFactory.getDriver().getTitle());
    }
}
