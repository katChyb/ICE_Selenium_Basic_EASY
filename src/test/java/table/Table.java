package table;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import setup.TestBase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class Table extends TestBase {

    @Test
    public void printMountainsInSwitzerlandHigherThan4000() {

        //Print out 'Rank', 'Peak' and 'Mountain range' of mountains that are in "Switzerland" and are higher than 4000 m

        driver.get("http://51.75.61.161:9102/table.php");

        List<WebElement> allRows = driver.findElements(By.cssSelector("tbody tr"));
        assertThat((allRows.size()) > 0);


        for (WebElement row : allRows) {
            String name = row.findElements(By.cssSelector("td")).get(0).getText();
            String height = row.findElements(By.cssSelector("td")).get(3).getText();
            String state = row.findElements(By.cssSelector("td")).get(2).getText();
            String mountainRange = row.findElements(By.cssSelector("td")).get(1).getText();
            String rank = row.findElements(By.cssSelector("th")).get(0).getText();

            if ((Integer.parseInt(height) > 4000) && state.contains("Switzerland")) {
                System.out.println("Rank: " + rank + " Peak: " + name + ", Mountain range: " + mountainRange);
            }

        }

    }
}
