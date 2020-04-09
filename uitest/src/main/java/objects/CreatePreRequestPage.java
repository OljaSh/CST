package objects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CreatePreRequestPage {

    private SelenideElement selectBoxType = $(byId("requestType"));

    private SelenideElement inputDescription = $(byId("description"));

    private SelenideElement buttonCreateRequest = $(byId("createRequest"));

    @Step("Select Request Type {0}")
    public CreatePreRequestPage selectRequestType(String requestType) {
        $(selectBoxType).click();
        $(withText(requestType)).click();
        return this;
    }

    @Step("Enter text into 'How can we help you?'")
    public CreatePreRequestPage fillHowWeCanHelp(String textValue) {
        $(inputDescription).setValue(textValue);
        return this;
    }

    @Step("Press Create Request")
    public RequestUpdateStep clickCreateRequest() {
        $(buttonCreateRequest).click();
        return page(RequestUpdateStep.class);
    }

    public RequestUpdateStep  fillAllMandatoryFieldsAndCreate(String requestType, String description){
        // openCreatePreRequestPage(customer)
        selectRequestType(requestType)
                .fillHowWeCanHelp(description)
                .clickCreateRequest();
        return  page(RequestUpdateStep.class);
    }
}
