package objects;

import com.codeborne.selenide.SelenideElement;
import helpers.Constants;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class CreatePreRequestPage {

    private SelenideElement selectBoxType = $(byId("requestType"));

    private SelenideElement inputDescription = $(byId("description"));

    private SelenideElement buttonCreateRequest = $(byId("createRequest"));

    @Step("Open Create Request page")
    public CreatePreRequestPage openCreatePreRequestPage(String customerCode){
        open("/" + customerCode + "/operator/create");
        return page(CreatePreRequestPage.class);
    }

    @Step("Select Request Type {0}")
    public CreatePreRequestPage selectRequestType(String requestType){
        $(selectBoxType).click();
        $(withText(requestType)).click();
        return this;
    }

    @Step("Enter text into 'How can we help you?'")
    public CreatePreRequestPage fillHowWeCanHelp(String textValue){
        $(inputDescription).setValue(textValue);
        return this;
    }

    @Step("Press Create Request")
    public RequestUpdateStep clickCreateRequest(){
        $(buttonCreateRequest).click();
      //  page(RequestUpdateStep.class).isRequestUpdateStepLoaded().shouldHave(Condition.exactText("REQUEST UPDATE"));
        return  page(RequestUpdateStep.class);
    }

    public RequestUpdateStep openAndFillAllMandatoryFieldsForPreRequest(){
        openCreatePreRequestPage(Constants.CUSTOMER_CHZRH99)
                .selectRequestType("Quality NCR")
                .fillHowWeCanHelp("Text is enetred by Autotest")
                .clickCreateRequest();
        return page(RequestUpdateStep.class);
    }

    public void fillAllMandatoryFieldsForPreRequestAndClickOnCreate(String requestType, String howWeCanHelpYou){
        selectRequestType(requestType)
                .fillHowWeCanHelp(howWeCanHelpYou)
                .clickCreateRequest();
    }
}
