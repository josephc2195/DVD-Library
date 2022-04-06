package com.mycompany.dvdlibrary.ui;

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
}