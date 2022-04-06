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

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1.Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD Info");
        io.print("4. List DVDs");
        io.print("5. Display DVD");
        io.print("6. Search DVD");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public DVD getNewDVDInfo() {

        String title = io.readString("Please enter The DVD Title");
        String releaseDate = io.readString("Please enter The release Date");
        String rating = io.readString("Please enter The Rating");
        String directorName = io.readString("Please enter The Director Name");
        String studio = io.readString("Please enter The Studio");
        String note = io.readString("Please enter The Note");
        DVD dvd = new DVD();
        dvd.setTitle(title);
        dvd.setRelease(releaseDate);
        dvd.setRating(rating);
        dvd.setDirector(directorName);
        dvd.setStudio(studio);
        dvd.setNote(note);
        return dvd;
    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            String dvdInfo = String.format("#%s : %s %s",
                    currentDVD.getTitle(),
                    currentDVD.getRelease(),
                    currentDVD.getRating(),
                    currentDVD.getDirector(),
                    currentDVD.getStudio(),
                    currentDVD.getNote());

            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public String getDVDTitle() {
        return io.readString("Please enter the DVD title:");
    }

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

    public String getDVDTitleChoice() {
        return io.readString("Please enter the DVD TITLE.");
    }

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getRelease());
            io.print(dvd.getRating());
            io.print(dvd.getDirector());
            io.print(dvd.getStudio());
            io.print(dvd.getNote());

            io.print("");
        } else {
            io.print("No such dvd.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveDVDBanner () {
    io.print("=== Remove DVD ===");
}

public void displayRemoveResult(DVD dvdRecord) {
    if(dvdRecord != null){
      io.print("DVD successfully removed.");
    }else{
      io.print("No such dvd.");
    }
    io.readString("Please hit enter to continue.");
}
}
