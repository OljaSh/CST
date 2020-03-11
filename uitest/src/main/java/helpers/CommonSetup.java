package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import conf.ProjectConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;


public final class CommonSetup {


    public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public static void setUp() {
      //  if (System.getProperty("wdm.proxy") == null) {
      //      System.setProperty("wdm.proxy", "http://webproxy-emea.int.kn:8080");
     //   }
        Configuration.baseUrl = config.baseUrl();
      //  Configuration.browser = "chrome";
        Configuration.timeout = 150000;
        Configuration.screenshots = true;
       // Configuration.reportsFolder = System.getProperty("selenide.reportsFolder", "../target/selenide-reports");
        Configuration.browser ="firefox";
        Configuration.headless = false;
        Configuration.holdBrowserOpen = true;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        IntApiHelper.init(config.apiUrl(), config.apiUser(), config.apiPass());
    }
}


