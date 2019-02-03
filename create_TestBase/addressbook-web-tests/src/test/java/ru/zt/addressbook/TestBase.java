package ru.zt.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
FirefoxDriver wd;

public static boolean isAlertPresent(FirefoxDriver wd) {
  try {
    wd.switchTo().alert();
    return true;
  } catch (NoAlertPresentException e) {
    return false;
  }
}

@BeforeMethod
public void setUp() throws Exception {
  wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C://Program Files/Mozilla Firefox/firefox.exe"));
  wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  wd.get("http://localhost/addressbook/group.php");
  login("admin", "secret");
}

private void login(String username, String password) {
  wd.findElement(By.name("user")).click();
  wd.findElement(By.name("user")).clear();
  wd.findElement(By.name("user")).sendKeys(username);
  wd.findElement(By.name("pass")).click();
  wd.findElement(By.name("pass")).clear();
  wd.findElement(By.name("pass")).sendKeys(password);
  wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
}

protected void returnToGroupPage() {
  wd.findElement(By.linkText("group page")).click();
}

protected void submitGroupCreation() {
  wd.findElement(By.name("submit")).click();
}

protected void fillGroupForm(GroupData groupData) {
  wd.findElement(By.name("group_name")).click();
  wd.findElement(By.name("group_name")).clear();
  wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
  wd.findElement(By.name("group_header")).click();
  wd.findElement(By.name("group_header")).clear();
  wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
  wd.findElement(By.name("group_footer")).click();
  wd.findElement(By.name("group_footer")).clear();
  wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
}

protected void initGroupCreation() {
  wd.findElement(By.name("new")).click();
}

protected void gotoGroupPage() {
  wd.findElement(By.linkText("groups")).click();
}

@AfterMethod
public void tearDown() {
  wd.quit();
}

protected void deleteSelectedGroups() {
    wd.findElement(By.name("delete")).click();
}

protected void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
}

protected void returnToHomePage() {
  wd.findElement(By.linkText("home page")).click();
}

protected void submitAddNewCreation() {
  wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
}

protected void fillAddNewForm(AddNewData addNewData) {
  wd.findElement(By.name("firstname")).click();
  wd.findElement(By.name("firstname")).clear();
  wd.findElement(By.name("firstname")).sendKeys(addNewData.getFirstname());
  wd.findElement(By.name("middlename")).click();
  wd.findElement(By.name("middlename")).clear();
  wd.findElement(By.name("middlename")).sendKeys(addNewData.getMiddlename());
  wd.findElement(By.name("lastname")).click();
  wd.findElement(By.name("lastname")).clear();
  wd.findElement(By.name("lastname")).sendKeys(addNewData.getLastname());
  wd.findElement(By.name("company")).click();
  wd.findElement(By.name("address")).click();
  wd.findElement(By.name("address")).clear();
  wd.findElement(By.name("address")).sendKeys(addNewData.getAddress());
  wd.findElement(By.name("home")).click();
  wd.findElement(By.name("home")).clear();
  wd.findElement(By.name("home")).sendKeys(addNewData.getHomePhone());
  wd.findElement(By.name("mobile")).click();
  wd.findElement(By.name("mobile")).clear();
  wd.findElement(By.name("mobile")).sendKeys(addNewData.getMobilePhone());
  wd.findElement(By.name("email")).click();
  wd.findElement(By.name("email")).clear();
  wd.findElement(By.name("email")).sendKeys(addNewData.getEmail());
}

protected void gotoAddNewPage() {
  wd.findElement(By.linkText("add new")).click();
}
}