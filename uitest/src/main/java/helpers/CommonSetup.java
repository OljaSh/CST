package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import conf.ProjectConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;


public final class CommonSetup {

    public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public static void setUp() {

        Configuration.timeout = config.timeout();
        Configuration.screenshots = config.screenshots();
        Configuration.browser = config.browser();
        Configuration.headless = config.browserMode();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true)
                .savePageSource(false));
        IntApiHelper.init(config.apiUrl(), config.apiUser(), config.apiPass());
    }
}


