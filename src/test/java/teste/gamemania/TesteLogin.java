package teste.gamemania;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {
	
	private WebDriver driver;
	
	@Before
	public void ConfigurarTeste() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://localhost:4200/");
		
		driver.findElement(By.xpath("/html/body/app-root/app-header/header/div[1]/a[2]")).click();
	}
	
	@Test
	public void TestarLogin() {
		
		WebElement campoEmail = driver.findElement(By.id("email"));
		WebElement campoSenha = driver.findElement(By.id("senha"));
		WebElement botao = driver.findElement(By.id("botao-enviar"));
		
		String[] listaEmails = {"joao@email.com", "fabio@email.com", "fabio@email.com"};
		String[] listaSenhas = {"senhaincorreta", "senhaincorreta","senhateste"};
		
		try {
			for(int contador = 0; contador < 3; contador++) {
				campoEmail.sendKeys(listaEmails[contador]);
				campoSenha.sendKeys(listaSenhas[contador]);
				botao.click();
				
				Thread.sleep(3000);
				
				campoEmail.clear();
				campoSenha.clear();
			}
			
			
			/*
			 
			// Caso de teste de Email Incorreto
			campoEmail.sendKeys("joao@email.com");
			campoSenha.sendKeys("senhaincorreta");
			botao.click();
			
			Thread.sleep(3000);
			
			campoEmail.clear();
			campoSenha.clear();
			
			// Senha incorreta para um Email cadastrado
			campoEmail.sendKeys("fabio@email.com");
			campoSenha.sendKeys("senhaincorreta");
			botao.click();
			
			Thread.sleep(3000);
			
			campoEmail.clear();
			campoSenha.clear();
			
			// Usuário correto
			campoEmail.sendKeys("fabio@email.com");
			campoSenha.sendKeys("senhateste");
			botao.click();
			
			Thread.sleep(5000);
			
			*/
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void EncerrarTeste() {
		driver.quit();
	}

}
