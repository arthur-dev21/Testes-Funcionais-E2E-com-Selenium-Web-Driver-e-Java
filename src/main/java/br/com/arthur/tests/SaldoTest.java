package br.com.arthur.tests;

import br.com.arthur.core.*;
import br.com.arthur.pages.*;
import org.junit.*;

public class SaldoTest extends BaseTest {

    HomePage homePage = new HomePage();
    MenuPage menuPage = new MenuPage();

    @Ignore
    @Test
    public void testSaldoConta(){
        menuPage.acessarTelaPrincipal();
        Assert.assertEquals("1500.00", homePage.obterSaldoConta("Conta do Teste"));
    }
}
