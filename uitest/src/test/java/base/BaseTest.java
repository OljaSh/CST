package base;

import com.codeborne.selenide.Selenide;
import helpers.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.logevents.SelenideLogger.removeAllListeners;

public class BaseTest {

    @BeforeAll()
    static void beforeAll() throws Exception {
        CommonSetup.setUp();
    }

  @AfterAll
    static void tearDown() {
        removeAllListeners();
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.close();
    }

/*    protected <T> T at(Class<T> pageClass) {
        return Selenide.page(pageClass);
    }*/

}
