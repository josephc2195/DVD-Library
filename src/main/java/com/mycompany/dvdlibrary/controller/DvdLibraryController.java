/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dvdlibrary.controller;

import com.mycompany.dvdlibrary.dao.DvdLibraryDao;
import com.mycompany.dvdlibrary.dao.DvdLibraryDaoException;
import com.mycompany.dvdlibrary.dto.DVD;
import com.mycompany.dvdlibrary.ui.DVDLibraryview;
import com.mycompany.dvdlibrary.ui.UserIO;
import com.mycompany.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author Chica
 * Property of LunchBreak Software
 */
public class DvdLibraryController {
    
    private final UserIO io = new UserIOConsoleImpl();
    private final DvdLibraryDao dao;
    private final DVDLibraryview view;
    
    public DvdLibraryController(DvdLibraryDao dao, DVDLibraryview view) {
        this.dao = dao;
        this.view = view;
    }
    
    public void run() throws DvdLibraryDaoException {
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
        return view.printMenuAndGetSelection();
    }
    
    private void addDvd() throws DvdLibraryDaoException {
        DVD newDvd = view.getNewDVDInfo();
        dao.addDVD(newDvd);
    }
    
    private void removeDvd() throws DvdLibraryDaoException {
        String dvdTitle = view.getDVDTitle();
        dao.removeDVD(dvdTitle);
    }
    
    private void editDvd() throws DvdLibraryDaoException {
        String dvdTitle = view.getDVDTitle();
        DVD dvd = dao.getDVD(dvdTitle);
        int choice = view.displayEditMenu();
        String editDVD = view.editDVD();
        switch(choice) {
            case 1 -> dvd.setTitle(editDVD);
            case 2 -> dvd.setRelease(editDVD);
            case 3 -> dvd.setRating(editDVD);
            case 4 -> dvd.setDirector(editDVD);
            case 5 -> dvd.setStudio(editDVD);
            case 6 -> dvd.setNote(editDVD);
        }
        dao.updateDVD(dvdTitle, dvd);
    }
    
    private void listDvd() throws DvdLibraryDaoException {
        List<DVD> dvdList = dao.getAllDVD();
        view.displayDVDList(dvdList);
    }
    
    private void displayDvd() {
       
    }

    private void searchDvd() {
        
    }
}
