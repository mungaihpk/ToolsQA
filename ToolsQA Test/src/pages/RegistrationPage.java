package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

/*
 * Registration page class. This class will hold all the objects of the registration web page
 * and their associated methods e.g. setText, getText, et.c.
 */
public class RegistrationPage {
    WebDriver driver;

    @FindBy(id="firstName")
    WebElement textbox_firstname;

    @FindBy(id="lastName")
    WebElement textbox_lastname;

    @FindBy(id="userEmail")
    WebElement textbox_email;

    //Using div selector for accurate click on radio buttons.
    @FindBy(xpath="//div[@id='genterWrapper']/div[2]/div[1]")
    WebElement radio_option_male;

    @FindBy(xpath="//div[@id='genterWrapper']/div[2]/div[2]")
    WebElement radio_option_female;

    @FindBy(xpath="//div[@id='genterWrapper']/div[2]/div[3]")
    WebElement radio_option_other;

    @FindBy(id="gender-radio-1")
    WebElement radio_gender_male;

    //@FindBy(id="gender-radio-2")
    @FindBy(id="gender-radio-2")
    WebElement radio_gender_female;

    //@FindBy(id="gender-radio-3")
    @FindBy(id="gender-radio-3")
    WebElement radio_gender_other;

    @FindBy(id="userNumber")
    WebElement textbox_mobile;

    @FindBy(id="dateOfBirthInput")
    WebElement textbox_date_of_birth;

    @FindBy(id="submit")
    WebElement button_submit;

    // Constractor
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Set first name to first name textbox
    public void setFirstName(String firstname){
        textbox_firstname.sendKeys(firstname);
    }

    // Set last name to last name textbox
    public void setLastName(String lastname){
        textbox_lastname.sendKeys(lastname);
    }

    // Set email to email textbox
    public void setEmail(String email){
        textbox_email.sendKeys(email);
    }

    // Select male gender
    public void setGenderMale(){
        radio_option_male.click();
    }

    // Select female gender
    public void setGenderFemale(){
        radio_option_female.click();
    }

    // Select other gender
    public void setGenderOther(){
        radio_option_other.click();
    }

    // Set mobile number to mobile textbox
    public void setMobileNumber(String mobile){
        textbox_mobile.sendKeys(mobile);
    }

    // click submit button
    public void submit(){
        //button_submit.click(); //submit button is hidden by advert, we use first name textbox for the submission.
        textbox_firstname.submit();
    }

    // get firstname validation status
    public boolean is_ValidFirstname(){
        return (Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].validity.valid;", textbox_firstname);
    }

    // get lastname validation status
    public boolean is_ValidLastname(){
        return (Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].validity.valid;", textbox_lastname);
    }

    // get email validation status
    public boolean is_ValidEmail(){
        return (Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].validity.valid;", textbox_email);
    }

    // get mobile validation status
    public boolean is_ValidMobile(){
        return (Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].validity.valid;", textbox_mobile);
    }

    // get gender validation status
    public boolean is_ValidGender(){
        Boolean valid_male = (Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].validity.valid;", radio_gender_male);
        Boolean valid_female = (Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].validity.valid;", radio_gender_female);
        Boolean valid_other = (Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].validity.valid;", radio_gender_other);
        return valid_male && valid_female && valid_other;
    }
}
