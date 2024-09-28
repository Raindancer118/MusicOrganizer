// Ich habe zusätzlich zu den geforderten Methoden einige Kleinigkeiten implementiert,
// die ich in einer fortgeschrittenen Musikbibliothek angebracht fand.

import java.util.ArrayList;

public class MusicOrganizer {

    // Deklaration & Initialisierung der neuen ArrayList "library".
    private ArrayList<MusicTrack> library = new ArrayList<>();
    private String name;

    // Konstruktor für MusicOrganizer-Objekte:
    public MusicOrganizer(String name) {
        this.name = name;
    }

    // Methode zum Hinzufügen von MusicTracks zur Library:
    public void addTrack(MusicTrack track) {
        library.add(track);
    }

    // Methode zum Ausdrucken der Library:
    public void printLibrary() {
        System.out.println("- - - - - - - - - Deine Musikbibliothek: "+name+" - - - - - - - - - - -");
        for (MusicTrack track : library) {
            System.out.println(track.getTitle()+"\nArtist: "+track.getArtist()+"\nGenre: "+track.getGenre()+"\nFilename: "+track.getFilename()+"\n");
        }
    }

    // Methode zur Ausgabe aller Tracks eines Genres:
    public void searchGenre(String genre) {
        boolean found = false;
        System.out.println("- - - - - - - - - - - Search Results for genre '"+genre+"' - - - - - - - - - -");
        for (MusicTrack track : library) {
            if (track.getGenre().equalsIgnoreCase(genre)) {
                System.out.println("'"+track.getTitle()+"'"+" by "+track.getArtist());
                found = true;
            }
        }
        if (!found) {
            System.out.println(" / / /  Genre "+genre+" not found / / /");
        }
        System.out.println();
    }

    // Methode zur Ausgabe eines bestimmten Filenames eines Titels
    public void getFilename(String title) {
        boolean found = false;
        for (MusicTrack track : library) {
            if (found == false) {
                if (track.getTitle().equalsIgnoreCase(title)) {
                    System.out.println("'" + track.getTitle() + "'" + " by " + track.getArtist() + " is saved as file: '" + track.getFilename() + "'");
                    found = true;
                }
            }
        }
        System.out.println();
    }

    // Methode zum Entfernen aller Titel eines bestimmten Genres:
    public void removeGenre(String genre) {
        // Import der Library, damit die for-Schleife funktioniert.
        ArrayList<MusicTrack> toProcess = new ArrayList<>();
        toProcess.addAll(library);
        int counter = 0;
        ArrayList<MusicTrack> removedTracks = new ArrayList<>();
        for (MusicTrack track : toProcess) {
            if (track.getGenre().equalsIgnoreCase(genre)) {
                removedTracks.add(track);
                library.remove(track);
                counter++;
            }
        }
        // System zur Ausgabe der gelöschten Tracks:
        System.out.print(counter+" tracks :");
        for (int i = 0; i < removedTracks.size(); i++) {
            System.out.print(" '"+removedTracks.get(i).getTitle()+"' by "+removedTracks.get(i).getArtist());
            if (i < removedTracks.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" have been removed!");
        System.out.println();
    }


    // NICHT GEFORDERTE METHODEN, die ich aber trotzdem einbauen wollte:
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // Methode, die das Löschen bestimmter Tracks mithilfe des Namens ermöglicht
    public void removeTrack(MusicTrack track) {
        library.remove(track);
    }

    public void removeTrackByTitle(String title) {
        boolean found = false;
        ArrayList<MusicTrack> toProcess = new ArrayList<>();
        toProcess.addAll(library);
        for (MusicTrack track : toProcess) {
            if (track.getTitle().equalsIgnoreCase(title)) {
                library.remove(track);
                found = true;
            }
        }
        if (!found) {
            System.out.println(" / / /  Track '"+title+"' not found / / /");
        }
        else System.out.println("Track '"+title+"' has been removed!");
        System.out.println();
    }

}
