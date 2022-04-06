package com.mycompany.dvdlibrary.dto;

/**
 * DTO (DVD Object)
 * @author Henry Perrottet
 * Property of LunchBreak Software
 */
public class DVD {
    private String title, releaseDate, rating, directorName, studio, note;
    
    //  SETTERS
    
    public void setTitle(String _newTitle){
        this.title = _newTitle;
    }
    public void setRelease(String _newRelease){
        this.releaseDate = _newRelease;
    }
    public void setRating(String _newRating){
        this.rating = _newRating;
    }
    public void setDirector(String _newDirector){
        this.directorName = _newDirector;
    }
    public void setStudio(String _newStudio){
        this.studio = _newStudio;
    }
    public void setNote(String _newNote){
        this.note = _newNote;
    }
    
    //  GETTERS
    
    public String getTitle(){
        return this.title;
    }
    public String getRelease(){
        return this.releaseDate;
    }
    public String getRating(){
        return this.rating;
    }
    public String getDirector(){
        return this.directorName;
    }
    public String getStudio(){
        return this.studio;
    }
    public String getNote(){
        return this.note;
    }
}
