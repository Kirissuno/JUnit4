package com.app.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * @author robfilip
 * Funcional
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeleniumTest {
	
//	@Test
//	public void entrar() {
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://localhost:4200");
//		
//		driver.findElement(By.id("personas")).click();
//		driver.findElement(By.id("nombre")).getText().contains("88");
//		driver.findElement(By.id("modificar")).click();
//		
//		assertThat(driver.findElement(By.className("atras")).getText().contains("atras"));
//	}
	
	@Test
	public void testB_actualizar() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		
		driver.findElement(By.id("personas")).click();
		driver.findElement(By.id("modificar22")).click();
		driver.findElement(By.name("nombre")).clear();
		driver.findElement(By.name("nombre")).sendKeys("Oktay");
		driver.findElement(By.name("apellidos")).clear();
		driver.findElement(By.name("apellidos")).sendKeys("Conde");
		driver.findElement(By.className("guardar")).click();
		driver.findElement(By.id("personas")).click();
		
		assertThat(driver.findElement(By.id("nombre")).getText().contains("Oktay"));
	}
	
	@Test
	public void testA_crear() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:4200/#/npersona");
		
		driver.findElement(By.id("nombre")).sendKeys("Selenium");
		driver.findElement(By.id("tlfn")).sendKeys("TLFNSelenium");
		driver.findElement(By.id("enviar")).click();
		driver.findElement(By.id("personas")).click();
		
		assertThat(driver.findElement(By.id("nombre")).getText().contains("Selenium"));
		
	}
	
	@Test
	public void testC_borrar() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		
		driver.findElement(By.id("personas")).click();
		driver.findElement(By.id("borrarTLFNSelenium")).click();
		
		assertThat(!driver.findElement(By.id("borrarTLFNSelenium")).getText().contains("borrarTLFNSelenium"));
	}
	
}
