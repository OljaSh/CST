package helpers;

import com.codeborne.selenide.Selenide;

public class PageFactory {

   private PageFactory(){
        throw  new  IllegalStateException("Utility class");
    }

    public static <T> T at(Class<T> pageClass){
        return Selenide.page(pageClass);
    }

}
