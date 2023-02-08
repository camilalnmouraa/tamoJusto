package stepdefinitions;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Constants;
import utils.DriveContext;
import utils.DriveManager;
import pages.ChoosingProductsPage;
import actions.ChoosingProductsAction;
import actions.LoggingAccountAction;
import pages.ChoosingProductsPage;
import pages.ChoosingProductsPage;



public class cenarioUmStep {
	DriveManager manager = new DriveManager();
	WebDriver driver = manager.AbrirUrl();
	ChoosingProductsAction actions3 = PageFactory.initElements(driver, ChoosingProductsAction.class);
	
	
	public void cenarioUmStep() {
			
	}
	
	@Given("heroi abrir site {string}")
	public void heroi_abrir_site(String url2) {
		driver.get(url2);
		driver.manage() .window() .maximize();
			
}
	
	@And("como heroi tenho {string}, {string} credenciais validas")
	public void preenche_as_credenciais_validas(String emailLogin, String passwdLogin) {
		actions3.clicarSingIn();
		actions3.writeEmailLoggin(emailLogin);
		actions3.writeTxtpasswdLoggin(passwdLogin);
	}

	@And("estou logado no site")
	public void estou_logado_no_site() {
		actions3.clickSubmitLogin();
	}

	@And("escolho o produto que desejo comprar")
	public void escolho_o_produto_que_desejo_comprar() {
		actions3.clickbtnHome();
		actions3.clickbtnTshirt();
		actions3.clickselectSale();
		actions3.clickbtnAddToCart();
		actions3.clickbtnCheckout();
		actions3.clickbtnProceedCheckout();
		
	}

	@And("seleciono o frete {string}")
	public void seleciono_o_frete (String txtAdditionalInformation) {
		actions3.writetxtLeiaEsseCampoPlease(txtAdditionalInformation);
		actions3.clickbtnProceedCheckout2();	
	}

	@And("concordo com os Terms of service")
	public void concordo_com_os_terms_of_service() {
		actions3.checkboxTerms();
		actions3.clickbtnProceedCheckout3();
	    
	}

	@When("seleciono a opcao Pay by check")
	public void seleciono_a_opcao_pay_by_check() {
		actions3.clicklinkPayByBank();
	}

	@And("confirmo meu Pedido")
	public void confirmo_meu_pedido() {
		actions3.clickbtnConfirmMyOrder();
	}

	@Then("minha compra foi concluida com sucesso")
	public void minha_compra_foi_concluida_com_sucesso() {
		driver.quit();
	}
}
