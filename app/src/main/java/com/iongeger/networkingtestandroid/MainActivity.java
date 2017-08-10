package com.iongeger.networkingtestandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MainActivity extends Activity {

    private EditText ipInput, portInput;

    Socket myClient;

    private boolean connected = false;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    Message mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ipInput = (EditText) findViewById(R.id.IPeditText);
        portInput = (EditText) findViewById(R.id.PORTeditText);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Disconnect();
            System.exit(0);
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    //Metodo para intentar conectarse con el servidor
    public void Connect (View v){
        //se obtiene los datos ingresados
        String IP = ipInput.getText().toString();
        int PORT = Integer.valueOf(portInput.getText().toString());


        try{
            //creamos sockets con los valores anteriores
            myClient = new Socket(IP, PORT);
            //si nos conectamos
            setContentView(R.layout.touch_layout);
        }catch (Exception e){
            //Si hubo un error
            Alert("Error: No se pudo conectar");

        }
    }

    //Metodo para intentar desconectarse del servidor
    public void Disconnect(){
        try{
            Message msg = new Message();
            msg.setLast_msg(true);
            oos = new ObjectOutputStream(myClient.getOutputStream());
            //si la conexion continua
            if(myClient.isConnected()){
                oos.writeObject(msg);;
            }
        }catch(Exception e){
            setContentView(R.layout.activity_main);
            Alert("Error: No se pudo conectar");
        }
    }

    public void Alert(String str){
        new AlertDialog.Builder(this).setTitle(str).setNeutralButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int button){
                //do nothing
            }
        })
                .show();
    }





}
