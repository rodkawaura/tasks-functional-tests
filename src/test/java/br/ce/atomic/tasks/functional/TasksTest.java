package br.ce.atomic.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {
	
	@Test
	public void testAmbiente()
	{
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("addTodo")).click();
		
		driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
		
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
		
		driver.findElement(By.id("saveButton")).click();
		
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Success!", message);
		
		driver.quit();
	}

}
