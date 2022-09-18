package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#email")
    private WebElement emailTxt;
    @FindBy(css = "#password")
    private WebElement passwordTxt;

    @FindBy(css = "button[value='default']")
    private WebElement crearCuentaBtn;

    @FindBy(css = "span[class='a-header__topLink']")
    private WebElement crearCuentaLink;

    @FindBy(css = "#input-user__name")
    private WebElement userNameTxt;

    @FindBy(css = "#input-user__apaterno")
    private WebElement apellidoMaternoTxt;

    @FindBy(id = "daySelectorLabel")
    private WebElement dayDrpDwn;

    @FindBy(id = "monthSelectorLabel")
    private WebElement monthDrpDwn;

    @FindBy(id = "yearSelectorLabel")
    private WebElement yearDrpDwn;

    @FindBy(id = "male")
    private WebElement maleSex;

    @FindBy(id = "female")
    private WebElement femaleSex;

    @FindBy(css = ".a-btn.a-btn--primary")
    private WebElement createAccountBtn;


    public void email(String email){
        emailTxt.sendKeys(email);
    }

    public void password(String password){
        passwordTxt.sendKeys(password);
    }

    public void clickCrearCuentaLink(){
        crearCuentaLink.click();
    }

    public void clickCrearCuentaBtn(){
        crearCuentaBtn.click();
    }

    public void sendUserName(String userName){
        userNameTxt.sendKeys(userName);
    }

    public void sendApellidoPaterno(String apellidoPaterno){
        apellidoMaternoTxt.sendKeys(apellidoPaterno);
    }

    public void sendApellidoMaterno(String apellidoMaterno){
        apellidoMaternoTxt.sendKeys(apellidoMaterno);
    }

    public void selectDay(String day){
        Select drpDwnDay = new Select(dayDrpDwn);
        drpDwnDay.selectByValue(day);
    }

    public void selectMonth(String month){
        Select drpDwnMonth = new Select(monthDrpDwn);
        drpDwnMonth.selectByValue(month);//Only first three letters
    }

    public void selectYear(String year){
        Select drpDwnYear = new Select(yearDrpDwn);
        drpDwnYear.selectByValue(year);
    }

    public void selectMaleSex(){
        maleSex.click();
    }
    public void selectFemaleSex(){
        femaleSex.click();
    }

    public void clickCreateAccountBtn(){
        createAccountBtn.click();
    }
}
