package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {


    Properties pro;
    public ReadConfig(){

        System.out.println("path is : "+System.getProperty("user.home"));
        File src = new File("./Configurations/config.properties");

        //File src = new File("/Users/ankushnegi/Desktop/project/inetBankingV1/Configurations/config.properties");
        try{
                FileInputStream fis = new FileInputStream(src);
                pro = new Properties();
                pro.load(fis);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    public String getApplicationURL(){
       return pro.getProperty("baseURL");
    }

    public String getUserName()
    {
        return pro.getProperty("username");
    }

    public String getPass()
    {
        return pro.getProperty("paswd");
    }

    public String getChromePath()
    {
        return pro.getProperty("chromepath");
    }

    public String getFirefoxPath()
    {
        return pro.getProperty("firfoxpath");
    }

}
