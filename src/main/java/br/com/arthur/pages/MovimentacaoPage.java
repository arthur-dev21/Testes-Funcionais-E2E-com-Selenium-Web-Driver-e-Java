package br.com.arthur.pages;

import br.com.arthur.core.*;
import org.openqa.selenium.*;

import java.util.*;

public class MovimentacaoPage extends BasePage {

    public void setDataMovimentacao(String data){
        escrever("data_transacao",data);
    }

    public void setDataPagamento(String data){
        escrever("data_pagamento",data);
    }

    public void setDescricao(String descricao){
        escrever("descricao",descricao);
    }

    public void setInteressado(String interessado){
        escrever("interessado",interessado);
    }

    public void setValor(String valor){
        escrever("valor",valor);
    }

    public void setConta(String conta){
        selecionarCombo("conta", conta);
    }

     public void setStatusPago(){
        clicarRadio("status_pago");
     }

     public void salvar(){
        clicarBotaoPorTexto("Salvar");
     }

    public String obterMensagemSucesso(){
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public List<String>obterErros(){
       List<WebElement> erros =  DriverFactory.getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
        List<String> retorno = new ArrayList<>();

        for (WebElement element : erros){
            retorno.add(element.getText());
        }

        return  retorno;
    }
}
