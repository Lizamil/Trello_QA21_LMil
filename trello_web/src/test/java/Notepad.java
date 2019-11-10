

public class Notepad {

   /* if(isElementPresent(By.cssSelector("bla-bla-bla"))){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.stalenessOf(
                        driver.findElement(By.cssSelector("bla-bla-bla"))));

  //wait until the element "bla-bla-bla" disappears - ExpectedConditions.stalenessOf
      public boolean isElementPresent(By locator) {return driver.findElements(locator).size()>0;}
__________________________________________________________________________________________________
      WebElement nameElement = driver.findElement(By.cssSelector("bla-bla-bla"));
        System.out.println(nameElement.getCssValue("visibility"));
  // сначала отдельно прописать WebElement. Потом исользовать его название nameElement
 __________________________________________________________________________________________________
      WebElement menu = driver.findElement(By.cssSelector(".board-header-btn.mod-show-menu"));
            if (menu.getCssValue("visibility").equals("visible"))
            { ........}
  // getCssValue("visibility") - обращение к css элемента menu. "visibility" - название параметра, "visible" - значенние
 __________________________________________________________________________________________________



public void close() {
        click(By.xpath("//div[@title='zzzAboutBoardCloseButHas2']"));
        // открыли доску
        WebElement menuButton = driver.findElement(By.cssSelector(".board-header-btn.mod-show-menu"));
        if (menuButton.getCssValue("visibility").equals("visible")) {
            //если ShowMenuButton видна
            click(By.cssSelector(".mod-show-menu"));
            // кликаем на нее
            if (isElementPresent(By.cssSelector(".icon-member.icon-lg.window-module-title-icon"))) {
                // если открылось меню About this board
                click(By.cssSelector(".board-menu-header-back-button"));
                //кликаем на кнопку < и попадаем в Меню
                selectMoreInMenuOnBoardPage();
                //и кликаем на More}
            } else { // а это значит, что открылась форма Меню сразу
                selectMoreInMenuOnBoardPage();
                //то сразу кликаем на More}
            }
        } else { // если ShowMenuButton не видна
            if (isElementPresent(By.cssSelector(".icon-member.icon-lg.window-module-title-icon"))) {
                // если открылось меню About this board
                click(By.cssSelector(".board-menu-header-back-button"));
                //кликаем на кнопку < и попадаем в Меню
                selectMoreInMenuOnBoardPage();
                //и кликаем на More}
            } else { // а это значит, что открылась форма Меню сразу
                selectMoreInMenuOnBoardPage();
                //то сразу кликаем на More}
            }
        }
    }

   <class name="trello_tests.tests.TeamCreationTests"/>
            <class name="trello_tests.tests.TeamModificationTest"/>
            <class name="trello_tests.tests.TeamDeleteTest"/>
            <class name="trello_tests.tests.BoardCreationTests"/>
            <class name="trello_tests.tests.BoardModificationTest"/>
            <class name="trello_tests.tests.BoardDeleteTest"/>


             <class name="trello_tests.tests.TeamCreationTests"/>
            <class name="trello_tests.tests.TeamModificationTest"/>
            <class name="trello_tests.tests.TeamDeleteTest"/>
            <class name="trello_tests.tests.UserModificationTests"/>

  */

}
