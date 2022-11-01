package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.RegistrationPage;
import urls.Urls;
import java.time.Duration;

public class TestRegistration {
    static WebDriver driver;
    RegistrationPage registrationPage;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "libraries/webdriver/chromedriver");

        // comment below lines if not running on MacOS
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        driver = new ChromeDriver(options);

        //Uncomment below line if using Windows OS
        // driver.manage().window().maximize();

        //implicit wait when page takes too long to load (happens sometimes)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(Urls.getRegistrationUrl());
    }

    /**
     * This test case will navigate to the registration link.
     * Verify registration without first name fails
     */
    @Test()
    public void test_registration_with_no_firstname(){
        driver. navigate(). refresh();
        registrationPage = new RegistrationPage(driver);
        registrationPage.setLastName("Mungai");
        registrationPage.setEmail("email@123.com");
        registrationPage.setGenderMale();
        registrationPage.setMobileNumber("0123456789");
        registrationPage.submit();

        assert registrationPage.is_ValidFirstname() == false;
        assert registrationPage.is_ValidLastname() == true;
        assert registrationPage.is_ValidEmail() == true;
        assert registrationPage.is_ValidGender() == true;
        assert registrationPage.is_ValidMobile() == true;
    }

    /**
     * This test case will navigate to the registration link.
     * Verify registration without last name fails
     */
    @Test()
    public void test_registration_with_no_lastname(){
        driver. navigate(). refresh();
        registrationPage = new RegistrationPage(driver);
        registrationPage.setFirstName("Peter");
        registrationPage.setEmail("email@123.com");
        registrationPage.setGenderMale();
        registrationPage.setMobileNumber("0123456789");
        registrationPage.submit();

        assert registrationPage.is_ValidLastname() == false;
        assert registrationPage.is_ValidFirstname() == true;
        assert registrationPage.is_ValidEmail() == true;
        assert registrationPage.is_ValidGender() == true;
        assert registrationPage.is_ValidMobile() == true;
    }

    /**
     * This test case will navigate to the registration link.
     * Verify registration with invalid email format fails
     */
    @Test()
    public void test_registration_with_invalid_email(){
        driver. navigate(). refresh();
        registrationPage = new RegistrationPage(driver);
        registrationPage.setFirstName("Peter");
        registrationPage.setLastName("Mungai");
        registrationPage.setEmail("email123.com");
        registrationPage.setGenderMale();
        registrationPage.setMobileNumber("0123456789");
        registrationPage.submit();

        assert registrationPage.is_ValidEmail() == false;
        assert registrationPage.is_ValidFirstname() == true;
        assert registrationPage.is_ValidLastname() == true;
        assert registrationPage.is_ValidGender() == true;
        assert registrationPage.is_ValidMobile() == true;
    }

    /**
     * This test case will navigate to the registration link.
     * Verify registration with no gender selected fails
     */
    @Test()
    public void test_registration_with_no_gender(){
        driver. navigate(). refresh();
        registrationPage = new RegistrationPage(driver);
        registrationPage.setFirstName("Peter");
        registrationPage.setLastName("Mungai");
        registrationPage.setEmail("email@123.com");
        registrationPage.setMobileNumber("0123456789");
        registrationPage.submit();

        //System.out.println(registrationPage.is_ValidGender());
        assert registrationPage.is_ValidGender() == false;
        assert registrationPage.is_ValidFirstname() == true;
        assert registrationPage.is_ValidLastname() == true;
        assert registrationPage.is_ValidEmail() == true;
        assert registrationPage.is_ValidMobile() == true;
    }

    /**
     * This test case will navigate to the registration link.
     * Verify registration with invalid mobile format fails
     */
    @Test()
    public void test_registration_with_invalid_mobile(){
        driver. navigate(). refresh();
        registrationPage = new RegistrationPage(driver);
        registrationPage.setFirstName("Peter");
        registrationPage.setLastName("Mungai");
        registrationPage.setEmail("email@123.com");
        registrationPage.setGenderFemale();
        registrationPage.setMobileNumber("0123456");
        registrationPage.submit();

        assert registrationPage.is_ValidMobile() == false;
        assert registrationPage.is_ValidFirstname() == true;
        assert registrationPage.is_ValidLastname() == true;
        assert registrationPage.is_ValidEmail() == true;
        assert registrationPage.is_ValidGender() == true;
    }

    /*
    * Close driver instance after executing each test
     */
    @AfterEach
    public void cleanup(){
        driver.close();
    }
}
