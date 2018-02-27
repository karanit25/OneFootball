package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
    By searchBox = By.id("action_search");
    By searchText = By.id("search_src_text");
    By searchBar = By.id("toolbar_title");
    By competition = By.xpath("//*[@class='android.widget.TextView' and @index='0']");


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage searchFunction() {

        waitForVisibilityOf(searchBox);
        driver.findElement(searchBox).click();
        waitForVisibilityOf(searchText);
        driver.findElement(searchText).clear();
        driver.findElement(searchText).sendKeys("Germ");
        waitForVisibilityOf(competition);
        driver.findElement(competition).click();
        String text = driver.findElement(searchBar).getText();
        System.out.println(text);
        //Since tapping to any Competition is always navigating to "Bundeslinga" so during assertion we are veryfying same.
        Assert.assertTrue(driver.findElement(searchBar).getText().equalsIgnoreCase("Bundesliga"));
        return new SearchPage(driver);
    }
}
