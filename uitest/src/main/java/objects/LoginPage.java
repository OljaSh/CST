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

    private static SelenideElement buttonLogin = $(By.id("logIn"));

    @Step("Open URL")
    public static LoginPage openLoginPage() {
        open("/");
        $(buttonLogin).shouldBe(Condition.visible);
        return page(LoginPage.class);
    }

    @Step("Enter username {0} and password {1}")
    private LoginPage enterUserNameAndPassword(String userName, String password) {
        $(inputUserName).sendKeys(userName);
        $(inputPassword).setValue(password);
        return this;
    }

    @Step("Click Login")
    private MainPage clickLogin() {
        $(buttonLogin).click();
        at(MainPage.class).isButtonLogOutAvailable();
        return page(MainPage.class);
    }

    public MainPage loginWith(String userName, String password) {
        enterUserNameAndPassword(userName, password).clickLogin();
        return page(MainPage.class);
                //page(MainPage.class).isLogoutOptionAvailable();  - should we use such verification ?
    }
}
