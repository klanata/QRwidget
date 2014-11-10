package com.guadalupe.qrappwidget;


import java.io.File;
import java.io.InputStream;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.content.Intent;

public class QRWidgetProvider extends AppWidgetProvider {
	
	 private static final String SYNC_CLICKED    = "automaticWidgetSyncButtonClick";
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        RemoteViews remoteViews;
        ComponentName watchWidget;

        remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget1);
        watchWidget = new ComponentName(context, QRWidgetProvider.class);
        //Llamo a funcion cuando hago click
        Intent configIntent = new Intent(context, IngresoData.class);
        PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);
       
        remoteViews.setOnClickPendingIntent(R.id.botonGenerar, configPendingIntent);
        
        //remoteViews.setOnClickPendingIntent(R.id.botonGenerar, getPendingSelfIntent(context, SYNC_CLICKED));
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
    }
    
    protected PendingIntent getPendingSelfIntent(Context context, String action) {
        Intent intent = new Intent(context, getClass());
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }
    
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        super.onReceive(context, intent);

        if (SYNC_CLICKED.equals(intent.getAction())) {
        	

            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

            RemoteViews remoteViews;
            ComponentName watchWidget;

            remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget1);
            watchWidget = new ComponentName(context, QRWidgetProvider.class);
            
            
            //prueba AsyncTask<String, Void, String> s = new AsyncMethod().execute("/data/data/com.guadalupe.qrappwidget/files","Usuario: Karina Identificador:6 Fecha:03/11/2014");
           //crea directo desde el widget AsyncTask<String, Void, String> s = new AsyncMethod().execute(context.getFilesDir().getAbsolutePath(),"Usuario: Karina Identificador:6 Fecha:03/11/2014");
			//remoteViews.setTextViewText(R.id.botonGenerar, "QR Guardado" );
            
            
            appWidgetManager.updateAppWidget(watchWidget, remoteViews);

        }
    }
    

 
    
	
    /*
    public void pump(InputStream in,int size) {
        byte[] buffer = new byte[4096]; // Or whatever constant you feel like using
        int done = 0;
        while (done < size) {
            int read = in.read(buffer);
            if (read == -1) {
                throw new IOException("Something went horribly wrong");
            }
            out.write(buffer, 0, read);
            done += read;
        }
        // Maybe put cleanup code in here if you like, e.g. in.close, out.flush, out.close
    }*/


}
