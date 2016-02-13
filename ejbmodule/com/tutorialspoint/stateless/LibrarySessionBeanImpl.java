package com.tutorialspoint.stateless;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class LibrarySessionBeanImpl implements LibrarySessionBeanRemote {
    
    List<String> bookShelf;    
    
    public LibrarySessionBeanImpl(){
       bookShelf = new ArrayList<String>();
    }
    
    public void addBook(String bookName) {
        bookShelf.add(bookName);
    }    
 
    public List<String> getBooks() {
        return bookShelf;
    }
}