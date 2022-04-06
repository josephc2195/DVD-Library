package com.mycompany.dvdlibrary.dao;

/**
 *
 * @author Henry Perrottet
 * Property of LunchBreak Software 
 */
public class DvdLibraryDaoException extends Exception {
    /**
     * Construct exception using just a message, for when something goes wrong in program
     * @param _message 
     */
    public DvdLibraryDaoException(String _message){
        super(_message);
    }
    
    /**
     * Construct with message and cause, when another exception (cause) causes the error
     * @param _message
     * @param _cause 
     */
    public DvdLibraryDaoException(String _message, Throwable _cause){
        super(_message, _cause);
    }
}
