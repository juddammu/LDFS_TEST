package com.springapp.mvc;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13. 8. 2
 * Time: 오후 1:56
 * To change this template use File | Settings | File Templates.
 */
public class Exchange {
   int a = 0;


    public String sendData(@ModelAttribute("user")User user,URL url) {

            try
            {
                URLConnection urlconn = null;
                OutputStreamWriter osw = null;
                BufferedReader br = null;
                String resData = "";
                String line ="";
                String splitLine = null;

                urlconn = url.openConnection();
                urlconn.setDoOutput(true);

          /*  osw = new OutputStreamWriter(urlconn.getOutputStream());
            osw.write(reqData);                 //접속한 URL 로 전문(data)를 write 한다.
            osw.flush();*/

                br = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));

                while((resData = br.readLine()) != null)
                {

                    System.out.println(resData);
                    splitLine = resData.split("million")[0];
                    String first = splitLine.split(" ")[1];
                    String second = splitLine.split(" ")[2];
                    String third = splitLine.split(" ")[3];
                    String forth = splitLine.split(" ")[4];

                    user.setExchange(forth);
                    return resData;
                }

            /*osw.close();*/
                br.close();
            }
            catch (IOException e)
            {

                e.printStackTrace();
            }
         return null;
        }

    }

