import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;


// Declaring the CheckoutPage class, which extends the BasePage class.
// By extending BasePage, CheckoutPage inherits the WebDriver instance and the PageFactory initialization.
public class LoginPage extends BasePage {

    // Declaring a public WebDriverWait variable named 'wait'.
    // WebDriverWait is used for implementing explicit waits during interactions with web elements.
    public WebDriverWait wait;

    // Constructor for the CheckoutPage class that takes a WebDriver object as an argument.
    // This constructor calls the parent class (BasePage) constructor to initialize the WebDriver instance
    // and sets up the PageFactory to initialize the web elements on this page.
    public LoginPage(WebDriver driver) {
        // Calling the parent class (BasePage) constructor using 'super' to initialize the WebDriver.
        super(driver);

        // Initializing the WebDriverWait object with a 10-second timeout.
        // This will be used to wait for certain conditions or elements during test execution.
        wait = new WebDriverWait(driver, 10);
    }

    // Locating the search bar element using the @FindBy annotation.
    // @FindBy is a Selenium annotation that helps locate elements on the web page.
    // Here, the element is being located by its 'id' attribute with the value "input-search".
    // Declare the WebElement as private to enforce encapsulation
    // This ensures that 'searchBar' cannot be accessed directly from outside this class
    @FindBy(css = ".svg-inline--fa.fa-sign-in-alt.fa-w-16 ")
    private WebElement loginIcon;

    public void clickLoginIcon() {
        loginIcon.click();
    }

    @FindBy(id = "user-name")
    private WebElement username;

    public void setUsername(String user) {
        username.sendKeys(user);
    }

    @FindBy(id = "password")
    private WebElement password;

    public void setPassword(String pass) {
        password.sendKeys(pass);
    }

    @FindBy(css = ".btn.btn-primary")
    private WebElement getLoginButton;

    public void clickLogButton() {
        getLoginButton.click();
    }

    @FindBy(linkText = "dino")
    private WebElement dino;

    public WebElement getDino() {
        return dino;
    }

    @FindBy(css = ".sort-products-select.form-control.form-control-sm")
    private WebElement sortBar;

    public WebElement getSortBar() {
        return sortBar;
    }

    public void selecOption(WebElement element, String option) {
        Select optionSelect = new Select(element);
        optionSelect.selectByVisibleText(option);
    }

    @FindBy(css = ".svg-inline--fa.fa-undo.fa-w-16 ")
    private WebElement resetBtn;

    public void clickResetButton() {
        resetBtn.click();
    }

    public void loginUser() {
        clickLoginIcon();
        setUsername("dino");
        setPassword("choochoo");
        clickLogButton();

    }

    @FindBy(css = ".card-link")
    private List<WebElement> productElements;

    public List<WebElement> getProductElements() {
        return productElements;
    }

    @FindBy(xpath = "//span[@style='font-weight: bold; font-size: 16px;']")
    private List<WebElement> priceElements;

    public List<WebElement> getPriceElements() {
        return priceElements;
    }

    @FindBy(linkText = "Awesome Granite Chips")
    private WebElement awesomeGraniteChips;

    public void clickAwesomeGraniteChips() {
        awesomeGraniteChips.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x ")
    private WebElement cartButton;

    public void clickCartButton() {
        cartButton.click();
    }

    @FindBy(css = ".svg-inline--fa.fa-sign-in-alt.fa-w-16 ")
    private WebElement incorrectUsername;

    public void incorrectUsername() {
        clickLoginIcon();
        setUsername("dinu");
        setPassword("choochoo");
        clickLogButton();

    }

    @FindBy(linkText = "dinu")
    private WebElement dinu;

    public WebElement getDinu() {
        return dinu;
    }

    @FindBy(css = ".svg-inline--fa.fa-sign-in-alt.fa-w-16 ")
    private WebElement incorrectPassword;

    public void incorrectPassword() {
        clickLoginIcon();
        setUsername("dino");
        setPassword("ciuciu");
        clickLogButton();

    }

    @FindBy(linkText = "ciuciu")
    private WebElement ciuciu;

    public WebElement getCiuciu() {
        return ciuciu;
    }

    @FindBy(css = ".mr-auto.form-control.form-control-sm")
    private WebElement searchBar;

    public WebElement getSearchBar() {
        return searchBar;
    }

    public void setSearchBar(String awesome){
        searchBar.sendKeys(awesome);
    }

    @FindBy(css = ".btn.btn-light.btn-sm")
    private WebElement searchButton;

    public void clickSearchButton(){
        searchButton.click();
    }

    @FindBy(css = ".card-link")
    private WebElement miscProduct;

    public WebElement getMiscProduct() {
        return miscProduct;
    }

    @FindBy(css = ".svg-inline--fa.fa-sign-out-alt.fa-w-16 ")
    private WebElement logoutButton;

    public void clickLogoutButton(){
        logoutButton.click();
    }

    @FindBy(css = ".error")
    private WebElement error;

    public WebElement getError(){
        return error;
    }

    @FindBy(xpath = "//span[text()='Hello guest! ']")
    private WebElement helloGuest;

    public WebElement getHelloGuest(){
        return helloGuest;
    }

}