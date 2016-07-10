// IBookManager.aidl
package com.example.aidlstudy_server;

// Declare any non-default types here with import statements
import com.example.aidlstudy_server.Book;
interface IBookManager {
    void setBook(in Book book);
    List<Book> getBooks();
}
