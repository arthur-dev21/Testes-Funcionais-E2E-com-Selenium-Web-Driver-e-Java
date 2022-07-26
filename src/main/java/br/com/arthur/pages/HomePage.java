package br.com.arthur.pages;

import br.com.arthur.core.*;
import org.openqa.selenium.*;

public class HomePage extends BasePage {

    public String obterSaldoConta(String nome){
        return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
    }
}
