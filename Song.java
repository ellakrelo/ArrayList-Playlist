public class Song
{
    private String title;
    private String artist;
    private String genre;
    private double length;
    private boolean instrumental;

    public Song(String t, String a, String g, double l, boolean i)
    {
        title = t;
        artist = a;
        genre = g;
        length = l;
        instrumental = i;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getArtist()
    {
        return artist;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public double getLength()
    {
        return length;
    }

    public void setLength(double length)
    {
        this.length = length;
    }

    public boolean getInstrumental()
    {
        return instrumental;
    }

    public void setInstrumental(boolean instrumental)
    {
        this.instrumental = instrumental;
    }
}