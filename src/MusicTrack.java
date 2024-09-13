public class MusicTrack {

    String title;
    String artist;
    String genre;
    String filename;
    public MusicTrack(String title, String artist, String genre, String filename) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.filename = filename;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }


}
