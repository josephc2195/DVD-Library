/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.dvdlibrary.dao;

import com.mycompany.dvdlibrary.dto.DVD;
import java.io.FileWriter;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author chica
 */
public class DvdLibraryDaoFileImplTest {

    DvdLibraryDao testDao = new DvdLibraryDaoFileImpl();

    public DvdLibraryDaoFileImplTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        String fileName = "BunchOfDVDs.txt";
        new FileWriter(fileName);
        testDao = new DvdLibraryDaoFileImpl(fileName);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddDvd() throws DvdLibraryDaoException {
        DVD currentDVD = new DVD();
        String title = "Kangaroo Jack";
        currentDVD.setTitle(title);
        currentDVD.setRelease("2003");
        currentDVD.setRating("PG");
        currentDVD.setDirector("Joe Shmo");
        currentDVD.setStudio("Hollywood");
        currentDVD.setNote("Funny");

        testDao.addDVD(currentDVD);

        DVD retrievedDVD = testDao.getDVD(title);
        assertEquals(retrievedDVD.getTitle(), currentDVD.getTitle(), "checking title...");
        assertEquals(retrievedDVD.getRelease(), currentDVD.getRelease(), "checking release...");
        assertEquals(retrievedDVD.getRating(), currentDVD.getRating(), "checking rating...");
        assertEquals(retrievedDVD.getDirector(), currentDVD.getDirector(), "checking director...");
        assertEquals(retrievedDVD.getStudio(), currentDVD.getStudio(), "checking studio...");
        assertEquals(retrievedDVD.getNote(), currentDVD.getNote(), "checking note...");        
        
        assertEquals(5, testDao.getAllDVD().size(), "Size should be 5");
    }

    @Test
    public void testRemoveDvd() throws DvdLibraryDaoException {
        DVD firstDVD = new DVD();
        String title = "Batman";
        firstDVD.setTitle(title);
        firstDVD.setRelease("2010");
        firstDVD.setRating("PG-13");
        firstDVD.setDirector("Christopher Nolan");
        firstDVD.setStudio("Warner Bros");
        firstDVD.setNote("good movie");
        
        DVD secondDVD = new DVD();
        String secondTitle = "Sonic";
        secondDVD.setTitle(secondTitle);
        secondDVD.setDirector("Jeff Fowler");
        secondDVD.setRelease("2022");
        secondDVD.setRating("PG");
        secondDVD.setNote("Very blue");
        secondDVD.setStudio("Fox");
        
        //add both dvds to dao
        testDao.addDVD(firstDVD);
        testDao.addDVD(secondDVD);
        
        //remove 1 dvd
        DVD removed = testDao.removeDVD(secondTitle);
        assertEquals(removed.getTitle(), secondDVD.getTitle(), "Sonic should be removed");
        
        assertEquals(5, testDao.getAllDVD().size(), "Size should be 5");
        
    }

    @Test 
    public void testUpdate() throws DvdLibraryDaoException {
        DVD currentDVD = new DVD();
        String title = "Saw";
        currentDVD.setTitle(title);
        currentDVD.setRelease("2001");
        currentDVD.setRating("R");
        currentDVD.setDirector("adsf");
        currentDVD.setStudio("Hollywood");
        currentDVD.setNote("Horror movie");
        
        testDao.addDVD(currentDVD);
        
        DVD dvdTwo = new DVD();
        dvdTwo.setTitle(title);
        dvdTwo.setRelease("2001");
        dvdTwo.setRating("R");
        dvdTwo.setDirector("James Wan");
        dvdTwo.setStudio("Hollywood");
        dvdTwo.setNote("Horror movie");
        
        DVD updatedDVD = testDao.updateDVD(title, dvdTwo);
        
        assertEquals(updatedDVD, dvdTwo, "The new updated DVD");
        
        assertEquals(5, testDao.getAllDVD().size(), "Size should be 5");
        
    }
}
