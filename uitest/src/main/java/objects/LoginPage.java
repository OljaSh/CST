package objects;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    private SelenideElement inputUserName = $(By.id("username"));
    private SelenideElement inputPassword = $(By.id("password"));
    private SelenideElement buttonLogin = $(By.id("logIn"));

    @Step("Open URL")
    public  LoginPage openLoginPage() {
        open("/");
        $(buttonLogin).shouldBe(Condition.visible);
        return page(LoginPage.class);
    }

    @Step("Enter username {0} and password {1}")
    public LoginPage enterLoginAndPassword(String login, String password) {
        $(inputUserName).sendKeys(login);
        $(inputPassword).setValue(password);
        return this;
    }

    @Step("Click Login")
    public MainPage clickLogin() {
        $(buttonLogin).click();
        return page(MainPage.class);
    }

    public void loginWith(String login, String password) {
        openLoginPage()
                .enterLoginAndPassword(login, password)
                .clickLogin();
        //page(MainPage.class).isLogoutOptionAvailable();  - should we use such verification ?
    }
}
