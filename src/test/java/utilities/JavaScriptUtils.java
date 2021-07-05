package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {
	
	JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
	
	
	// scrolls down to an element given
	public void scrollToElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	// scrolls down to certain number in this 800
	public void scrollDown() {
		js.executeScript("javascript:window.scrollBy(0,800)");
	}
	
	public void jsRefresh() {
		js.executeScript("history.go(0)");
	}
	
	public void jsClickElement(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}
	
	public void jsCreateAlert() {
		js.executeScript("alert('Hey yo, whassup!')");
	}
	
	public void highLightElement(WebElement element) throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			js.executeScript("arguments[0].style.border='4px solid red'", element);
			Thread.sleep(300);
			js.executeScript("arguments[0].style.border='4px solid blue'", element);
			Thread.sleep(300);
		}
	}
	
	public void hightLightElements(WebElement element) throws InterruptedException {
		for (int i = 0; i < 4; i++) {
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 4px solid red;");
		Thread.sleep(300);
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		Thread.sleep(300);
		}
	}
	
}