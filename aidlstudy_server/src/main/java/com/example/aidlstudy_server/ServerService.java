package com.example.aidlstudy_server;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxiaowu on 16/7/10.
 */
public class ServerService extends Service {

    private static final String TAG = "ServerService_mtt";

    private ArrayList<Book> books=new ArrayList<>();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        for(int i=0;i<5;i++)
        {
            Book book=new Book("book"+i,i,"category"+i);
            books.add(book);
        }


    }

    private Binder binder=new IBookManager.Stub(){

        @Override
        public void setBook(Book book) throws RemoteException {
            books.add(book);
            Log.d(TAG, "setBook: " +book.getName());
        }

        @Override
        public List<Book> getBooks() throws RemoteException {
            return books;
        }
    };

}
