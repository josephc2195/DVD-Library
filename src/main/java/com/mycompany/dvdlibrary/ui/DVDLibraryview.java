package com.mycompany.dvdlibrary.ui;

import com.mycompany.dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author mihrettadesse
 */
public class DVDLibraryview {

    private UserIO io;

    public DVDLibraryview(UserIO _io) {
        this.io = _io;
    }

    /**
     * displays menu and gets user input
     * 
     * @return user selected menu option
     */
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD Info");
        io.print("4. List DVDs");
        io.print("5. Display DVD");
        io.print("6. Search DVD");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    /**
     * gets information about the new dvd object being added from user
     * 
     * @return dvd object
     */
    public DVD getNewDVDInfo() {

        String title = io.readString("Please enter The DVD Title");
        String releaseDate = io.readString("Please enter The release Date");
        String rating = io.readString("Please enter The Rating");
        String directorName = io.readString("Please enter The Director Name");
        String studio = io.readString("Please enter The Studio");
        String note = io.readString("Please enter The Note");
        DVD dvd = new DVD();
        //uses public setters to update private attributes for object
        dvd.setTitle(title);
        dvd.setRelease(releaseDate);
        dvd.setRating(rating);
        dvd.setDirector(directorName);
        dvd.setStudio(studio);
        dvd.setNote(note);
        return dvd;
    }

    /**
     * This method displays all current dvds in collection
     * @param dvdList list of dvds
     */
    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            displayDVD(currentDVD);//uses another method in this class to display dvd information
            io.print("\n");
        }
        io.readString("Please hit enter to continue.");
    }

    /**
     * gets dvd title from user input
     * 
     * @return dvd title
     */
    public String getDVDTitle() {
        return io.readString("Please enter the DVD title:");
    }

    /**
     * this method displays if a dvd has been successfully removed
     * 
     * @param dvd that has been removed from collection
     */
    public void removeDVD(DVD dvd) {
        if (dvd != null) {
            io.print("DVD removed");
        } else {
            io.print("No such DVD found");
        }
        io.readString("Please hit enter to continue");
    }

    public void displayDisplayDVDBanner() {
        io.print("=== Display DVD ===");
    }

    /**
     * Displays all information for selected DVD
     * 
     * @param dvd object
     */
    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            //using getter methods to read private attributes
            io.print("Title: " + dvd.getTitle());
            io.print("Release: " + dvd.getRelease());
            io.print("Rating: " + dvd.getRating());
            io.print("Director: " + dvd.getDirector());
            io.print("Studio: " + dvd.getStudio());
            io.print("User Note: " + dvd.getNote());

        } else {
            io.print("No such dvd.");
        }
        io.readString("Please hit enter to continue");
    }

    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }

    /**
     * displays if dvd was successfully removed
     * 
     * @param dvdRecord dvd object
     */
    public void displayRemoveResult(DVD dvdRecord) {
        if (dvdRecord != null) {
            io.print("DVD successfully removed.");
        } else {
            io.print("No such dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {//used when user exits
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {//used when user enters number not on menu
        io.print("Unknown Command!!!");
    }

    /**
     * user inputs a new value for an existing attribute on a dvd
     * 
     * @return string value of attribute that will be edited
     */
    public String editDVD() {
        return io.readString("Please enter the new value: ");
    }

    /**
     * user selects an option from menu displayed
     * 
     * @return choice of edit menu
     */
    public int displayEditMenu() {
        io.print("1. Title");
        io.print("2. Release year");
        io.print("3. Rating");
        io.print("4. Director");
        io.print("5. Studio");
        io.print("6. Note");

        return io.readInt("Please select from these choices above", 1, 6);
    }

    /**
     * This method gets the term of what the user is searching for
     * 
     * @return string of the user search term
     */
    public String getSearchTerm() {
        return io.readString("Please enter the search term");
    }
    
    /**
     * This method displays the result of the search
     * 
     * @param dvds list of results from search
     */
    public void displaySearchResults(List<DVD> dvds) {
        for(DVD d : dvds) {
            io.print(d.getTitle());
        }
        io.readString("Please hit enter to continue");
        
    }
}
