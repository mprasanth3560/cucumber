package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	private static final String String = null;

	// Browser Launch
	public static WebDriver driver;

	public static void getBrowser(String browser) {

		try {

			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.edgedriver().setup();
				driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("internetexplorer")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();

			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}

		} catch (Exception e) {
			
			System.out.println("Invalid Browser");
		}
		/*
		switch (browser) {

		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "Ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Invalid Browser");
			break;
		}
	*/
	}

	public static String readexceldata(int rownum, int cellnum) {

		String value = null;
		try {

			File f = new File("C:\\\\Users\\\\DELL\\\\Documents\\\\Excel_Read.xlsx");

			FileInputStream fis = new FileInputStream(f);

			Workbook book = new XSSFWorkbook(fis);

			Sheet sheet = book.getSheet("Sheet1");

			Row row = sheet.getRow(rownum);

			Cell cell = row.getCell(cellnum);

			CellType cellType = cell.getCellType();

			switch (cellType) {

			case STRING:
				value = cell.getStringCellValue();

				break;

			default:

				if (DateUtil.isCellDateFormatted(cell)) {

					java.util.Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
					value = s.format(dateCellValue);

				} else {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					BigDecimal valueOf = BigDecimal.valueOf(l);
					value = valueOf.toString();

				}

				break;
			}

		} catch (Exception e) {

		}
		return value;

	}

	//Maximize
	public static void maximize() {

		driver.manage().window().maximize();

	}

	// driver methods-get,getcurrentUrl,getTitle

	public static void geturl(String url) {

		driver.get(url);

	}

	public static void currenturlTitle() {

		driver.getCurrentUrl();

	}

	public static void title() {

		driver.getTitle();

	}

	// driver methods -navigate

	public static void moveTo(String linkurl) {

		driver.navigate().to(linkurl);

	}

	public static void moveBack() {

		driver.navigate().back();

	}

	public static void moveForward() {

		driver.navigate().forward();

	}

	public static void pagerefresh() {

		driver.navigate().refresh();

	}

	// alert
	
	public void pagenotificationAlert() {

		Alert Salert = driver.switchTo().alert();
		Salert.accept();
	}

	public static void confirmAlert() {

		Alert calert = driver.switchTo().alert();
		calert.accept();

	}

	public static void promptAlert() {

		Alert palert = driver.switchTo().alert();
		palert.accept();

	}

	// actions

	public static void performClick(WebElement element) {

		Actions ac = new Actions(driver);

		ac.click(element).build().perform();

	}

	public static void performdoubleClick(WebElement element) {

		Actions ac = new Actions(driver);
		ac.doubleClick(element).build().perform();

	}

	public static void actionrightclick(WebElement element) {

		Actions ac = new Actions(driver);
		ac.contextClick(element).build().perform();

	}

	public static void actionmoveto(WebElement element) {

		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();
	}

	public static void performdrag(WebElement source, WebElement target) {
		Actions ac = new Actions(driver);
		ac.dragAndDrop(source, target).build().perform();
	}

	// Frames
	public static void window(WebElement mframe) {

		mframe.click();
		driver.switchTo().frame(0);

	}

	public static void framedefault(WebElement nframe) {

		nframe.click();
		driver.switchTo().defaultContent();
	}

	// robot
	public static void robot() throws AWTException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

	}

	public static void robot1() throws AWTException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	// window handle

	public static void manageWindow() {

		driver.getWindowHandle();

	}

	public void manageWindows() {

		driver.getWindowHandles();
	}

	// Drop Down

	public static void selectfromList(WebElement element) {

		Select s = new Select(element);

		List<WebElement> options = s.getOptions();

		for (WebElement alloptions : options) {

			String text = alloptions.getText();

			System.out.println(text);
		}

	}

	// Select by index,value,visibletext

	public static void byindex(WebElement element, int index) {

		Select s = new Select(element);

		s.selectByIndex(index);
	}

	public static void byvalue(WebElement element, String value) {

		Select s = new Select(element);

		s.selectByValue(value);
	}

	public static void debyindex(WebElement element, int index) {

		Select s = new Select(element);

		s.selectByIndex(index);
	}

	public static void debyvalue(WebElement element, String value) {

		Select s = new Select(element);

		s.selectByValue(value);
	}

	// Select Methods-display,select,enable

	public static void elementvisible(WebElement element) {

		element.isDisplayed();

	}

	public static void elementselect(WebElement element) {

		element.isSelected();

	}

	public static void elementview(WebElement element) {

		element.isEnabled();

	}

	// Select by-index ,valuevtext

	public static void dropdown(WebElement element, String type, String value) {

		Select s = new Select(element);

		if (type.equalsIgnoreCase("byindex")) {
			int index = Integer.parseInt(value);
			s.selectByIndex(index);
		}

		else if (type.equalsIgnoreCase("byvalue")) {
			s.selectByValue(value);
		}

		else if (type.equalsIgnoreCase("text")) {

			s.selectByVisibleText(value);
		}
	}

	// Select methods-All selected,first selected

	// all selected

	public static void toselectall(WebElement element) {

		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();

		for (WebElement allsoptions : allSelectedOptions) {
			String text = allsoptions.getText();
			System.out.println(text);
		}

	}

	// first selected

	public static void firstselect(WebElement element) {

		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		System.out.println(text);
	}

	// get attribute

	public static void attribute(By searchbutton) {

		WebElement element = driver.findElement(searchbutton);

		System.out.println(element);
	}

	// wait
	// implicitly wait
	public static void implicitwait() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	// explicit wait

	/*
	 * 
	 * 
	 * public static void timewait(WebElement element) {
	/

		WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.visibilityOf(element));

	}
		*/
	// Takes Screenshot

	public static void screenshot(String name) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File sourcefile = ts.getScreenshotAs(OutputType.FILE);

		File destfile = new File("C:\\Users\\DELL\\OneDrive\\Pictures\\" + name + ".png");

		Files.copy(sourcefile, destfile);
		
	}
	
	//JavaScript using Sendkeys
	
	public static void jsinputvalue(WebElement element, String textinput) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value', '" + textinput + "')", element);

		} catch (Exception e) {
			System.out.println("Input Not Valid");

		}

	}

	public static void jsclick(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", element);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// scroll up & down

	public static void navigatedown() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// scroll down
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

	// scroll by pixels
	
	public static void navigatepixels() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,1000)");
	}

	// scroll to top
	
	public static void navigateupdown(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	// input values sendkeys click button click
	// send keys

	public static void inputvalue(WebElement element, String s) {

		element.sendKeys(s);

	}
	// button-click

	public static void clickon(WebElement element) {

		element.click();

	}

	// check box

	public static void declaration(WebElement element) {
		
		element.click();
	}
	// driver methods -close

	public static void sessionclose() {

		driver.close();

	}
	// driver methods -quit

	public static void terminate() {

		driver.quit();
	}

}
