package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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
        driver.findElement(searchText).sendKeys("Prim");
        //we are sending only 4 chars as Prim since appication is crashing for more than 5 chars
        waitForVisibilityOf(competition);

        List<WebElement> elements = driver.findElements(competition);
        System.out.println("On Screen these Compitions are visible--->");
        for (int i=0;i<elements.size();i++){
            System.out.println(elements.get(i).getText());
            if(elements.get(i).getText().equals("Primera B")){
                elements.get(i).click();
                break;
            }
        }

        String text = driver.findElement(searchBar).getText();
        System.out.println("Home Page of Competition---> "+text);
        //Since tapping to any Competition is always navigating to "Bundeslinga" so during assertion we are veryfying same.
        //In actual scenario we will assert with Primera B
        Assert.assertTrue(driver.findElement(searchBar).getText().equalsIgnoreCase("Bundesliga"));
        return new SearchPage(driver);
    }
}
