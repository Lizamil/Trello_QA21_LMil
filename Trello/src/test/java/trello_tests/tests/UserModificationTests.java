package trello_tests.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class UserModificationTests extends TestBase {
    @Test
    public void addAvatarTest() {
        app.getUserHelper().clickOnAvatar();
        app.getUserHelper().clickOnProfile();
        app.getBoardHelper().focusOn(By.cssSelector(".rsiNque2CCqtPE"));
        app.getUserHelper().addPicture("C:\\Tools\\icon2.jpg");
        app.getUserHelper().returnToHomePage();
       // Thread.sleep(5000);
    }

    @Test
    public void changeAvatarTest() {
        app.getUserHelper().clickOnAvatar();
        app.getUserHelper().clickOnProfile();
        app.getBoardHelper().focusOn(By.cssSelector(".rsiNque2CCqtPE"));
        app.getUserHelper().addPicture("C:\\Tools\\icon1.jpg");
        app.getUserHelper().returnToHomePage();
       // Thread.sleep(7000);
    }

    @Test
    public void changeLanguageTest() throws InterruptedException {
        app.getUserHelper().clickOnAvatar();
        app.getUserHelper().clickOnChangeLanguage();
        String toLang = "Nederlands"; //Deutsch  English (UK) Nederlands Svenska
        app.getUserHelper().changeLangageTo(toLang);
        app.getUserHelper().clickOnAvatar();
        app.getUserHelper().clickOnChangeLanguage();
        Assert.assertEquals(app.getUserHelper().currentLang(), toLang);
        app.getUserHelper().closeMenuProfile();
        Thread.sleep(1000);

    }
@AfterClass
    public void changeLangToEng(){
    app.getUserHelper().clickOnAvatar();
    app.getUserHelper().clickOnChangeLanguage();
    if (app.getUserHelper().currentLang().equals("English (UK)")==false)
    {
        app.getUserHelper().changeLangageTo("English (UK)");
    }

}

}
