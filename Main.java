import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main 
{
    static ArrayList<Song> playlist = new ArrayList<Song>();
    static String[] genres = {"pop", "alternative", "hip-hop", "rock", "classical", "jazz", "indie", "punk rock", "mongolian throat singing", "ambiant"};
    static Scanner userStringInput = new Scanner(System.in);
    static Scanner userIntInput = new Scanner(System.in);
    static String playlistName = "";
    static int inputNumber = 0;
    //hi

    public static void main(String[] args) 
    {
        MasterList.fillPlaylist();
        Collections.shuffle(MasterList.masterPlaylist);
        createPlaylist();
    }

    static public void createPlaylist()
    {
        System.out.println("Welcome to The ArrayList Playlist Generator! What would you like the title of your playlist to be?");
        playlistName = userStringInput.nextLine();
        
        System.out.println("Awesome! Your playlist is called " + playlistName);
        addSongs();
    }

    static public void addSongs()
    {
        System.out.println("What genre of songs would you like to add to your playlist?");

        int choices = 0;

        for(int i = 0; i < genres.length; i++)
        {
            choices++;
            System.out.println("(" + choices + ") " + genres[i]);
        }

        int genreNumber = userIntInput.nextInt() - 1;

        int numberOfSongs = 0;
        if(genreNumber < genres.length)
        {
            for(int i = 0; i < MasterList.masterPlaylist.size(); i++)
            {
                if(MasterList.masterPlaylist.get(i).getGenre().equals(genres[genreNumber]))
                {
                    numberOfSongs++;
                }
            }

            
            System.out.println("How many songs in this genre would you like to have in your playlist? (1-" + numberOfSongs + ")");
            int playlistLength = userIntInput.nextInt() + playlist.size();
            
            for(int i = 0; i < MasterList.masterPlaylist.size(); i++)
            {
                if(MasterList.masterPlaylist.get(i).getGenre().equals(genres[genreNumber]))
                {
                    playlist.add(MasterList.masterPlaylist.get(i));
                }
                if (playlist.size() == playlistLength)
                {
                    break;
                }
            }

            System.out.println("Would you like to remove any songs of a certain length");
            System.out.println("(1) Less than 3 minutes \n(2) Greater than 5 minutes \n(3) I don't care. Give me them all!");
            inputNumber = userIntInput.nextInt();

            if(inputNumber == 1)
            {
                for(int i = 0; i < playlist.size(); i++)
                {
                    if(playlist.get(i).getLength() < 3)
                    {
                        playlist.remove(playlist.get(i));
                    }

                    // if(playlist.size() != playlistLength)
                    // {
                    //     for(int j = 0; j < MasterList.masterPlaylist.size(); j++)
                    //     {
                    //         if(MasterList.masterPlaylist.get(j).getGenre().equals(genres[genreNumber]))
                    //         {
                    //             if(MasterList.masterPlaylist.get(j).equals(playlist.get(j)))
                    //             {
                    //             }
                    //             else
                    //             {
                    //                 playlist.add(MasterList.masterPlaylist.get(j));
                    //             }
                    //         }
                    //         if (playlist.size() == playlistLength)
                    //         {
                    //             break;
                    //         }
                    //     }
                    // }
                }
            }
            else if(inputNumber == 2)
            {
                for(int i = 0; i < playlist.size(); i++)
                {
                    if(playlist.get(i).getLength() > 5)
                    {
                        playlist.remove(playlist.get(i));

                        // if(playlist.size() != playlistLength)
                        // {
                        //     for(int k = 0; k < MasterList.masterPlaylist.size(); k++)
                        //     {
                        //         if(MasterList.masterPlaylist.get(k).getGenre().equals(genres[genreNumber]))
                        //         {
                        //             if(MasterList.masterPlaylist.get(k).equals(playlist.get(k)))
                        //             {
                        //             }
                        //             else
                        //             {
                        //                 playlist.add(MasterList.masterPlaylist.get(k));
                        //             }
                        //         }
                        //         if (playlist.size() == playlistLength)
                        //         {
                        //             break;
                        //         }
                        //     }
                        // }
                    }
                }
            }
            else
            {
            }
        }
        else 
        {
            System.out.println("I'm sorry, that's not an option. Please try again");
            addSongs();
        }
        editPlaylist();
    }

    static public void editPlaylist()
    {
        System.out.println("Here is your playlist");
        System.out.println(playlistName);
        printPlaylist();
        System.out.println("Would you like to remove any songs?\n(1) Yes\n(2)No");
        inputNumber = userIntInput.nextInt();
        if(inputNumber == 1)
        {
            removeSongs();
        }

        System.out.println("Would you like to add another genre?\n(1) Yes\n(2) No");
        inputNumber = userIntInput.nextInt();

        if(inputNumber == 1)
        {
            addSongs();
        }
        System.out.println("Would you like to shuffle your playlist?\n(1) Yes\n(2) No");
        inputNumber = userIntInput.nextInt();

        if(inputNumber == 1)
        {
            Collections.shuffle(playlist);
        }
            
        System.out.println("Here is your final playlist:");
        System.out.println("");
        System.out.println(playlistName);
        printPlaylist();
    }


    static public void printPlaylist()
    {
        int number = 0;
        for(int i = 0; i < playlist.size(); i++)
        {
            number++;
            System.out.println("(" + (number) + ")" + playlist.get(i).getTitle() + "   " + playlist.get(i).getArtist() + "       " + playlist.get(i).getLength());
        }
        System.out.println("");
    }

    static public void removeSongs()
    {
        printPlaylist();
        String removeNumbers = "";
        System.out.println("Please enter the song numbers you would like to remove (each separated by a space)");
        removeNumbers = userStringInput.nextLine();

        String[] removeStringArray = removeNumbers.split(" ");
        int[] removeNumbersArray = Arrays.stream(removeStringArray).mapToInt(Integer :: parseInt).toArray();

        int subtractNumber = 0;
        for(int i = 0; i < removeNumbersArray.length; i++)
        {  
            subtractNumber = i;
            subtractNumber++;
            removeNumbersArray[i] = removeNumbersArray[i] - subtractNumber;     
            playlist.remove(playlist.get(removeNumbersArray[i]));
        }

        printPlaylist();

        System.out.println("Would you like to remove any more songs? \n(1) Yes\n(2)No");
        inputNumber = userIntInput.nextInt();
        if(inputNumber == 1)
        {
            removeSongs();
        }
    }
}
