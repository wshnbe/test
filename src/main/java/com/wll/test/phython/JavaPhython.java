package com.wll.test.phython;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JavaPhython {

	public static void main(String args[]) {
		try{  
            System.out.println("start");  
            Process pr = Runtime.getRuntime().exec("python /home/wll/phyData/berkeleydb_forApp.py");               
            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));  
            String line = null;  
            while ((line = in.readLine()) != null) {  
                System.out.println(line);  
            }  
            in.close();  
            pr.waitFor();  
            System.out.println("end");  
		} catch (Exception e){  
		    e.printStackTrace();            
		}  
    }  
}
