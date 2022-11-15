package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex02 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

//		ログイン
		driver.get("http://rakuplus.jp/");
		WebElement mailElem = driver.findElement(By.cssSelector("#user_login"));
		mailElem.sendKeys("moe.sasao@rakus-partners.co.jp");
		WebElement passElem = driver.findElement(By.cssSelector("#user_pass"));
		passElem.sendKeys("Snoopy26woodstock");
		WebElement loginElem = driver.findElement(By.cssSelector("#wp-submit"));
		loginElem.click();

//		自己紹介遷移
		WebElement QAElem = driver
				.findElement(By.cssSelector("#sgb-css-id-8 > div > a:nth-child(2) > span.c_linkto_text"));
		QAElem.click();

//		同期出力
		List<WebElement> element5 = driver.findElements(By.cssSelector("#entry > section > div"));
		int count = 0;
		for (WebElement elem : element5) {
			if (count > 0) {
				WebElement nameElem = elem.findElement(By.className("big"));
				System.out.println(nameElem.getText());
				WebElement kanaElem = elem.findElement(By.className("has-text-color"));
				System.out.println(kanaElem.getText());
				WebElement imgElem = elem.findElement(By.tagName("img"));
				String url = imgElem.getAttribute("src");
				System.out.println(url);
				System.out.println("---------------");

			}
			count++;

		}
	}
}
