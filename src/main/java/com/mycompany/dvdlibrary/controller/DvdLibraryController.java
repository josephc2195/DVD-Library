/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dvdlibrary.controller;

import com.mycompany.dvdlibrary.dao.DvdLibraryDao;
import com.mycompany.dvdlibrary.dao.DvdLibraryDaoException;
import com.mycompany.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.mycompany.dvdlibrary.ui.UserIO;
import com.mycompany.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author Chica
 * Property of Lunch Break Software
 */
public class DvdLibraryController {
    
    private final UserIO io = new UserIOConsoleImpl();
    private final DvdLibraryDao dao;
    
    public DvdLibraryController(DvdLibraryDao dao) {
        this.dao = dao;
    }
    
    public void run() {
        boolean cont = true;
        int menuSelection = 0;
        while(cont) {
            menuSelection = getMenuSelection();
            
            switch(menuSelection) {
                case 1:
                    addDvd();
                    break;
                case 2:
                    removeDvd();
                    break;
                case 3: 
                    editDvd();
                    break;
                case 4:
                    listDvd();
                    break;
                case 5: 
                    displayDvd();
                    break;
                case 6: 
                    searchDvd();
                    break;
                case 7:
                    cont = false;
                    break;
                default:
                    io.print("Unknown command");
                   
            }
        }
        io.print("GOOD BYE");
    }
    
    private int getMenuSelection() {
        return 0;
    }
    
    private void addDvd() {
        
    }
    
    private void removeDvd() {
        
    }
    
    private void editDvd() {
        
    }
    
    private void listDvd() {
        
    }
    
    private void displayDvd() {
        
    }

    private void searchDvd() {
        
    }
}
