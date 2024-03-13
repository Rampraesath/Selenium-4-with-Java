package utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Utils {

    private WebDriver driver;

    public static Object[][] filterDataByCredential(Object[][] data, String criteria) {
        List<Object[]> filteredData = new ArrayList<>();

        for (Object[] rowData : data) {
            String rowCred = (String) rowData[2];
            if (rowCred.equalsIgnoreCase(criteria)) {
                filteredData.add(Arrays.copyOfRange(rowData, 0, rowData.length - 1)); // Exclude the criteria column
            }
        }

        return filteredData.toArray(new Object[0][0]);
    }


    public WebElement retryUntilFound(Supplier<WebElement> elementSupplier, int maxAttempts) {
        int attempts = 0;
        WebElement element = null;

        while (attempts < maxAttempts) {
            try {
                element = elementSupplier.get();
                if (element.isDisplayed()) {
                    return element;
                }
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                driver.navigate().refresh();

            }
            attempts++;
        }

        throw new NoSuchElementException("Element not found after " + maxAttempts + " attempts");
    }
}
