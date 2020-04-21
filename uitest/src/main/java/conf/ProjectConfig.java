package conf;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:application.properties",
        "classpath:selenide.properties"})

public interface ProjectConfig extends Config {

   @DefaultValue("local")
    String env();

   @Key("${env}.baseUrl")
    String baseUrl();

   @Key("server.http.port")
   @DefaultValue("8087")
   int httpPort();

    @Key("${env}.apiUrl")
    String apiUrl();

    @Key("${env}.apiUser")
    String apiUser();

    @Key("${env}.apiPass")
    String apiPass();

    @Key("browser")
    @DefaultValue("firefox")
    String browser();

    @Key("timeout")
    @DefaultValue("150000")
    int timeout();

    @Key("headless")
    @DefaultValue("true")
    Boolean browserMode();

    @Key("screenshots")
    @DefaultValue("true")
    Boolean screenshots();

}
