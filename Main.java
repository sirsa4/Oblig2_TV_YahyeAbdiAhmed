package Oblig2_TV_YahyeAbdiAhmed;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

class Main {
    public static void main(String[] args) {

        //oppgave2.7


        //Oppgave 2.6
        //instance of Random class
        Random randomSpilleTid = new Random();
        //source: https://www.baeldung.com/java-generating-random-numbers-in-range
        //source on example: https://www.youtube.com/watch?v=VMZLPl16P5c
        // code snippet: random.nextInt(max - min) + min;
        //max is exclusive, not included in random generated number. So we need to have 1 highter than 30, 30+1 in order to have 30 being included
        double randomTid = randomSpilleTid.nextDouble((30+1) - 20) + 20;

        //TVSerie objekt instance. The tv serie i chose is called futurama. Popular animated series which similar art style to The Simpsons, The Family Guy, American Dad and Cleavland.
        TVSerie futurama = new TVSerie("futurama","Fry is frozen in time and wakes up 100 years into future in 2100", LocalDate.of(1999,03,28));

        //Some episodes for season 1. Here episode is added the method for episoder ArrayList. Episode instance is added as argument without needed to make seperate variable for each episode.
        //I found late that i needed 20 episodes per season. So this is remake instead of creating each episode alone.
        for (int i = 1; i <= 100; i++) {

            int seasong = 0;

            if(i <= 20) {
                seasong = 1;

            } else if (i <= 40) {

                seasong = 2;

            } else if (i <= 60) {

                seasong = 3;

            } else if (i <= 80) {

                seasong = 4;

            } else {
                seasong = 5;
            }

            futurama.leggTilEpisode(new Episode("Episode " + i, i, seasong, randomTid));
        }

        System.out.println();
        System.out.println("----------------Oppgave2.1 and oppgave2.2-----------------------------------");
        //oppgave2.1 and oppgave2.2
        //TVSerie and Episode class created with getter setter methods
        //Object instance of TVSerie called "futurama" is created
        //Using setter method in futurama object, episodes are added

        //Store first episode in a variable. This is for easier print out
        Episode ep1 = futurama.getEpisoder().get(0);

        //simple print of serie name and data about the first episode to console using the getter methods.
        System.out.printf("The serie %s episode number: %d named \"%s\" in season: %d lasts %.2f min\n",futurama.gettTitle(),ep1.getEpisodeNr(),ep1.getTitle(),ep1.getSesongNr(),ep1.getSpilletid());

        System.out.println();
        System.out.println("----------------Oppgave2.3-----------------------------------");
        //oppgave2.3
        //overridden toString method in TVSerie class
        System.out.printf("%s",futurama.toString());

        //get the a episode from the ArrayList episoder in Episode class with getter method. Here the 2nd episode is fetched.
        Episode ep2 = futurama.getEpisoder().get(1);

        //print out the overridden toString() method in Episode class.
        System.out.printf("%s",ep2.toString());

        System.out.println();
        System.out.println("----------------Oppgave2.4-----------------------------------");
        //oppgave2.4
        //ArrayList variable which holds the episodes of specified sesong number. Here sesong 4 as asked in oppgave2.4.
        //hentEpisoderISesong method is called. The loop inside method runs and returns the correct episodes.
        ArrayList<Episode> seasonEpisodes = futurama.hentEpisoderISesong(4);

        //Now that we have a correct episode list stored in ArrayList, we can loop through the ArrayList and show user in terminal all episodes in the specified sesong with generic info.
        for(int i = 0; i < seasonEpisodes.size(); i++){

            //print out to terminal each episode with generic information.
            System.out.println("season: "+seasonEpisodes.get(i).getSesongNr()+ " episode: "+seasonEpisodes.get(i).getEpisodeNr()+ " Episode_name: \""+seasonEpisodes.get(i).getTitle()+ "\" duration: "+seasonEpisodes.get(i).getSpilletid()+ " min");
        }

        System.out.println();
        System.out.println("----------------Oppgave2.5-----------------------------------");
        //oppgave2.5
        //to get average playtime/spille of all episodes added so far, you run get method for gjennomsnittligSpilletid instance variable in TVSerie class object, futurama.
        System.out.printf("Average playtime after 5 seasons: %.2f min\n",futurama.getGjennomsnittligSpilletid());

        System.out.println();
        System.out.println("----------------Oppgave2.6 and oppgave 2.7-----------------------------------");
        //oppgave2.6 and oppgave 2.7
        //Here we try adding 2 episodes in season 10 and 15. This should not work and show error message
        futurama.leggTilEpisode(new Episode("new episode",110,10,randomTid));
        futurama.leggTilEpisode(new Episode("even newer episode",120,15,randomTid));

        //Here add 2 new episodes at season 6. season 6 is one more highter than current max season number which is 5.
        //adding episodes works now since both episodes are at season 6. Now it is possible to add season 7 if we can want.
        futurama.leggTilEpisode(new Episode("working episode 1",110,6,randomTid));
        futurama.leggTilEpisode(new Episode("working episode 2",120,6,randomTid));

        //Store
       ArrayList<Episode> list = futurama.hentEpisoderISesong(6);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getTitle()+ " season"+list.get(i).getSesongNr());
        }




     //main method end
    }
}