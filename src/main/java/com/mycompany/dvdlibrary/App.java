
package com.mycompany.dvdlibrary;

import com.mycompany.dvdlibrary.controller.DvdLibraryController;
import com.mycompany.dvdlibrary.dao.DvdLibraryDao;
import com.mycompany.dvdlibrary.dao.DvdLibraryDaoException;
import com.mycompany.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.mycompany.dvdlibrary.ui.DVDLibraryview;
import com.mycompany.dvdlibrary.ui.UserIO;
import com.mycompany.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author chica
 * Property of LunchBreak Software
 */
public class App {

    public static void main(String[] args) throws DvdLibraryDaoException {
        UserIO io = new UserIOConsoleImpl();
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        DVDLibraryview myView = new DVDLibraryview(io);
        DvdLibraryController myController = new DvdLibraryController(myDao, myView);
        myController.run();
    }
}
