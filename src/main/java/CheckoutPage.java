import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


// Declaring the CheckoutPage class, which extends the BasePage class.
// By extending BasePage, CheckoutPage inherits the WebDriver instance and the PageFactory initialization.
public class CheckoutPage extends BasePage {

    // Declaring a public WebDriverWait variable named 'wait'.
    // WebDriverWait is used for implementing explicit waits during interactions with web elements.
    public WebDriverWait wait;

    public SoftAssert softAssert;

    // Constructor for the CheckoutPage class that takes a WebDriver object as an argument.
    // This constructor calls the parent class (BasePage) constructor to initialize the WebDriver instance
    // and sets up the PageFactory to initialize the web elements on this page.
    public CheckoutPage(WebDriver driver) {
        // Calling the parent class (BasePage) constructor using 'super' to initialize the WebDriver.
        super(driver);

        // Initializing the WebDriverWait object with a 10-second timeout.
        // This will be used to wait for certain conditions or elements during test execution.
        wait = new WebDriverWait(driver, 10);
        softAssert = new SoftAssert();
    }

    // Locating the search bar element using the @FindBy annotation.
    // @FindBy is a Selenium annotation that helps locate elements on the web page.
    // Here, the element is being located by its 'id' attribute with the value "input-search".
    // Declare the WebElement as private to enforce encapsulation
    // This ensures that 'searchBar' cannot be accessed directly from outside this class
    @FindBy(id = "input-search")
    private WebElement searchBar;

    // A public method to set a value in the search bar.
    // This method interacts with the searchBar element and sends the text "mouse" to it.
    // Public method to interact with the private 'searchBar' element
    // Provides controlled access to the encapsulated WebElement
    public void setSearchBar(String awesome) {
        // Typing the word "mouse" into the search bar.
        searchBar.sendKeys(awesome);
    }

    // Locating the search button element using the @FindBy annotation.
    // The element is being located by its CSS selector, which identifies elements based on their classes.
    // Here, the button has the classes "btn", "btn-light", and "btn-sm".
    @FindBy(css = ".btn.btn-light.btn-sm")
    private WebElement searchButton;

    public void clickSearchButton() {
        searchButton.click();
    }

    @FindBy(linkText = "Refined Frozen Mouse")
    private WebElement frozenMouse;

    public WebElement getFrozenMouse() {
        return frozenMouse;
    }

    @FindBy(linkText = "Awesome Granite Chips")
    private WebElement awesomeChipsProduct;

    public void clickAwesomeChipsLink() {
        awesomeChipsProduct.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x ")
    private WebElement cartIcon;

    public void clickCartIcon() {
        cartIcon.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18 ")
    private WebElement shoppingCartIcon;

    public void clickShoppingCartIcon() {
        shoppingCartIcon.click();
    }

    @FindBy(css = ".btn.btn-success")
    private WebElement CheckoutButton;

    public void clickCheckoutButton() {
        CheckoutButton.click();
    }

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    public void setFirstNameField() {
        firstNameField.sendKeys("Marian");
    }

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    public void setLastNameField() {
        lastNameField.sendKeys("Harastasan");
    }

    @FindBy(id = "address")
    private WebElement addressField;

    public void setAddressField() {
        addressField.sendKeys("Iulius Mall");
    }

    @FindBy(css = ".btn.btn-success")
    private WebElement continueCheckoutButton;

    public void clickContinueCheckoutButton() {
        continueCheckoutButton.click();
    }

    @FindBy(css = ".btn.btn-success")
    private WebElement completeYourOrderButton;

    public void clickCompleteYourOrderButton() {
        completeYourOrderButton.click();
    }

    @FindBy(css = ".text-muted")
    private WebElement successMessage;

    public WebElement getSuccessMessage() {
        return successMessage;
    }

//    Login Test

    @FindBy(css = ".btn.btn-link")
    private WebElement loginIcon;

    public void clickLoginIcon() {
        loginIcon.click();
    }

    @FindBy(id = "user-name")
    private WebElement usernameField;

    public void setUsernameField() {
        usernameField.sendKeys("dino");
    }

    @FindBy(id = "password")
    private WebElement passwordField;

    public void setPasswordField() {
        passwordField.sendKeys("choochoo");
    }

    @FindBy(css = ".btn.btn-primary")
    private WebElement loginButton;

    public void clickLoginButton() {
        loginButton.click();
    }

//    Add and remove producs from cart

    @FindBy(linkText = "Gorgeous Soft Pizza")
    private WebElement gorgeousSoftPizza;

    public void clickGorgeousSoftPizza() {
        gorgeousSoftPizza.click();
    }

    @FindBy(css = ".btn.btn-link")
    private WebElement addProductCartIcon;

    public void clickAddProductCartIcon() {
        addProductCartIcon.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-shopping-bag.fa-w-14.fa-3x.brand-logo")
    private WebElement bagIcon;

    public void clickBagIcon() {
        bagIcon.click();
    }

    @FindBy(linkText = "Incredible Concrete Hat")
    private WebElement incredibleConcreteHat;

    public void clickIncredibleConcreteHat() {
        incredibleConcreteHat.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x ")
    private WebElement addProduct2;

    public void clickAddProduct2() {
        addProduct2.click();
    }


    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18 ")
    private WebElement shoppingCartPicture;

    public void clickShoppingCartPicture() {
        shoppingCartPicture.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-trash.fa-w-14 ")
    private WebElement deleteProduct2Icon;

    public void clickDeleteProduct2Icon() {
        deleteProduct2Icon.click();
    }

    //    Add favorite product
//
    @FindBy(linkText = "Licensed Steel Gloves")
    private WebElement licensedSteelGloves;

    public void clickLicensedSteelGloves() {
        licensedSteelGloves.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-heart.fa-w-16.fa-3x ")
    private WebElement heartButton;

    public void clickHeartButton() {
        heartButton.click();
    }

//    @FindBy(css = ".svg-inline--fa.fa-heart.fa-w-16 ")
//    private WebElement heartIcon;
//
//    public void clickHeartIcon(){heartIcon.click();}

    @FindBy(css = ".svg-inline--fa.fa-heart-broken.fa-w-16.fa-2x ")
    private WebElement heartBroken;

    public void clickHeartBroken() {
        heartBroken.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-heart.fa-w-16.fa-3x ")
    private WebElement heartIcon;

    public void clickHeartIcon() {
        heartIcon.click();
    }

    @FindBy(css = ".fa-layers-counter.shopping_cart_badge")
    private WebElement shoppingCartBadge;

    public WebElement getShoppingCartBadge() {
        return shoppingCartBadge;
    }

    public void clickShoppingCartBadge() {
        shoppingCartBadge.click();
    }

    public WebElement getAwesomeChipsProduct() {
        return awesomeChipsProduct;
    }

    @FindBy(css = ".svg-inline--fa.fa-heart-broken.fa-w-16.fa-2x ")
    private WebElement brokenHeartIcon;

    public void clickBrokenHeartIcon() {
        brokenHeartIcon.click();
    }

    //    Exercitiu Geta
    @FindBy(linkText = "Awesome Soft Shirt")
    private WebElement awesomeShirt;

    public void clickAwesomeShirt() {
        awesomeShirt.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x ")
    private WebElement add2Cart;

    public void clickAdd2Cart() {
        add2Cart.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18 ")
    private WebElement cartBtn;

    public void clickCartBtn() {
        cartBtn.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-plus-circle.fa-w-16 ")
    private WebElement plusOne;

    public void clickPlusOne() {
        plusOne.click();
    }

    @FindBy(css = ".amount-total")
    private WebElement validationTotal;

    public WebElement getValidationTotal() {
        return validationTotal;
    }

    @FindBy(xpath = "(//td[@class='amount'])[1]")
    private WebElement itemPrice;

    @FindBy(xpath = "(//td[@class='amount'])[2]")
    private WebElement taxPrice;

    @FindBy(xpath = "(//td[@class='amount'])[3]")
    private WebElement totalPrice;

    public double productPrice() {
        String amountValue = itemPrice.getText();
        String cleanAmountValue = amountValue.replace("$", "");
        return Double.parseDouble(cleanAmountValue);
    }

    public double taxPrice(){
        String taxValue = taxPrice.getText();
        String cleanTaxValue = taxValue.replace("$", "");
        return Double.parseDouble(cleanTaxValue);
    }

    public double totalPrice(){
        String totalValue = totalPrice.getText();
        String cleanTotalValue = totalValue.replace("$", "");
        return  Double.parseDouble(cleanTotalValue);
    }

//    Add product and continue shopping

    @FindBy(linkText = "Practical Wooden Bacon")
    private WebElement practicalWoodenBacon;

    public void clickPracticalWoodenBacon() {
        practicalWoodenBacon.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x ")
    private WebElement cartIcn;

    public void clickCartIcn() {
        cartIcn.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18 ")
    private WebElement shoppingCartIcn;

    public void clickShoppingCartIcn() {
        shoppingCartIcn.click();
    }

    @FindBy(css = ".btn.btn-danger")
    private WebElement continueShopping;

    public void clickContinueShopping() {
        continueShopping.click();
    }

    @FindBy(css = ".text-muted")
    private WebElement products;

    public WebElement getProducts() {
        return products;
    }

    //    Reset Button
    @FindBy(css = ".svg-inline--fa.fa-undo.fa-w-16 ")
    private WebElement resetButton;

    public void clickResetButton() {
        resetButton.click();
    }

    //    Help button
    @FindBy(css = ".svg-inline--fa.fa-question.fa-w-12 ")
    private WebElement helpButton;

    public void clickHelpButton() {
        helpButton.click();
    }

    @FindBy(css = ".modal-title ")
    private WebElement help;

    public WebElement getHelp() {
        return help;
    }

    public void addProductToCart(){
       clickAwesomeShirt();
       clickAdd2Cart();
       clickCartBtn();
}

public void addProductToWishlist (){
    clickAwesomeChipsLink();
    clickHeartIcon();
}

@FindBy(css = ".sort-products-select.form-control.form-control-sm")
    private WebElement sortButton;

    public void clickSortButton(){
        sortButton.click();
    }
    @FindBy(xpath = "//option [@value='hilo']")
    private WebElement sort1;

    public void clickSort1(){
        sort1.click();
    }
    }