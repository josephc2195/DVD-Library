/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dvdlibrary.controller;

import com.mycompany.dvdlibrary.dao.DvdLibraryDao;
import com.mycompany.dvdlibrary.dao.DvdLibraryDaoException;
import com.mycompany.dvdlibrary.dto.DVD;
import com.mycompany.dvdlibrary.ui.DVDLibraryview;
import java.util.List;

/**
 *
 * @author Chica 
 * Property of LunchBreak Software
 */
public class DvdLibraryController {

    private final DvdLibraryDao dao; 
    private final DVDLibraryview view;

    //constructor for the class
    public DvdLibraryController(DvdLibraryDao dao, DVDLibraryview view) {
        this.dao = dao;
        this.view = view;
    }

    //run method is called in main method after object is created 
    public void run() throws DvdLibraryDaoException {
        boolean cont = true;//used to continue looping through the main menu
        int menuSelection;
        while (cont) {
            menuSelection = getMenuSelection();
            switch (menuSelection) {//the user decides in the view what option they want
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
                    view.displayUnknownCommandBanner();
                    break;
            }
        }
        view.displayExitBanner();
    }
    
    /**
     * uses view method to display a menu to the user. User selects an option 
     * which is returned to this method
     * 
     * @return int the user inputted menu selection
     */
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    /**
     * uses view to get new dvd information then sends info to dao to add 
     * new dvd to collection
     * 
     * @throws DvdLibraryDaoException 
     */
    private void addDvd() throws DvdLibraryDaoException {
        DVD newDvd = view.getNewDVDInfo(); 
        dao.addDVD(newDvd);
    }

    /**
     * uses view to get title of dvd user wants to remove
     * sends title to dao to get the dvd object
     * uses dao to remove the dvd object as well
     * 
     * @throws DvdLibraryDaoException 
     */
    private void removeDvd() throws DvdLibraryDaoException {
        view.displayRemoveDVDBanner();
        String dvdTitle = view.getDVDTitle();
        DVD removedDVD = dao.removeDVD(dvdTitle);
        view.displayRemoveResult(removedDVD);
    }

    /**
     * uses view to get title of dvd user wants to edit, 
     * along with what the user wants to edit about the dvd
     * 
     * @throws DvdLibraryDaoException 
     */
    private void editDvd() throws DvdLibraryDaoException {
        String dvdTitle = view.getDVDTitle();//view gets title of dvd
        DVD dvd = dao.getDVD(dvdTitle);//dao gets dvd object with title
        //view gets user choice of what they want to edit
        int choice = view.displayEditMenu();
        String editDVD = view.editDVD();//gets new data for the dvd object
        //switch is used with dao setter methods to update new dvd information
        switch (choice) {
            case 1://change title
                dvd.setTitle(editDVD);
                break;
            case 2://change release year
                dvd.setRelease(editDVD);
                break;
            case 3://change rating
                dvd.setRating(editDVD);
                break;
            case 4://change director
                dvd.setDirector(editDVD);
                break;
            case 5://change studio
                dvd.setStudio(editDVD);
                break;
            case 6://change note
                dvd.setNote(editDVD);
                break;
        }
        dao.updateDVD(dvdTitle, dvd);//updates the dvd object to the collection
    }

    /**
     * this method lists all the dvds currently in collection
     * 
     * @throws DvdLibraryDaoException 
     */
    private void listDvd() throws DvdLibraryDaoException {
        List<DVD> dvdList = dao.getAllDVD();//uses dao to get all the dvds in collection
        view.displayDVDList(dvdList);//uses view to display the list of dvds
    }

    /**
     * This method displays information for a particular DVD
     * 
     * @throws DvdLibraryDaoException 
     */
    private void displayDvd() throws DvdLibraryDaoException {
        view.displayDisplayDVDBanner();
        String dvdTitle = view.getDVDTitle(); //uses view to get dvd title from user input
        DVD dvd = dao.getDVD(dvdTitle); //uses dao to get the dvd object from title
        view.displayDVD(dvd);//displays information to user using view
    }

    /**
     * This method searches our dvd collection for all dvds matching user input
     * 
     * @throws DvdLibraryDaoException 
     */
    private void searchDvd() throws DvdLibraryDaoException {
        String searchTerm = view.getSearchTerm();//user inputs search term
        List<DVD> titles = dao.searchDVDByTitle(searchTerm);//created a list to hold all dvds found with search term
        view.displaySearchResults(titles);//uses view to display the found dvds
    }
}