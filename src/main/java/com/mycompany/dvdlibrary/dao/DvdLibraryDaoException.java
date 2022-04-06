package com.mycompany.dvdlibrary.dao;

/**
 *
 * @author Henry Perrottet
 * Property of LunchBreak Software 
 */
public class DvdLibraryDaoException extends Exception {
    public DvdLibraryDaoException(String _message){
        super(_message);
    }
    public DvdLibraryDaoException(String _message, Throwable cause){
        super(_message, cause);
    }
}
