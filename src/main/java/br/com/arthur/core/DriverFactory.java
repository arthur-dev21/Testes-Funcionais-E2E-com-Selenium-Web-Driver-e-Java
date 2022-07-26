package br.com.arthur.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static String CHROME_DRIVER = "C:/PROJETO TESTES AUTMATIZADOS/TA01-SELENIUM/driver/chromedriver.exe";
	private static String GECKODRIVER_DRIVER = "C:/PROJETO TESTES AUTMATIZADOS/TA01-SELENIUM/driver/geckodriver.exe";

	private static WebDriver driver;
	
	private DriverFactory() {}
	
	public static WebDriver getDriver(){
		if(driver == null) {
			System.setProperty("webdriver.chrome.driver",CHROME_DRIVER);
			//System.setProperty("webdriver.gecko.driver",GECKODRIVER_DRIVER);
			switch (Propriedades.browser) {
				case FIREFOX: driver = new FirefoxDriver(); break;
				case CHROME: driver = new ChromeDriver(); break;
			}
			driver.manage().window().setSize(new Dimension(1200, 765));			
		}
		return driver;
	}
	public static void killDriver(){
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
