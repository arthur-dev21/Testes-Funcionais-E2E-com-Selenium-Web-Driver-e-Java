package br.com.arthur.pages;

import br.com.arthur.core.BasePage;
import br.com.arthur.core.DriverFactory;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public void acessarTelaInicial(){
        DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/logout");
    }

    public void setEmail(String email){
        escrever("email" , email);
    }

    public void setSenha(String senha){
        escrever("senha" , senha);
    }

    public void entrar(){
        clicarBotao(By.xpath("//button[.='Entrar']"));
    }

    public void logar(String email,String senha){
        escrever("email" , email);
        escrever("senha" , senha);
        entrar();
    }
}
