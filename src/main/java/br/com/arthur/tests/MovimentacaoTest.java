package br.com.arthur.tests;

import br.com.arthur.core.*;
import br.com.arthur.pages.*;
import br.com.arthur.utils.*;
import org.junit.*;
import org.junit.runners.*;
import org.openqa.selenium.*;

import java.util.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {

   private  MenuPage menuPage = new MenuPage();
   private MovimentacaoPage movimentacaoPage = new MovimentacaoPage();

    @Test
    public void test1_inserirMovimentacao(){
        menuPage.acessarTelaMovimentacao();

        movimentacaoPage.setDataMovimentacao(DataUtils.obterDataFormatada(new Date()));
        movimentacaoPage.setDataPagamento(DataUtils.obterDataFormatada(new Date()));
        movimentacaoPage.setDescricao("Movimentacao Test");
        movimentacaoPage.setInteressado("Arthur");
        movimentacaoPage.setValor("2000");
        movimentacaoPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
        movimentacaoPage.setStatusPago();
        movimentacaoPage.salvar();

        Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.obterMensagemSucesso());

    }

    @Test
    public void test2_validarCamposObrigatorios(){
        menuPage.acessarTelaMovimentacao();

        movimentacaoPage.salvar();
        List<String> erros = movimentacaoPage.obterErros();

        //o problema de usar assimn é relativo a ordem que pode quebrar nosso test
        //Assert.assertEquals("Data da Movimentação é obrigatório" , erros.get(0));
        //Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
        Assert.assertTrue(erros.containsAll(Arrays.asList(
                "Data da Movimentação é obrigatório",
                "Data do pagamento é obrigatório",
                "Descrição é obrigatório",
                "Interessado é obrigatório",
                "Valor é obrigatório",
                "Valor deve ser um número"
        )));

        Assert.assertEquals(6 , erros.size());
    }

    @Test
    public void test3_inserirMovimentacaoFutura() {
        menuPage.acessarTelaMovimentacao();

        Date dataFutura = DataUtils.obterDataComDiferencaDias(5);

        movimentacaoPage.setDataMovimentacao(DataUtils.obterDataFormatada(dataFutura));
        movimentacaoPage.setDataPagamento(DataUtils.obterDataFormatada(dataFutura));
        movimentacaoPage.setDescricao("Movimentacao Test");
        movimentacaoPage.setInteressado("Arthur");
        movimentacaoPage.setValor("2000");
        movimentacaoPage.setConta(Propriedades.NOME_CONTA_ALTERADA);
        movimentacaoPage.setStatusPago();
        movimentacaoPage.salvar();

        List<String> erros = movimentacaoPage.obterErros();
        Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));

        Assert.assertEquals(1 , erros.size());

    }
}

//Data da Movimentação deve ser menor ou igual à data atual
