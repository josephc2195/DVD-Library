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
                    io.print("Add DVD");
                    break;
                case 2:
                    io.print("Remove DVD");
                    break;
                case 3: 
                    io.print("Edit DVD");
                    break;
                case 4:
                    io.print("List DVD's");
                    break;
                case 5: 
                    io.print("Display DVD information");
                    break;
                case 6: 
                    io.print("Search");
                    break;
                case 7:
                    io.print("Exit");
                    break;
                   
            }
        }
        io.print("GOOD BYE");
    }
    
    private int getMenuSelection() {
        return 0;
    }
    
    private void createDvd() {
        
    }
}
