package ru.course.at;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SeleniumTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bing.com");
    }
    @AfterEach
    public void tearDown() { driver.quit(); }

    @Test
    public void search() {
        String input = "Selenium";
        WebElement searchField = driver.findElement(By.cssSelector("#sb_form_q"));
        searchField.sendKeys(input);
        searchField.submit();

        List<WebElement> results = driver.findElements(By.cssSelector("h2 > a[href]"));

        results.get(results.size() - 1).click();
        for (WebElement el: results){
            System.out.println(el.getText());
        }
    }

    @Test
    public void example(){
        List<String> strings = new ArrayList<>();
        String a = "First string";
        String b = "Second string";
        strings.add(a);
        strings.add(b);

    }
}
