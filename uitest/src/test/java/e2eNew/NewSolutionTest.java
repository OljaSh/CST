package e2eNew;

import base.BaseTest;
import helpers.Constants;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import objects.CreatePreRequestPage;
import objects.LoginPage;
import objects.MainPage;
import objects.RequestUpdateStep;
import org.junit.jupiter.api.Test;

import static helpers.PageFactory.at;
import static org.assertj.core.api.Assertions.assertThat;


public class NewSolutionTest extends BaseTest {

    @Test
    @Description("New Solution Test")
    @Issue("CSTNEXT-250")
    public void createPreRequestTest() {
        at(LoginPage.class).loginWith(Constants.AUTOTEST2, Constants.AUTOTEST_PASSWORD);
        at(MainPage.class).switchCustomer(Constants.CUSTOMER_CHZRH99).clickOnCreateRequest();
        at(CreatePreRequestPage.class).fillAllMandatoryFieldsForPreRequestAndClickOnCreate(Constants.QNCR_REQUEST_TYPE, "Some Text Value here");
        //check with assertion
        assertThat(at(RequestUpdateStep.class).getStepName().contains("UPDATE REQUEST"));
        //check as Step
        at(RequestUpdateStep.class).checkThatStepNameIs("UPDATE REQUEST");
    }
}
