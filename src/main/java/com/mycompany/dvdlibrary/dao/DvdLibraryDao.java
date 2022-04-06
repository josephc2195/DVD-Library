package com.mycompany.dvdlibrary.dao;

import com.mycompany.dvdlibrary.dto.*;
import java.util.List;

/**
 *
 * @author Henry Perrottet
 * Property of LunchBreak Software 
 */
public interface DvdLibraryDao {
    DVD addDVD(DVD _dvd) throws DvdLibraryDaoException;
    
    DVD removeDVD(String _targetTitle) throws DvdLibraryDaoException;
    
    DVD updateDVD(String _targetTitle, DVD _newDVD) throws DvdLibraryDaoException;
    
    List<DVD> getAllDVD() throws DvdLibraryDaoException;
    
    DVD getDVD(String _title) throws DvdLibraryDaoException;
    
    List<DVD> searchDVDByTitle(String _searchTerm) throws DvdLibraryDaoException;
    
}
