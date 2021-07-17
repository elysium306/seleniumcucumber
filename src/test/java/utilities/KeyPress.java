package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyPress {
	static Actions action;
	
	public static void main(String[] args) throws InterruptedException {

//		Driver.getDriver().get("https://indeed.com");
//
//
//		// 4. find the input field for what and type SDET
//		WebElement inputWhat = Driver.getDriver().findElement(By.id("text-input-what"));
//		inputWhat.sendKeys("SDET");
//		// 5. find the input field for where, clear the field first and type washington
//		// DC
//		WebElement inputWhere = Driver.getDriver().findElement(By.id("text-input-where"));
//		inputWhere.sendKeys(Keys.chord(Keys.COMMAND,"a"));
//		Thread.sleep(2000);
//		inputWhere.sendKeys(Keys.DELETE);
//		
//		//String attributeValue = inputWhere.getAttribute("value");
		
		
		// Actios class hover over
		
//		Driver.getDriver().get("https://www.demoqa.com/tool-tips");
//		WebElement hoverOverMe = Driver.getDriver().findElement(By.id("toolTipButton"));
//		
//		System.out.println("Before hover over: "+hoverOverMe.getAttribute("aria-describedby"));
//		
//		action.moveToElement(hoverOverMe).perform();
//		
//		Thread.sleep(2000);
//		
//		System.out.println("After hover over: "+hoverOverMe.getAttribute("aria-describedby"));
		
	}
	
	public static void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
		action = new Actions(Driver.getDriver());
		action.dragAndDrop(sourceElement, targetElement).perform();
	}
	
	public void hoverToElement(WebElement element) {
		action = new Actions(Driver.getDriver());
		action.moveToElement(element).perform();
	}
}
