package com.guadalupe.qrappwidget;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;



import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import android.os.AsyncTask;
import android.util.Log;

public class AsyncMethod extends AsyncTask<String, Void, String> {

	@Override
	protected String doInBackground(String... filedir)  {
		// TODO Auto-generated method stub
		BufferedReader in = null;
		int data = 0;
		String out="";
		
		try{
			HttpResponse<InputStream> response = Unirest.post("https://neutrinoapi-qr-code.p.mashape.com/qr-code")
					.header("X-Mashape-Key", "Hcp19FgE8emshcFOpwCYktKA12Mnp1b4Z9tjsnUHZS21zIhbBR")
					.header("Content-Type", "application/x-www-form-urlencoded")
					.field("bg-color", "#04B486")
					.field("content",filedir[1])
					.field("fg-color", "#000000")
					.field("height", "128")
					.field("width", "128")
					.asBinary();
			
			//creo la imagen QR
			OutputStream outStream = new FileOutputStream(new File(filedir[0]+"/imagenQR.png"));
			Log.w("QRAppWidget",filedir[0].toString());
			InputStream respuesta = response.getBody();
			 byte[] buffer = new byte[8 * 1024];
			 while ((data = respuesta.read(buffer)) != -1) {
			   outStream.write(buffer, 0, data);};
			   
			   outStream.close();
		}
		

			catch(Exception e){
					e.printStackTrace();
					return "Hubo un error " +e.getMessage();
					
			}
		return filedir[0].toString();
	}
	
	   protected void onPostExecute(String result) {
		   //cuando termina el doinbackground
		   System.out.print("El resultado es " + result );
	     }



}
