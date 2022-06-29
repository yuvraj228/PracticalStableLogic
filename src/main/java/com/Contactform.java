package com;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Contactform {

	public static final String APIURL = "https://jsonplaceholder.typicode.com/users/1";

	By contactMenu = By.xpath("//nav[contains(@class,'elementor-nav-menu--main')]//a[text()='Contact']");
	By nameTextbox = By.xpath("//input[@placeholder='Name']");
	By emailTextbox = By.xpath("//input[@placeholder='Email']");
	By phoneTextbox = By.xpath("//input[@placeholder='Phone Number']");
	By companyTextbox = By.xpath("//input[@placeholder='Organization']");
	By messageTextbox = By.xpath("//textarea[@placeholder='Message']");
	By sendbtn = By.xpath("//button[@type='submit']");
	By successMessagetxt = By.xpath("//div[@role='alert']");

	public Responsemodal getAPI() throws JsonParseException, JsonMappingException, IOException, InterruptedException {

		HttpClient httpclient = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().GET().header("accept", "application/json")
				.uri(URI.create(APIURL)).build();

		HttpResponse<String> response = httpclient.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		ObjectMapper obj = new ObjectMapper();
		return obj.readValue(response.body(), new TypeReference<Responsemodal>() {
		});
	}

	public String contactFormFill(WebDriver driver, String name, String email, String phone, String company) {
		Util.click(driver, contactMenu);
		Util.sendkeys(driver, nameTextbox, name);
		Util.sendkeys(driver, emailTextbox, email);
		Util.sendkeys(driver, phoneTextbox, phone);
		Util.sendkeys(driver, companyTextbox, company);
		Util.sendkeys(driver, messageTextbox, "Test message from the java and selenium");

		Util.implicitlyWait(driver, 2000);

		Util.scrollIntoView(driver, sendbtn);
		Util.click(driver, sendbtn);

		Util.explicitWait(driver, 10, successMessagetxt);
		return Util.getTextOfElement(driver, successMessagetxt);

	}

}
