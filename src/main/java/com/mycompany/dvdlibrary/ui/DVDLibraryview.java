package com.mycompany.dvdlibrary.ui;

import com.mycompany.dvdlibrary.dto.DVD;

/**
 *
 * @author mihrettadesse
 */
public class DVDLibraryview {

    private UserIO io = new UserIOConsoleImpl();

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
    
    String title= io.readString("Please enter The DVD Title");
    String releaseDate = io.readString("Please enter The release Date");
    String rating = io.readString("Please enter The Rating");
    String directorName = io.readString("Please enter The Director Name");
    String studio= io.readString("Please enter The Studio");
    String note= io.readString("Please enter The Note");
    DVD dvd = new DVD();
    dvd.setTitle(title);
    dvd.setRelease(releaseDate);
    dvd.setRating(rating);
    dvd.setDirector(directorName);
    dvd.setStudio(studio);
    dvd.setNote(note);
    return dvd;
}
}