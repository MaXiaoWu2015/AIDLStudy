package com.example.aidlstudy_client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.aidlstudy_server.Book;
import com.example.aidlstudy_server.IBookManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity_mtt";

    private ArrayList<Book> list=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: "+"??");

        Intent intent=new Intent();
        intent.setAction("com.xiaowu.server");
        intent.setPackage("com.example.aidlstudy_server");
        bindService(intent, connection,Context.BIND_AUTO_CREATE);
    }


    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IBookManager bookManager=IBookManager.Stub.asInterface(service);

            try {
                list= (ArrayList) bookManager.getBooks();
                for (Book book:list)
                {
                    Log.d(TAG, "onServiceConnected: "+book.getId()+" "+book.getName()+" "+book.getCategory());
                }

                bookManager.setBook(new Book("book6",6,"category"+6));

            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
