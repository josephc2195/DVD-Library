
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
        UserIO io = new UserIOConsoleImpl();//object for printing and getting input from user
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();//Model in MVC
        DVDLibraryview myView = new DVDLibraryview(io);//View in MVC
        DvdLibraryController myController = new DvdLibraryController(myDao, myView);//Controller in MVC
        myController.run();//starts the controller
    }
}
