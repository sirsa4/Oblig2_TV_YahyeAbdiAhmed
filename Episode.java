package Oblig2_TV_YahyeAbdiAhmed;

/*
* samarbeidet med Mostafa Ali Haider
--Resources:
1: class in class,ArrayList: hiof: https://www.youtube.com/watch?v=E2OBcAOG4J0&list=PLEvoVHoL8DxNUskHuf1YnOctQBLnO_F_F&index=9
2: ArrayList: https://www.youtube.com/watch?v=pTAda7qU4LY&t=2s
3: LocalDate: https://www.youtube.com/watch?v=dOvYkzKfsdg
4: toString method: https://www.youtube.com/watch?v=GvbdMwfjB98
 */

public class Episode {
    //instance variables
    private String title;
    private int episodeNr;
    private int sesongNr;

    //made spilletid a double datatype. Episodes dont end in full numbers always. 2 hours 20min and 45sec for example.
    private double spilletid;

    //contructor with all instance variables
    public Episode(String title,int episodeNr, int sesongNr,double spilletid){
        this.title = title;
        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;
        this.spilletid = spilletid;

    }
    public Episode(String title,int episodeNr, int sesongNr){
        this.title = title;
        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;
    }

    //toString() is a java inbuilt method in classes that can be overridden. Objects inherit this method from classes. By default, this method shows the memory address/reference of the class or the object depending on where the method called from.
    //toString method returns a string datatype as the name implies
    public String toString(){
        return "Episode number: "+this.episodeNr + " \""+this.title + "\" is from season "+this.sesongNr+" and lasts for "+this.spilletid+" min.\n";
    }

    //getter and setter methods
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public int getEpisodeNr(){
        return this.episodeNr;
    }
    public void setEpisodeNr(int episodeNr){
        this.episodeNr = episodeNr;
    }
    public int getSesongNr(){
        return this.sesongNr;
    }
    public void setSesongNr(int sesongNr){
        this.sesongNr = sesongNr;
    }
    public double getSpilletid(){
        return this.spilletid;
    }
    public void setSpilletid(double spilletid){
        this.spilletid = spilletid;
    }

}
