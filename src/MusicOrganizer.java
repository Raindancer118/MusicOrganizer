// Ich habe zusätzlich zu den geforderten Methoden einige Kleinigkeiten implementiert,
// die ich in einer fortgeschrittenen Musikbibliothek angebracht fand.

import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
        String[][] printedLibrary = new String[library.size()][1]; // Initialisiere 2D-Array mit einer Spalte
        for (int i = 0; i < library.size(); i++) { // Schleife sollte bei 0 beginnen
            printedLibrary[i] = new String[1]; // Initialisiere das innere Array mit 1 Element
            printedLibrary[i][0] = "Track " + (i + 1) + ": '" + library.get(i).getTitle() + "' by " + library.get(i).getArtist() + ". Genre: " + library.get(i).getGenre() + ". Saved as: '" + library.get(i).getFilename() + "'.";
        }
        JOptionPane.showMessageDialog(null, printedLibrary, "Your music-library: " + name, JOptionPane.INFORMATION_MESSAGE);
        for (MusicTrack track : library) {
            System.out.println(track.getTitle()+"\nArtist: "+track.getArtist()+"\nGenre: "+track.getGenre()+"\nFilename: "+track.getFilename()+"\n");
        }
    }

    // Methode zur Ausgabe aller Tracks eines Genres:
    public void searchGenre(String genre) {
        boolean found = false;
        for (MusicTrack track : library) {
            if (track.getGenre().equalsIgnoreCase(genre)) {
                JOptionPane.showMessageDialog(null,"'"+track.getTitle()+"'"+" by "+track.getArtist(),"Search results for genre: '"+genre+"'",JOptionPane.PLAIN_MESSAGE);
                found = true;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Genre '"+genre+"' not found","Invalid Genre",JOptionPane.ERROR_MESSAGE);
        }
        System.out.println();
    }

    // Methode zur Ausgabe eines bestimmten Filenames eines Titels
    public void getFilename(String title) {
        boolean found = false;
        for (MusicTrack track : library) {
            if (found == false) {
                if (track.getTitle().equalsIgnoreCase(title)) {
                    JOptionPane.showMessageDialog(null,"'" + track.getTitle() + "'" + " by " + track.getArtist() + " is saved as file: '" + track.getFilename() + "'","Search results for track '"+title+"'",JOptionPane.PLAIN_MESSAGE);
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
                int answer = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete the track '"+track.getTitle()+"'?","Delete Track",JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    removedTracks.add(track);
                    library.remove(track);
                    counter++;
                }
                else JOptionPane.showMessageDialog(null,"'"+track.getTitle()+"' has not been deleted!");
            }
        }
        // System zur Ausgabe der gelöschten Tracks:
        String[][] printedLibrary = new String[removedTracks.size()+1


                ][1]; // Initialisiere 2D-Array mit einer Spalte
        int index = 0;
        for (int i = 0; i < removedTracks.size(); i++) { // Schleife sollte bei 0 beginnen
            printedLibrary[i] = new String[1]; // Initialisiere das innere Array mit 1 Element
            printedLibrary[i][0] = "'"+removedTracks.get(i).getTitle()+"' by "+removedTracks.get(i).getArtist();
            index = i;
        }
        printedLibrary[index+1][0] = "have been removed!";
        JOptionPane.showMessageDialog(null,printedLibrary,counter+" tracks have been removed!",JOptionPane.PLAIN_MESSAGE);
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
        if (library.contains(track)) {
            int answer = JOptionPane.showConfirmDialog(null,"Do you want to proceed to delete the track "+track.getTitle()+"?","Delete Track",JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                library.remove(track);
            }
            else JOptionPane.showMessageDialog(null,"The track "+track.getTitle()+" was not deleted!");
        }
    }

    public void removeTrackByTitle(String title) {
        boolean found = false;
        ArrayList<MusicTrack> toProcess = new ArrayList<>();
        toProcess.addAll(library);
        if (!found) {
            JOptionPane.showMessageDialog(null,
                    "Track "+title+" nicht gefunden.",
                    "Nicht gefunden!",
                    JOptionPane.WARNING_MESSAGE);
        }
        else {
            int pleaseConfirmDeletion = JOptionPane.showConfirmDialog(null,
                    "Sind Sie sicher, dass Sie den Track '" + getTrackByTitle(title).getTitle() + "' von " + getTrackByTitle(title).getArtist() + " löschen wollen?",
                    "Please confirm deletion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (pleaseConfirmDeletion == JOptionPane.YES_OPTION)  {
                for (MusicTrack track : toProcess) {
                    if (track.getTitle().equalsIgnoreCase(title)) {
                        library.remove(track);
                        found = true;
                    }
                }
                System.out.println("Track '"+title+"' has been removed!");
            }
            else JOptionPane.showMessageDialog(null,"Didn't delete track "+getTrackByTitle(title).getTitle()+"!");

        }
        System.out.println();
    }

    public MusicTrack getTrackByTitle(String title) {
        MusicTrack returnTrack = null;
        for (MusicTrack track : library) {
            if (track.getTitle().equalsIgnoreCase(title)) {
                returnTrack = track;
            }
            else JOptionPane.showMessageDialog(null,
                    "Track "+title+" nicht gefunden! Haben Sie die Rechtschreibung überprüft?",
                    "Nicht gefunden!",
                    JOptionPane.WARNING_MESSAGE);
        }
        return returnTrack;
    }

}
