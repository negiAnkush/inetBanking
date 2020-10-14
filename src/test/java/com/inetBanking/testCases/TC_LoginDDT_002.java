package com.inetBanking.testCases;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends TestBase{


    @Test(dataProvider = "LoginData")
    public void loginDDT(String user, String pswd) throws InterruptedException {
        LoginPage lp = new LoginPage(driver);

        lp.setUserName(user);
        logger.info("User name is set");

        lp.setPaswd(pswd);
        logger.info("password is set");

        lp.clickLogin();
        Thread.sleep(3000);

        if(isAlertPresent() == true)
        {
            driver.switchTo().alert().accept(); // close alert
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            logger.warn("login fail");
        }
        else
        {
            Assert.assertTrue(true);
            logger.info("login successful");
            lp.clickLogout();
            Thread.sleep(3000);
            driver.switchTo().alert().accept();  // close logout alert
            driver.switchTo().defaultContent();
        }
        //testig commands
        


    }

    boolean isAlertPresent()  // user def method created to check alert os present or not
    {
        try{
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e)
        {
            return false;

        }

    }

    @DataProvider(name="LoginData")
    Object[][] getData() throws IOException {

        String path = System.getProperty("user.dir")+ "/src/test/java/com/inetBanking/testData/userdata.xlsx";
        int rowCount = XLUtils.getRowCount(path, "Sheet1");
        int colCount = XLUtils.getCellCount(path, "Sheet1", 1);

        String loginData[][] = new String[rowCount][colCount];

        for (int i=1; i<=rowCount; i++)
        {
            for (int j=0; j<colCount; j++)
            {
                loginData[i-1][j]=XLUtils.getCellData(path, "sheet1", i,j); //1, 0
            }
        }

        return loginData;
    }

}
