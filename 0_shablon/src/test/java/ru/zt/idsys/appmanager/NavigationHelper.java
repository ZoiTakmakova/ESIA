package ru.zt.idsys.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class NavigationHelper extends HelperBase {


public NavigationHelper(WebDriver wd) {
  super(wd);
}

  public void gotoEsiaPage() {
  click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Коммерческие начисления'])[1]/following::div[5]"));
  }
//переход в раздел ЕСИА-Справочники
  public void goToEsiaHdbkPage(){
  click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Удаление учетной записи'])[1]/following::span[1]"));
  }
  //переход в раздел ЕСИА-Справочники-Центры регистрации
  public void goToEsiaHdbkRegCentr(){
  click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Справочники'])[1]/following::span[1]"));
  }

  public void gotoPlannerTask(String taskName) {
  //Планировщик
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Настройки почты'])[1]/following::span[1]"));
      wd.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    //Задачи планировщика
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Планировщик'])[1]/following::span[1]"));

    //Восстановить фильтры и сортировку
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Список [Фоновая задача]'])[1]/following::img[7]"));

    //Выбрать фильтр Наименование
    //findElement(By.id("FILTER-[LIKE]SJOB_CAPTION319726190")).sendKeys("Обработка запросов СПИ - создать ответы");
      type(By.id("FILTER-[LIKE]SJOB_CAPTION~"),taskName);


    //Применить условия фильтрации

      click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Активна'])[1]/following::span[3]"));


    //Выбрать задачу планировщика из списка
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=concat('Задача ', " +
            " '\\\"', 'Обработка запросов СПИ - создать ответы', '\\\"', ' запущена.')])[1]/following::span[2]"));
    //Запустить задачу
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Список [Фоновая задача]'])[1]/following::img[11]"));
    //Ок
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=concat('Задача ', '\\\"',  " +
            "'Обработка запросов СПИ - создать ответы', '\\\"', ' запущена.')])[1]/following::span[2]"));
  }

/*
public void gotoGroupPage() {
  if (isElementPresent(By.tagName("h1"))
    && wd.findElement(By.tagName("h1")).getText().equals("Groups")
    && isElementPresent(By.name("new"))){
    return;
  }
  click(By.linkText("groups"));
}

public void gotoAddNewPage() {

  if (isElementPresent(By.tagName("h1"))
          && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")){
    return;
  }
  click(By.linkText("add new"));
}

public void gotoHomePage() {
  if (isElementPresent(By.id("maintable"))){
    return;
  }
  click(By.linkText("home"));
}
*/
}
