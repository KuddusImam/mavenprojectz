package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesExample extends TestBase {

    //@Test(priority = 1)
    public void printWholeTable() {
        login();
        WebElement table = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        System.out.println(table.getText());
    }

    public void login() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);

    }

    @Test(priority = 2)
    public void printAllHeaders() {
        login(); //call login method
        List<WebElement> headers = driver.findElements(
                By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[1]"));
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
    }

    //@Test(priority = 3)
    public void printRow() {
        login();
        List<WebElement> allRows = driver.findElements(
                By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr"));
        System.out.println("number of rows" + allRows.size());

        for (WebElement allRow : allRows) {
            System.out.println(allRow.getText());
        }

        System.out.println("Printing Row: " + 3);
        System.out.println(allRows.get(3).getText());

    }

    @Test
    public void printTableSize() {
        login();
        List<WebElement> allRows = driver.findElements(
                By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr"));
        System.out.println("number of rows " + allRows.size());

        List<WebElement> allColumns = driver.findElements(
                By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[1]/th"));
        System.out.println("number of columns " + allColumns.size());

    }

    /*
    print a row without using a list
     */

    //@Test
    public void printRow2() {
        login();
        WebElement row = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]"));
        System.out.println(row.getText());
    }

    /*
    print all the cells of a row whose index is given in the xpath
     */
    //@Test
    public void printAllCellsInOneRow() {
        login();
        List<WebElement> cells = driver.findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[5]/td"));
        for (WebElement cell : cells) {
            System.out.println(cell.getText());
        }
    }

    /*
    print by coordinate: based on tow and column number
     */
    //@Test
    public void printByCoordinates() {
        login();
        WebElement cell = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody/tr[8]/td[5]"));
        System.out.println(cell.getText());

        System.out.println(getcell(8, 5).getText());
    }

    public WebElement getcell(int row, int col) {
        String xPath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" + row + "]/td[" + col + "]";
        return driver.findElement(By.xpath(xPath));
    }

    /*
    print all the values in single column
     */
    //@Test
    public void printCloumn() {
        login();
        List<WebElement> allNames = driver.findElements(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        for (WebElement header : allNames) {
            System.out.println(header.getText());
        }
    }

    /*
    find the select checkbox for a given name
     */
    @Test
    public void selectCheckbox() {
        login();
        WebElement checkbox = driver.findElement(By.xpath("//td[.='Susan McLaren']/../td[1]/input"));
        System.out.println(checkbox.isSelected());
        checkbox.click();
        System.out.println(checkbox.isSelected());
        //driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
    }

    /*
    verify that names 'Mark Smith' exists in the names column
    verify that city 'Whitestone, British' exists in the cities column
     */

    @Test
    public void test() {
        login();
        int nameIndex = getColumnIndex("Name");
        System.out.println(nameIndex);

        List<WebElement> allnames = driver.findElements(By.xpath("\"//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[" + nameIndex + "]"));

        boolean found = false;
        for (int i = 0; i < allnames.size(); i++) {
            if (allnames.get(i).getText().equals("Mark Smith")) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
    }
    /*
    gets a column name as a parameters
    return the index of the column name
     */

    public int getColumnIndex(String column) {
        List<WebElement> allHeader = driver.findElements(By.xpath("//table[@id='ctl00-MainContent_orderGrid']//th"));
        for (int i = 0; i < allHeader.size(); i++) {
            if (allHeader.get(i).getText().equals(column)) {
                return i + 1;
            }
        }
        return 0;
    }

}
