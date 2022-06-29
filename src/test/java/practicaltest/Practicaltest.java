package practicaltest;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Contactform;
import com.Responsemodal;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class Practicaltest {
	WebDriver driver;
	public static final String WEBURL = "https://www.veroxos.com/";
	String driverpath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
	Contactform form = new Contactform();

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(WEBURL);
	}

	@Test
	public void formFillUpTest() throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		
		// fetch Response of GET API
		Responsemodal respose = form.getAPI();
		String[] phone = respose.getPhone().split(" ");
		String successmsg = form.contactFormFill(driver, respose.getName(), respose.getEmail(), phone[0],
				respose.getCompany().getName());
		assertEquals(successmsg, "The form was sent successfully.");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
