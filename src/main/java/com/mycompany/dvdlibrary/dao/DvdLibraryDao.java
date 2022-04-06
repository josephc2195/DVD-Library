package com.mycompany.dvdlibrary.dao;

import com.mycompany.dvdlibrary.dto.*;
import java.util.List;

/**
 *
 * @author Henry Perrottet
 * Property of LunchBreak Software 
 */
public interface DvdLibraryDao {
    DVD addDVD(DVD _dvd);
    
    DVD removeDVD(String targetTitle);
    
    DVD updateDVD(String _targetTitle, DVD _newDVD);
    
    List<DVD> getAllDVD();
    
    DVD getDVD(String _title);
    
    List<DVD> searchDVDByTitle(String _searchTerm);
    
}
