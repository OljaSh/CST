package objects;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static helpers.PageFactory.at;

public class LoginPage {

    private SelenideElement inputUserName = $(By.id("username"));

    private SelenideElement inputPassword = $(By.id("password"));

    private SelenideElement buttonLogin = $(By.id("logIn"));

    @Step("Open URL")
    private LoginPage openLoginPage() {
        open("/");
        $(buttonLogin).shouldBe(Condition.visible);
        return page(LoginPage.class);
    }

    @Step("Enter username {0} and password {1}")
    private LoginPage enterLoginAndPassword(String login, String password) {
        $(inputUserName).sendKeys(login);
        $(inputPassword).setValue(password);
        return this;
    }

    @Step("Click Login")
    private MainPage clickLogin() {
        $(buttonLogin).click();
        at(MainPage.class).isButtonLogOutAvailable();
        return page(MainPage.class);
    }

    public void loginWith(String login, String password) {
        openLoginPage().enterLoginAndPassword(login, password).clickLogin();
        //page(MainPage.class).isLogoutOptionAvailable();  - should we use such verification ?
    }
}
