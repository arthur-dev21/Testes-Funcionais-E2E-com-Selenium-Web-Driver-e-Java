package br.com.arthur.pages;

import br.com.arthur.core.*;
import org.openqa.selenium.*;

public class ResumoPage extends BasePage {

    public void excluirMovimentacao(){
        clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
    }

    public String obterMensagemSucesso(){
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }


}
