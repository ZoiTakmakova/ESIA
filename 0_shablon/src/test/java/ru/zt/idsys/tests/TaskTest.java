package ru.zt.idsys.tests;

import org.testng.annotations.Test;

public class TaskTest extends TestBase {

    @Test
    public void taskTest(){
        String taskName;
        taskName = "Обработка запросов СПИ - создать ответы";
        app.getNavigationHelper().gotoPlannerTask(taskName);

    }
}
