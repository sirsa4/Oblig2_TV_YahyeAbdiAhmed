package Oblig2_TV_YahyeAbdiAhmed;

import java.time.LocalDate;
import java.util.ArrayList;

/*
* samarbeidet med Mostafa Ali Haider
--Resources:
1: class in class,ArrayList: hiof: https://www.youtube.com/watch?v=E2OBcAOG4J0&list=PLEvoVHoL8DxNUskHuf1YnOctQBLnO_F_F&index=9
2: ArrayList: https://www.youtube.com/watch?v=pTAda7qU4LY&t=2s
3: LocalDate: https://www.youtube.com/watch?v=dOvYkzKfsdg
4: oracle LocalDate: https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/time/LocalDate.html
5: How to have LocalDate instance variable with parameter from simple chatGPT:

    private LocalDate date;

    public Example(LocalDate date) {
        this.date = date;
    }
6: toString method: https://www.youtube.com/watch?v=GvbdMwfjB98
7: calculate average: https://www.youtube.com/watch?v=KXuQQh6AynQ
 */
class TVSerie {

    //instance variables
    private String title;
    private String beskrivelse;
    private LocalDate utgivelsesdato;
    ArrayList<Episode> episoder;

    //oppgave2.5
    //gjennomsnittligSpilletid initialiseres med 0 fra start og den blir oppdatert hver gang ny episode blir lagd til objekt av klassen.
    private double gjennomsnittligSpilletid = 0;

    //oppgave2.7
    private int antallSesonger;

    public TVSerie(String title, String beskrivelse,LocalDate utgivelsesdato){
        this.title = title;
        this.beskrivelse = beskrivelse;
        this.utgivelsesdato = utgivelsesdato;
        this.episoder = new ArrayList<>();
    }

    //oppgave2.7 - getter method for antallSesonger
    public int getAntallSesonger(){
        return this.antallSesonger;
    }

    //oppgave2.5 - gjennomsnitt/average

    //getter methode for gjennomsnittligSpilletid instance variable
    public double getGjennomsnittligSpilletid() {
        return gjennomsnittligSpilletid;
    }

    //private calculate average/gjennomsnitt method
    //This method is run everytime a new episode added to TVSerie.
    //To add new episode, setter method leggTilEpisode() is used. So that means this method must execute/run in leggTilEpisode() method.
    private void oppdaterGjennomsnittligSpilletid(){
        //variable starting at 0 to store total spilletid
        double totalSpilleTid = 0;
        //loop through episode ArrayList and get spillestid from each episode
        for(int i = 0; i < episoder.size(); i++){
            totalSpilleTid = totalSpilleTid + episoder.get(i).getSpilletid();
        }

        //average is: totalSpillTid / total episodes number.
        gjennomsnittligSpilletid = totalSpilleTid / episoder.size();
    }

    //oppgave2_4: add a method which prints out all episodes in user specified season
    //this is done with getter method that returns the array as said in oppgave text: public ArrayList<Episode> hentEpisoderISesong(int sesong)
    public ArrayList<Episode> hentEpisoderISesong(int sesong){

        //new ArrayList to hold the episodes from specified sesong
        ArrayList<Episode> sesongEpisodes = new ArrayList<>();

        //loop through entire episode ArrayList first, then return only episodes which season specified by the user in this methods parameter(sesong)
        for(int i = 0; i < episoder.size(); i++){

            //with if-statement get only episodes which correct sesong number
            if(episoder.get(i).getSesongNr() == sesong){

                //add the episodes with correct sesong number to new empty array "sesongEpisodes"
                sesongEpisodes.add(episoder.get(i));
            }
        }

        //return new ArrayList from this method. The list returned can looped through. This is done in the Main class running the program.
        return sesongEpisodes;

    //method end
    }

    //toString() is a java inbuilt method in classes that can be overridden. Objects inherit this method from classes. By default, this method shows the memory address/reference of the class or the object depending on where the method called from.
    //toString method returns a string datatype as the name implies
    public String toString(){
        return "TVSerie \""+this.title +"\" aired on the television for the first time in "+this.utgivelsesdato + ". This program has a basic data of "+ this.episoder.size() + " random episodes across different seasons in "+this.title+".\n";
    }

    //getter and setter methods
    public String gettTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getBeskrivelse(){
        return beskrivelse;
    }
    public void setBeskrivelse(String beskrivelse){
        this.beskrivelse = beskrivelse;
    }

    //setter and getter methods for
    public LocalDate getUtgivelsesdato(){
        return this.utgivelsesdato;
    }
    public void setUtgivelsesdato(LocalDate utgivelsesdato){
        this.utgivelsesdato = utgivelsesdato;
    }

    //Episode array instance variable setter and methods. They are a bit different. This we have learned from hiof prog2 video "klasser i klasser" from 2021

    //get a new copy of episodes. This is to avoid giving the user ability to change data inside the original ArrayList of episodes. Returning new instance basically.
    public ArrayList<Episode> getEpisoder(){
        return new ArrayList<Episode>(episoder);
    }

    //legg til method
    public void leggTilEpisode(Episode episode){

        //oppgave2.7
        //In oppgave2.7, we are limiting the episodes that can be added only if episode has in part season that already exists or seasons that is 1 more than current highest season number.
        //In if-statement we have 2 conditions with OR-operator. One of them has to be true for condition to be fulfilled. The first one checks that epsiode number(episode.getSesongNr()) is not bigger than newly added season. The second condition checks that the current added episode is equal to 1 season higher only.
        if(episode.getSesongNr() <= antallSesonger || episode.getSesongNr() == antallSesonger + 1){

            //ArrayList class has method add() to add new item the array.
            episoder.add(episode);

            //This method updates the total average spillestid of episodes.
            //it runs everytime new episode is added to TVSerie object(futurama).
            oppdaterGjennomsnittligSpilletid();

            /*
            Here I struggled to update antallSesonger instance variable properly. I got help from student assistant to another if-statement just for the antallSesonger.
            * */
            if(episode.getSesongNr() == antallSesonger + 1){
                antallSesonger++;
            }




        } else {

            System.out.printf("Invalid season number. You're try to add episode in season %d. Episode must in already existing season or atleast season: %d\n",episode.getSesongNr(),(antallSesonger + 1));
        }

    }

}

