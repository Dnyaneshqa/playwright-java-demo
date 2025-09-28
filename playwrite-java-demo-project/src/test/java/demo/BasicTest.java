package demo;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasicTest {
    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeClass
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        page = browser.newPage();
    }

    @Test
    public void testTitle() {
        page.navigate("https://playwright.dev/");
        String title = page.title();
        System.out.println("Current title of page: " +title);
        Assert.assertTrue(title.contains("Playwright"), "Title should contain 'Playwright'");
        System.out
    }

    @Test
    public void testDocsLink() {
        page.navigate("https://playwright.dev/");
        page.click("a:get-by-text('Docs')");
        String url = page.url();
        System.out.println("Navigated URL: " + url);
        Assert.assertTrue(url.contains("docs"), "Should navigate to docs page");
    }

    
    @AfterClass
    public void teardown() {
        browser.close();
        playwright.close();
    }
}
