import lib.ui.Main;
import lib.ui.Saerch;
import org.junit.Test;


import lib.ui.CoreTestCase;
import lib.ui.Saerch;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TestS extends CoreTestCase {

    private Main Main;

    protected void setUp() throws Exception{
        super.setUp();
        Main = new Main(driver);
    }

    protected void tearDown(){
        driver.quit();
        super.tearDown();
    }


    @Test
    public void testSearch(){
        Saerch SearchPageObject = new Saerch(driver);
        SearchPageObject.click("text", "Пропустить");
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Хоббит, или Туда и обратно");
        SearchPageObject.clickAndHold("text",   "повесть английского писателя Джона Р. Р. Толкина");
        SearchPageObject.click("text", "Сохранить");
        SearchPageObject.click("text", "Добавить в список");

        SearchPageObject.clearText("org.wikipedia:id/text_input");
        SearchPageObject.sendKeys("org.wikipedia:id/text_input", "Хоббит");
        SearchPageObject.click("resource-id", "android:id/button1");
        SearchPageObject.click("text", "Посмотреть список");

        SearchPageObject.click("resource-id", "org.wikipedia:id/item_overflow_menu");
        SearchPageObject.click("text", "Удалить список");
        SearchPageObject.click("resource-id", "android:id/button1");
    }


}
