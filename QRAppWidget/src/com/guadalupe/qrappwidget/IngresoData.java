package com.guadalupe.qrappwidget;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.TextView;

public class IngresoData extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos);
        Button btnClick = (Button) findViewById(R.id.button2) ;
        btnClick.setOnClickListener(new View.OnClickListener() {

        	   @Override
        	   public void onClick(View view) {
        		
        		   if(view.getId()== R.id.button2){
        			   //TextView texto = (TextView) findViewById(R.id.textView2);
        			   EditText ingresado = (EditText)findViewById(R.id.editText1);
        			   EditText ingresado2 = (EditText)findViewById(R.id.editText2);
        			   EditText ingresado3 = (EditText)findViewById(R.id.editText3);
        			   
        			   
        			   AsyncTask<String, Void, String> s = new AsyncMethod().execute("/data/data/com.guadalupe.qrappwidget/files",
        			   "USUARIO: " + ingresado.getText().toString()+ " ID: " +ingresado2.getText().toString() +" FECHA: "+ ingresado3.getText().toString());

        			   TextView cambiaBoton = (TextView)findViewById(R.id.button2);
        			   cambiaBoton.setText("QR Guardado");
        			   
        			   //	AsyncTask<String, Void, String> s = new AsyncMethod().execute("/",texto.getText().toString());
        		   }
        	   }
        	   
        	});
       
        
        
   
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}