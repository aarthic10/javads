package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestTest {

	public static void main(String[] args) {
		
		
		try {
			
			System.out.println("Hitting Server .... \n");
			URL url = new URL("http://rtapp4:8080/InventoryWebApp/inventory?itemID=200091065&storeIds=2801,2802,2803");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		/*Runnable runnable = () -> {
			
		};*//*
		
		for(int i=0;i<160;i++){
			Thread t = new Thread(runnable);
			if(i%2==0){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			t.start();
			
			
			*/
		}
		
	}


