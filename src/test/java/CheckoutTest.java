import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.IExpectedExceptionsHolder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

// This annotation is used to specify that the ExtentTestNGITestListener class should be used to listen to the test events.
// The listener will generate reports based on the test results using the ExtentReports library.
@Listeners(ExtentTestNGITestListener.class)

// Declaring the CheckoutTest class, which extends the Hooks class.
// By extending Hooks, CheckoutTest inherits the setup and teardown methods for WebDriver.
public class CheckoutTest extends Hooks {

    // Declaring a public variable of type CheckoutPage named 'checkoutPage'.
    // This will be used to interact with the CheckoutPage object during the tests.
    public CheckoutPage checkoutPage;
    public LoginPage loginPage;

    // Declaring a public variable of type WebDriverWait named 'wait'.
    // WebDriverWait is used to explicitly wait for certain conditions or elements during test execution.
    public WebDriverWait wait;

    public SoftAssert softAssert;

    // Method annotated with @BeforeMethod, indicating that it will run before each test method.
    // This method is used to set up the page objects and other necessary components before each test.
    @BeforeMethod
    public void SetupPageObject() {

        // Initializing the checkoutPage object with the current WebDriver instance.
        // This allows the test methods to interact with elements on the checkout page.
        checkoutPage = new CheckoutPage(driver);
        loginPage = new LoginPage(driver);

        // Initializing the WebDriverWait object with the current WebDriver instance and a timeout of 30 seconds.
        // This wait will be used to pause the execution until certain conditions are met or elements are found.
        wait = new WebDriverWait(driver, 30);
        softAssert = new SoftAssert();

    }


    @Test(description = "Tests the search functionality by searching for the keyword 'Awesome'")
    public void searchTest() {
        checkoutPage.setSearchBar("Awesome");
        checkoutPage.clickSearchButton();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The search engine is looking up for the keyword 'Awesome'");

        List<String> expectedProducts = new ArrayList<>();
        expectedProducts.add("Awesome Granite Chips");
        expectedProducts.add("Awesome Metal Chair");
        expectedProducts.add("Awesome Soft Shirt");

        List<WebElement> productElements = loginPage.getProductElements();

        List<String> actualProducts = new ArrayList<>();
        for (WebElement productElement : productElements) {
            actualProducts.add(productElement.getText());
        }

        for (String expectedProduct : expectedProducts) {
            softAssert.assertTrue(actualProducts.contains(expectedProduct), "Expected product " + expectedProduct + " not found in the shearch results");

            for (String actualProduct : actualProducts) {
                if (!actualProduct.contains("Awesome")) {
                    softAssert.fail("Unexpected product found: " + actualProduct);
                }
            }

            softAssert.assertAll();
        }

    }

    @Test(description = "Purchasing a simple product from a guest user")
    public void checkoutTest(){
        checkoutPage.clickAwesomeChipsLink();
        checkoutPage.clickCartIcon();
        checkoutPage.clickShoppingCartIcon();
        checkoutPage.clickCheckoutButton();
        checkoutPage.setFirstNameField();
        checkoutPage.setLastNameField();
        checkoutPage.setAddressField();
        checkoutPage.clickContinueCheckoutButton();
        checkoutPage.clickCompleteYourOrderButton();
        assertEquals(checkoutPage.getSuccessMessage().getText(), "Order complete");
    }

    @Test(description = "loginTest")
    public void loginTest() {
        checkoutPage.clickLoginIcon();
        checkoutPage.setUsernameField();
        checkoutPage.setPasswordField();
        checkoutPage.clickLoginButton();
//        Add and remove products from cart
        checkoutPage.clickGorgeousSoftPizza();
        checkoutPage.clickAddProductCartIcon();
        checkoutPage.clickBagIcon();
        checkoutPage.clickIncredibleConcreteHat();
        checkoutPage.clickAddProduct2();
        checkoutPage.clickShoppingCartPicture();
        checkoutPage.clickDeleteProduct2Icon();
//        Add favorite product
//        checkoutPage.clickBagIcon();
//        checkoutPage.clickLicensedSteelGloves();
//        checkoutPage.clickHeartButton();
//        checkoutPage.clickHeartIcon();
//        checkoutPage.clickHeartBroken();
    }

    @Test(description = "Add and remove products from cart")
    public void cartTest() {
        checkoutPage.clickGorgeousSoftPizza();
        checkoutPage.clickAddProductCartIcon();
        checkoutPage.clickBagIcon();
        checkoutPage.clickIncredibleConcreteHat();
        checkoutPage.clickAddProduct2();
        checkoutPage.clickShoppingCartPicture();
        checkoutPage.clickDeleteProduct2Icon();
    }

    @Test(description = "Add favorite product")
    public void favoriteProductTest() throws InterruptedException {
        checkoutPage.clickLoginIcon();
        checkoutPage.setUsernameField();
        checkoutPage.setPasswordField();
        checkoutPage.clickLoginButton();
        Thread.sleep(5000);
        checkoutPage.clickLicensedSteelGloves();
        checkoutPage.clickHeartButton();
        checkoutPage.clickHeartIcon();
        checkoutPage.clickHeartBroken();
    }

    @Test(description = "Adding a product to whishlist")
    public void wishlistTest(){
        checkoutPage.addProductToWishlist();
        if (checkoutPage.getShoppingCartBadge().getText().equals("1")) {
            ExtentTestNGITestListener.getTest().log(Status.PASS, "Shopping Cart Badge was updated with success. ");
        } else {
            softAssert.fail("Shopping Cart was not updated correctly");
        }
        checkoutPage.clickShoppingCartBadge();
        assertEquals(checkoutPage.getAwesomeChipsProduct().getText(),"Awesome Granite Chips");
        ExtentTestNGITestListener.getTest().log(Status.PASS, "Awesome Granite Chips Product was found in the Wishlist");
        softAssert.assertAll();
    }

    @Test(description = "Removing a product from wishlist")
    public void removeItemFromWishlist(){
        checkoutPage.addProductToWishlist();
        checkoutPage.clickShoppingCartBadge();
        checkoutPage.clickBrokenHeartIcon();
        try {
            if(checkoutPage.getAwesomeChipsProduct().isDisplayed()) {
                ExtentTestNGITestListener.getTest().log(Status.PASS, "Awesome Granite Chips Product was remove from the Wishlist");

                Assert.fail("Element is still present");
            }
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true, "Element is not present as expected");
        }
    }

    @Test(description = "Increase the amount of a product")
    public void increasedAmountTest() {

        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product is: +" + checkoutPage.productPrice());
        double expectedTotal = checkoutPage.productPrice() * 2;
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product after quantity increase should be: +" + expectedTotal);
        checkoutPage.clickPlusOne();
        assertEquals(checkoutPage.productPrice(), expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.PASS, "The price of the product matches the expected total" + checkoutPage.productPrice() + "= " + expectedTotal);
    }

    @Test(description = "Calculate the Total price for a product")
    public void totalPriceForAProduct(){
        checkoutPage.addProductToCart();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The price of the product is: " + checkoutPage.productPrice());
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The tax price of the product is: " + checkoutPage.taxPrice());
        System.out.println(checkoutPage.totalPrice());
        double expectedTotal = checkoutPage.productPrice() + checkoutPage.taxPrice();
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The actual total price of the product is: " + checkoutPage.totalPrice());
        ExtentTestNGITestListener.getTest().log(Status.INFO,"The expected total price of the product is: " + expectedTotal);
        assertEquals(checkoutPage.totalPrice(), expectedTotal);
    }


    @Test(description = "Add product and continue shopping")
    public void addProductAndContinueShopping(){
        checkoutPage.clickPracticalWoodenBacon();
        checkoutPage.clickCartIcn();
        checkoutPage.clickShoppingCartIcn();
        checkoutPage.clickContinueShopping();
        assertEquals(checkoutPage.getProducts().getText(), "Products");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Products was found in the homepage");
    }
    @Test(description = "Reset button")
    public void resetTheApplicationState(){
        checkoutPage.clickPracticalWoodenBacon();
        checkoutPage.clickCartIcn();
        checkoutPage.clickShoppingCartIcn();
        checkoutPage.clickContinueShopping();
        assertEquals(checkoutPage.getProducts().getText(), "Products");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Products was found in the homepage");
        checkoutPage.clickResetButton();
    }

    @Test(description = "Help button")
    public void helpButton() throws InterruptedException {
        checkoutPage.clickHelpButton();
        assertEquals(checkoutPage.getHelp().getText(),"Help");
        ExtentTestNGITestListener.getTest().log(Status.INFO,"Help was found in the help field");
    }

    @Test(description = "Sort button")
    public void sortButton() throws InterruptedException {
        checkoutPage.clickSortButton();
        Thread.sleep(5000);
        checkoutPage.clickSort1();
        Thread.sleep(5000);
    }

}




