import com.aventstack.extentreports.Status;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;

// This annotation is used to specify that the ExtentTestNGITestListener class should be used to listen to the test events.
// The listener will generate reports based on the test results using the ExtentReports library.
@Listeners(ExtentTestNGITestListener.class)

// Declaring the CheckoutTest class, which extends the Hooks class.
// By extending Hooks, CheckoutTest inherits the setup and teardown methods for WebDriver.
public class LoginTest extends Hooks {

    // Declaring a public variable of type CheckoutPage named 'checkoutPage'.
    // This will be used to interact with the CheckoutPage object during the tests.
    public LoginPage loginPage;

    public SoftAssert softAssert;
    // Declaring a public variable of type WebDriverWait named 'wait'.
    // WebDriverWait is used to explicitly wait for certain conditions or elements during test execution.
    public WebDriverWait wait;

    // Method annotated with @BeforeMethod, indicating that it will run before each test method.
    // This method is used to set up the page objects and other necessary components before each test.
    @BeforeMethod
    public void SetupPageObject() {

        // Initializing the checkoutPage object with the current WebDriver instance.
        // This allows the test methods to interact with elements on the checkout page.
        loginPage = new LoginPage(driver);

        // Initializing the WebDriverWait object with the current WebDriver instance and a timeout of 30 seconds.
        // This wait will be used to pause the execution until certain conditions are met or elements are found.
        wait = new WebDriverWait(driver, 30);
        softAssert = new SoftAssert();
    }



    @Test(description = "Sorting Test")
    public void sortTest1() throws InterruptedException {
        List<WebElement> productElements = loginPage.getProductElements();
        List<String> actualProductNames = new ArrayList<>();
        loginPage.selecOption(loginPage.getSortBar(), "Sort by name (Z to A)");

        for (WebElement productElement : productElements) {
            actualProductNames.add(productElement.getText());
        }

        List<String> expectedProductNames = new ArrayList<>(actualProductNames);
        expectedProductNames.sort(Comparator.reverseOrder());

        Assert.assertEquals(actualProductNames, expectedProductNames, "The products are not sorted in reverse alphabetical order");
    }

    @Test(description = "Sorting Test 2")
    public void sortTest2() throws InterruptedException {
        List<WebElement> priceElements = loginPage.getPriceElements();
        List<Double> actualProductPrices = new ArrayList<>();
        loginPage.selecOption(loginPage.getSortBar(), "Sort by price (low to high)");

        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "");
            actualProductPrices.add(Double.parseDouble(priceText));
        }

        List<Double> expectedProductPrices = new ArrayList<>(actualProductPrices);
        expectedProductPrices.sort(Comparator.naturalOrder());
        System.out.println(actualProductPrices);
        System.out.println(expectedProductPrices);
        Assert.assertEquals(actualProductPrices, expectedProductPrices, "The products are not sorted by price (low to high)");
        Thread.sleep(5000);
//    Trebuia sa imi apara suma actuala si expected?
//
    }

    @Test(description = "Sorting Test")
    public void sortTest4() throws InterruptedException {
        List<WebElement> priceElements = loginPage.getPriceElements();
        List<String> actualProductPrices = new ArrayList<>();
        loginPage.selecOption(loginPage.getSortBar(), "Sort by price (high to low)");

        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "").trim();
            actualProductPrices.add(priceElement.getText());
        }

        List<String> expectedProductPrices = new ArrayList<>(actualProductPrices);
        expectedProductPrices.sort(Comparator.naturalOrder());

        Assert.assertEquals(actualProductPrices, expectedProductPrices, "The products are not sorted by price (high to low)");
        Thread.sleep(5000);
    }


    @Test(description = "Sorting Test 5")
    public void sortTest5() throws InterruptedException {
        // Get the list of price elements from the page
        List<WebElement> priceElements = loginPage.getPriceElements();

        // List to hold actual product prices as String
        List<String> actualProductPrices = new ArrayList<>();

        // Select sorting option (low to high)
        loginPage.selecOption(loginPage.getSortBar(), "Sort by price (low to high)");

        // Iterate through price elements and extract valid price values
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().trim();  // Get the text and trim spaces

            // Check if the price is valid (i.e., contains a "$" and is numeric after removing the "$")
            if (priceText.startsWith("$")) {
                String numericPriceText = priceText.replace("$", "").trim();  // Remove the $ symbol
                // Check if the numeric part is valid and can be parsed
                if (isNumeric(numericPriceText)) {
                    actualProductPrices.add(priceText);  // Add the valid price with the $ symbol
                } else {
                    System.out.println("Skipping invalid price: " + priceText);
                }
            } else {
                System.out.println("Skipping non-price element: " + priceText);
            }
        }

        // Create a new list for expected sorted prices (as String)
        List<String> expectedProductPrices = new ArrayList<>(actualProductPrices);

        // Sort the expected prices in ascending order based on numeric values
        expectedProductPrices.sort((p1, p2) -> {
            Double price1 = Double.parseDouble(p1.replace("$", ""));
            Double price2 = Double.parseDouble(p2.replace("$", ""));
            return price1.compareTo(price2);
        });

        // Assert that the actual list matches the expected sorted list
        Assert.assertEquals(actualProductPrices, expectedProductPrices, "The products are not sorted by price (low to high)");
    }

    // Utility method to check if a string is numeric
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Test(description = "Sorting Test 3")
    public void sortTest3() throws InterruptedException {
        List<WebElement> productElements = loginPage.getProductElements();
        List<String> actualProductNames = new ArrayList<>();
        loginPage.selecOption(loginPage.getSortBar(), "Sort by name (A to Z)");

        for (WebElement productElement : productElements) {
            actualProductNames.add(productElement.getText());
        }

        List<String> expectedProductNames = new ArrayList<>(actualProductNames);
        expectedProductNames.sort(Comparator.naturalOrder());

        Assert.assertEquals(actualProductNames, expectedProductNames, "The products are not sorted in alphabetical order");
    }


    @Test(description = "Reset login test")
    public void loginTest() throws InterruptedException {
        loginPage.loginUser();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getDino()));
        loginPage.clickResetButton();
        Thread.sleep(5000);
        assertEquals(loginPage.getHelloGuest().getText(), "Hello guest!", "User was not logged out");
        
    }

    @Test(description = "Reset cart")
    public void ResetCart() throws InterruptedException {
        loginPage.loginUser();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getDino()));
        loginPage.clickAwesomeGraniteChips();
        Thread.sleep(5000);
        loginPage.clickCartButton();
        Thread.sleep(5000);
        loginPage.clickResetButton();
        Thread.sleep(5000);
    }

    @Test(description = "Incorrect username test")
    public void incorrectUsername(){
        loginPage.incorrectUsername();
        assertEquals(loginPage.getError().getText(), "Incorrect username or password!", "Message error was not displayed correct");
    }

    @Test(description = "Incorrect password test")
    public void incorrectPassword(){
        loginPage.incorrectPassword();
        assertEquals(loginPage.getError().getText(), "Incorrect username or password!", "Message error was not displayed correct");
    }

    @Test(description = "Negative test for search")
    public void negativeTestForSearch() throws InterruptedException {
        loginPage.setSearchBar("Marian");
        wait.until(ExpectedConditions.visibilityOf(loginPage.getSearchBar()));
        loginPage.clickSearchButton();
        Thread.sleep(5000);

        try {
            if(loginPage.getMiscProduct().isDisplayed()) {
                Assert.fail("Element is still present");
            }
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true, "Element 'Marian' is not found");
        }
    }

    @Test(description = "Logout test")
    public void logoutTest() throws InterruptedException {
        loginPage.loginUser();
        loginPage.clickLogoutButton();
        assertEquals(loginPage.getHelloGuest().getText(), "Hello guest!", "User was not logged out");
    }


}
