package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#mainSearchbar")
    private WebElement searchBar;

    @FindBy(css = "button[class='input-group-text'] i[class='icon-zoom']")
    private WebElement searchBtn;

    @FindBy(xpath = "//span[@class='a-header__topLink']")
    private WebElement loginBtn;

    public void inputArticleSearchBar(String article) {
        searchBar.sendKeys(article);
    }

    public void clickSearchBtn() {
        searchBtn.click();
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

}
