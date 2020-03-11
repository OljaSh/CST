package objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    //public static final By buttonLogout = By.linkText("Logout");
    private SelenideElement elementHeader = $(byClassName("right"));

    private  SelenideElement buttonLogout = $(byText("Logout"));

    private  SelenideElement filter = $(byAttribute("id", "filter"));
    private  SelenideElement content = $(byClassName("content"));

    private  SelenideElement tabArchive = $(byLinkText("Archive"));
    private  SelenideElement tabCreateRequest = $(byLinkText("Create request"));


    @Step("Switch customer")
    public MainPage switchCustomer(String customerCode){
        open("/" + customerCode + "/operator");
        return this;
    }

    @Step("Verify that user is logged. Logout option is displayed ")
    public MainPage isLogoutOptionAvailable() {
        $(buttonLogout).shouldBe(Condition.visible);
        return this;
    }

    @Step("Click on logout")
    public void clickOnLogOut() {
        $(buttonLogout).click();
    }

    @Step("Click on Create Request")
    public CreatePreRequestPage clickOnCreateRequest(){
        $(tabCreateRequest).click();
        return page(CreatePreRequestPage.class);
    }
/*
    @Step("Click on Archive tab")
    public ArchiveList clickOnArchiveTab(){
        $(tabArchive).click();
        return page(ArchiveList.class);
    }*/



}
