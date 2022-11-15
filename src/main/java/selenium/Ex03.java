package selenium;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex03 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

//		サイト入り
		driver.get("https://www.e-procurement.metro.tokyo.lg.jp/index.jsp");
		WebElement okButton = driver.findElement(By.cssSelector("body > div.noticeofurlchange > div > button"));
		okButton.click();
		String currentHandle = driver.getWindowHandle();
//      別タブ開く
		driver.findElement(By.cssSelector("#menu_1 > a")).click();

//		制御切り替え
		Set<String> handles = driver.getWindowHandles();
		for (String window : handles) {
			if (!currentHandle.equals(window)) {
				driver.switchTo().window(window);
			}
		}

		driver.findElement(By.cssSelector("#topMenuBtn03 > a")).click();

//		開始日時
		WebElement inputYear1 = driver.findElement(By.cssSelector(
				"body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table.searchCond > tbody > tr:nth-child(17) > td > input[type=text]:nth-child(2)"));
		inputYear1.sendKeys("4");
		WebElement inputMonth1 = driver.findElement(By.cssSelector(
				"body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table.searchCond > tbody > tr:nth-child(17) > td > input[type=text]:nth-child(3)"));
		inputMonth1.sendKeys("11");
		WebElement inputDay1 = driver.findElement(By.cssSelector(
				"body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table.searchCond > tbody > tr:nth-child(17) > td > input[type=text]:nth-child(4)"));
		inputDay1.sendKeys("15");

//		終了日時
		WebElement inputYear2 = driver.findElement(By.cssSelector(
				"body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table.searchCond > tbody > tr:nth-child(17) > td > input[type=text]:nth-child(8)"));
		inputYear2.sendKeys("4");
		WebElement inputMonth2 = driver.findElement(By.cssSelector(
				"body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table.searchCond > tbody > tr:nth-child(17) > td > input[type=text]:nth-child(9)"));
		inputMonth2.sendKeys("12");
		WebElement inputDay2 = driver.findElement(By.cssSelector(
				"body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table.searchCond > tbody > tr:nth-child(17) > td > input[type=text]:nth-child(10)"));
		inputDay2.sendKeys("14");

//		検索
		driver.findElement(By.cssSelector(
				"body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table:nth-child(2) > tbody > tr > td > a"))
				.click();

//		結果出力
		WebElement tableElem = driver.findElement(By.cssSelector("body > div.contents > div > form > table.list-data"));
		List<WebElement> trElements = tableElem.findElements(By.tagName("tr"));
		for (WebElement elem : trElements) {
			List<WebElement> tdElements = elem.findElements(By.tagName("td"));
			int count = 0;
			for (WebElement tdElem : tdElements) {
				if (count < 3) {
					System.out.print(tdElem.getText() + "\t");
				}
				count++;
			}
			System.out.println("\n---------------------");

		}

	}
}
