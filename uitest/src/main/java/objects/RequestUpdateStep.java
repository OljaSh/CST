package objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RequestUpdateStep {

    //private SelenideElement stepName = $(byId("step-request-update"));
    private SelenideElement stepName = $(byId("request-update"));

    private SelenideElement selectPriority = $(byAttribute("id", "priority"));

    private SelenideElement selectBoxHandledByLcc = $(byId("lcc"));

    private SelenideElement selectBoxHandledByTeam = $(byId("handlerGroup"));

    private SelenideElement selectBoxHandledByUser = $(byId("handlerEmail"));

    private SelenideElement selectBoxRequestingParty = $(byId("requestingParty"));

    private SelenideElement selectBoxInvolvedParties = $(byId("involvedParties"));

    private SelenideElement selectBoxHReasonCodesL1 = $(byId("reasonCodeL1"));
    private SelenideElement selectBoxHReasonCodesL2 = $(byId("reasonCodeL2"));
    private SelenideElement selectBoxHReasonCodesL3 = $(byId("reasonCodeL3"));
    private SelenideElement selectBoxHRootCauseParty = $(byId("rootCauseParty"));
    private SelenideElement selectBoxHRootCauseCategory = $(byId("rootCauseCategory"));


    private SelenideElement buttonAddShipmentOrder = $(byAttribute("id", "stepRequestUpdate-buttonAddShipemntOrder"));

    private SelenideElement buttonSaveAndProceed = $(byId("saveAndProceed"));


/*    @Step("Verify that Send to Involved Party Step")
    public  SelenideElement isRequestUpdateStepLoaded() {
        return  $(stepName);
    }*/

    /*@Step("Verify that preRequest created")
    public SelenideElement isPageLoaded() {
        return $(buttonSaveAndProceed);
    }*/

    @Step("Select Priority {0}")
    public RequestUpdateStep selectPriority(String priority) {
        $(selectPriority).$(withText(priority)).click();
        return page(RequestUpdateStep.class);
    }

    @Step("Select LCC {0}")
    public RequestUpdateStep selectLcc(String lcc) {
        $(selectBoxHandledByLcc).click();
        $(withText(lcc)).click();
        return page(RequestUpdateStep.class);
    }

    @Step("Select Handled By team {0}")
    public RequestUpdateStep selectHandledByTeam(String handledByTeam) {
        $(selectBoxHandledByTeam).click();
        $(withText(handledByTeam)).click();
        return this;
    }

    @Step("Select Handled by user {0}")
    public RequestUpdateStep selectHandledByUser(String handledByUser) {
        $(selectBoxHandledByUser).click();
        $(withText(handledByUser)).click();
        return this;
    }

    @Step("Select Requesting Party {0}")
    public RequestUpdateStep selectRequestingParty(String requestingParty) {
        $(selectBoxRequestingParty).click();
        $(withText(requestingParty)).click();
        return this;
    }

    @Step("Select Involved Parties {0}")
    public RequestUpdateStep selectInvolvedParties(String involvedParties) {
        $(selectBoxInvolvedParties).click();
        $(selectBoxInvolvedParties).$(withText(involvedParties)).click();
        $(byXpath("//ng-select[contains(@class, 'ng-select-opened')]/div/span[2]")).click();
        return this;
    }


    @Step("Slect Reason Code Level  1 {0}")
    public RequestUpdateStep selectReasonCodeLevelOne(String reasonCodeLevelOne){
        $(selectBoxHReasonCodesL1).click();
        $(withText(reasonCodeLevelOne)).click();
        return this;
    }

    @Step("Slect Reason Code Level 2 {0}")
    public RequestUpdateStep selectReasonCodeLevelTwo(String reasonCodeLevelTwo) {
        $(selectBoxHReasonCodesL2).click();
        $(withText(reasonCodeLevelTwo)).click();
        return this;
    }

    @Step("Slect Reason Code Level 2 {0}")
    public RequestUpdateStep selectReasonCodeLevelThree(String reasonCodeLevelThree) {
        $(selectBoxHReasonCodesL2).click();
        $(withText(reasonCodeLevelThree)).click();
        return this;
    }

    @Step("Slect Root Cause Party {0}")
    public RequestUpdateStep selectRootCauseParty(String rootCauseParty){
        $(selectBoxHRootCauseParty).click();
        $(withText(rootCauseParty)).click();
        return this;
    }

    @Step("Slect Root Cause Category {0}")
    public RequestUpdateStep selectRootCauseCategory(String rootCauseCategory){
        $(selectBoxHRootCauseCategory).click();
        $(withText(rootCauseCategory)).click();
        return this;
    }

    @Step("Click on save and Proceed")
    public SendToInvolvedPartyStep clickOneSaveAndProceedButton(){
        $(buttonSaveAndProceed).click();
        return  page(SendToInvolvedPartyStep.class);
    }

    @Step("Get Step Name")
    public String getStepName() {
        return $(stepName).getText();
    }



    public void isButtonSaveAndProceedDisplayed(){
        $(buttonSaveAndProceed).shouldBe(Condition.visible);
    }

}

