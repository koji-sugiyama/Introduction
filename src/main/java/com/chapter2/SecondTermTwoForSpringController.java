package com.chapter2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@EnableAutoConfiguration
public class SecondTermTwoForSpringController {

    //spring
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SecondTermTwoForSpringController.class, args);
    }

    
    private static final int LocalDateTime = 0;

	@RequestMapping("/sugiyama/")
    @ResponseBody
    String home() {

		//date
    	Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 YY:mm:ss");
        String nowDate = formatter.format(date);

        
        //初期化
        String name;
        int score;
        String resultString;
        String stFormat;
        
        //データ 杉山
    	Student KSInstance = new Student();
    	KSInstance.setName("杉山弘二");
    	KSInstance.setScore(10);
    	
    	name = KSInstance.getName();
    	score = KSInstance.getScore();
    	/*
        stFormat = "%sの%sさんの点数は%d点です。";
    	resultString = String.format(stFormat, nowDate, name, score);
    	
    	return resultString;
    	*/
    	
    	//試しにでJSON出してみる。
    	//String json = "{\"result\":[{\"name\":\"杉山\",\"score\":30},{\"name\":\"弘二\",\"score\":40}]}";
        stFormat = "{\"date\":\"%s\",\"result\":[{\"name\":\"%s\",\"score\":%d}]}";
        String json = String.format(stFormat, nowDate, name, score, name, score);
    	
    	return json;
    	
    
    }
    

    
}






