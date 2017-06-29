package com.web.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;

import com.absmybatis.util.DateUtil;

public class TokenProcessor {  
	private static TokenProcessor instance = new TokenProcessor();  
	  
    private long previous;  
  
    protected TokenProcessor() {  
    }  
  
    public static TokenProcessor getInstance() {  
        return instance;  
    }  
  
    /**
     * 日期  yyyy-mm-dd hh:MM:ss
     * @param token_update_date
     * true 有效  false 无效
     * @return
     */
    public synchronized boolean isTokenValid(String token_update_date ) {  
    	 Date date = DateUtil.getDate(token_update_date, "yyyy-MM-dd HH:mm:ss")  ; 
    	 Date today = new Date(); 
    	 Calendar aCalendar = Calendar.getInstance();
         aCalendar.setTime(date);
         int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
         aCalendar.setTime(today);
         int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
         return Math.abs(day2 - day1) < 7;
    }  
  
  
    public synchronized String generateToken(String user_cd) {  
        try {  
  
            long current = System.currentTimeMillis();  
            if (current == previous)   
                current++;  
            previous = current;  
            byte now[] = (new Long(current)).toString().getBytes();  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            md.update(user_cd.getBytes());  
            md.update(now);  
            return toHex(md.digest());  
        } catch (NoSuchAlgorithmException e) {  
            return null;  
        }  
    }  
  
      
    private String toHex(byte buffer[]) {  
        StringBuffer sb = new StringBuffer(buffer.length * 2);  
        for (int i = 0; i < buffer.length; i++) {  
            sb.append(Character.forDigit((buffer[i] & 240) >> 4, 16));  
            sb.append(Character.forDigit(buffer[i] & 15, 16));  
        }  
        return sb.toString();  
    }  
    
    public static void main(String[] args) {
    	System.out.println(TokenProcessor.getInstance().generateToken("ddd"));
    	System.out.println(TokenProcessor.getInstance().isTokenValid("2016-07-12 24:14:00"));
		
		
	}
}  
