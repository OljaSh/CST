package conf;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:application.properties"})
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

}
