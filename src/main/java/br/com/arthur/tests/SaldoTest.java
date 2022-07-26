package br.com.arthur.tests;

import br.com.arthur.core.*;
import br.com.arthur.pages.*;
import org.junit.*;

public class SaldoTest extends BaseTest {

    HomePage homePage = new HomePage();

    @Test
    public void testSaldoConta(){
        Assert.assertEquals("1500.00", homePage.obterSaldoConta("Conta do Teste"));
    }
}
