package com.mycompany.dvdlibrary.dao;

import com.mycompany.dvdlibrary.dto.DVD;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Henry Perrottet
 * Property of LunchBreak Software 
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao {
    Map<String, DVD> library = new HashMap<>();
    
    @Override
    public DVD addDVD(DVD _dvd) {
        DVD previous = library.put(_dvd.getTitle(), _dvd);
        return previous;
    }

    @Override
    public DVD removeDVD(String _targetTitle) {
        DVD existing = library.remove(_targetTitle);
        return existing;
    }

    @Override
    public DVD updateDVD(String _targetTitle, DVD _newDVD) {
        DVD target = getDVD(_targetTitle);
        if(target != null){
            library.put(_targetTitle, _newDVD);
            return _newDVD;
        }
        else{
            return null;
        }
    }

    @Override
    public List<DVD> getAllDVD() {
        return new ArrayList<>( library.values() );
    }

    @Override
    public DVD getDVD(String _title) {
        return library.get(_title);
    }

    @Override
    public List<DVD> searchDVDByTitle(String _searchTerm) {
        List<DVD> results = new ArrayList<>();
        
        for(String title : library.keySet() ){
            if(title.contains(_searchTerm)){
                results.add(library.get(title));
            }
        }
        return results;
    }
    
}
