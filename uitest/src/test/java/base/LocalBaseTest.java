package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.kn.il.cst.config.TestConfig;
import com.kn.il.cst.dev.CstLocalApplication;
import com.kn.il.cst.helpers.CommonSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.codeborne.selenide.logevents.SelenideLogger.removeAllListeners;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {CstLocalApplication.class})
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles({"testing"})
public class LocalBaseTest {

    //  @Rule
    //  public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

    @LocalServerPort
    private int port;

    @BeforeEach
    public void  setup() {
        CommonSetup.setUp();
        Configuration.baseUrl = CommonSetup.config.baseUrl() + ":" + port;
    }

    @AfterEach
    public void tearDown() {
        removeAllListeners();
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.close();
    }

}