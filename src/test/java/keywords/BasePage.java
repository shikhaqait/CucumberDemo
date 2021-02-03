package keywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import browserfactory.DriverManager;
import resourcereader.YamlReader;

public class BasePage {

	protected WebDriver driver;
	public YamlReader testData;
	
	public BasePage() {
		this.driver = DriverManager.getDriver();
		testData = new YamlReader();
	}
	
	/**
	 * retrun the webelement
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	/**
	 * retrun the webelement
	 * @param locator
	 * @return
	 */
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	/**
	 * Method enter text in element
	 * @param element
	 * @param text
	 */
	public void enterText(WebElement element,String text) {
		element.click();
		element.clear();
		element.sendKeys(text);
	}
	
	/**
	 * Click using js
	 * @param element
	 */
	public void clickUsingJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].click()",element);
	}
	
	public void clickUsingAction(WebElement element) {
		Actions action = new Actions(this.driver);
		action.moveToElement(element);
		action.click().build().perform();
	}
	
	public void executeJSscript(String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript(script);
	}
	
}
