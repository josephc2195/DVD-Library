package com.mycompany.dvdlibrary.dao;

import com.mycompany.dvdlibrary.dto.DVD;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;

/**
 * A text file implementation of the DAO 
 * @author Henry Perrottet
 * Property of LunchBreak Software 
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao {
    Map<String, DVD> library = new HashMap<>();
    private static final String DELIMITER = "::";
    private static final String DATA_FILE = "LIBRARY.txt";
    
    /**
     * Add a DVD object to storage. If there is already a DVD under that title it is overwritten
     * @param _dvd the DVD object to add
     * @return if there was already a DVD under that title, return overwritten DVD, otherwise null
     * @throws DvdLibraryDaoException 
     */
    @Override
    public DVD addDVD(DVD _dvd) throws DvdLibraryDaoException{
        loadData();
        DVD previous = library.put(_dvd.getTitle(), _dvd);
        storeData();
        return previous;
    }

    /**
     * Remove a DVD object from storage, specified by title parameter
     * @param _targetTitle title of DVD to remove
     * @return the removed DVD, which is null if not found
     * @throws DvdLibraryDaoException 
     */
    @Override
    public DVD removeDVD(String _targetTitle) throws DvdLibraryDaoException{
        loadData();
        DVD existing = library.remove(_targetTitle);
        storeData();
        return existing;
    }

    /**
     * Update a DVD object by overwriting it with a given updated DVD object
     * @param _targetTitle the title of the DVD to update
     * @param _newDVD the updated DVD object to overwrite the old one with
     * @return the new object if title was found, otherwise null if not found
     * @throws DvdLibraryDaoException 
     */
    @Override
    public DVD updateDVD(String _targetTitle, DVD _newDVD) throws DvdLibraryDaoException{
        loadData();
        DVD target = getDVD(_targetTitle);
        if(target != null){
            library.put(_targetTitle, _newDVD);
            storeData();
            return _newDVD;
        }
        else{
            return null;
        }
    }

    /**
     * Get all DVDs as a List
     * @return List of DVDs 
     * @throws DvdLibraryDaoException 
     */
    @Override
    public List<DVD> getAllDVD() throws DvdLibraryDaoException{
        loadData();
        return new ArrayList<>( library.values() );
    }

    /**
     * Get a specific DVD by title
     * @param _title title of DVD to get
     * @return DVD object which is null if not found
     * @throws DvdLibraryDaoException 
     */
    @Override
    public DVD getDVD(String _title) throws DvdLibraryDaoException{
        loadData();
        return library.get(_title);
    }

    /**
     * Search DVDs by a search term 
     * @param _searchTerm Search term
     * @return List of all DVDs whose title contained that term
     * @throws DvdLibraryDaoException 
     */
    @Override
    public List<DVD> searchDVDByTitle(String _searchTerm) throws DvdLibraryDaoException{
        loadData();
        List<DVD> results = new ArrayList<>();
        
        for(String title : library.keySet() ){
            if(title.contains(_searchTerm)){
                results.add(library.get(title));
            }
        }
        return results;
    }
    
    /**
     * Load data from file by reading and unmarshalling each line of the file
     * @throws DvdLibraryDaoException 
     */
    public void loadData() throws DvdLibraryDaoException{
        Scanner in;
        try{
            in = new Scanner( new BufferedReader( new FileReader(DATA_FILE) ) );
        }
        catch(java.io.FileNotFoundException e){
            throw new DvdLibraryDaoException("Could not read from file", e);
        }
        
        String currentLine;
        DVD currentObj;
        while(in.hasNextLine()){
            currentLine = in.nextLine();
            if(currentLine.length() > 0){
                currentObj = unmarshall(currentLine);
                library.put(currentObj.getTitle(), currentObj);
            }
        }
        in.close();
    }
    public DVD unmarshall(String _line){
        String[] tokens = _line.split(DELIMITER);
        DVD dvdObject = new DVD();
        dvdObject.setTitle(tokens[0]);
        dvdObject.setRelease(tokens[1]);
        dvdObject.setRating(tokens[2]);
        dvdObject.setDirector(tokens[3]);
        dvdObject.setStudio(tokens[4]);
        dvdObject.setNote(tokens[5]);
        return dvdObject;
    }
    
    /**
     * Store data to file by marshalling each DVD object to text and writing to file 
     * @throws DvdLibraryDaoException 
     */
    public void storeData() throws DvdLibraryDaoException{
        PrintWriter out;
        
        try{
            out = new PrintWriter( new FileWriter( DATA_FILE ) );
        }
        catch(java.io.IOException e){
            throw new DvdLibraryDaoException("Could not write to file", e);
        }
        
        for(DVD dvd : library.values()){
            out.println( marshall(dvd) );
            out.flush();
        }
        out.close();
    }
    public String marshall(DVD _dvd){
        String line = _dvd.getTitle() + DELIMITER + _dvd.getRelease() + DELIMITER +
                      _dvd.getRating() + DELIMITER + _dvd.getDirector() + DELIMITER +
                      _dvd.getStudio() + DELIMITER + _dvd.getNote();
        return line;     
    }
}
