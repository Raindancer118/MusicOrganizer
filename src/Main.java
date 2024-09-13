//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MusicTrack WhatIveDone = new MusicTrack("What I've Done","Linkin Park","Rock","whati'vedone.mp3");
        MusicTrack LetMeEntertainYou = new MusicTrack("Let me Entertain you","Robbie Williams","Rock","letmeentertainyou.mp3");
        MusicTrack SuperNakler = new MusicTrack("Supernakler","E1mo","Beat","supernakler.mp3");
        MusicTrack SuperNakler1 = new MusicTrack("Supernakler","E1mo","Beat","supernakler.mp3");
        MusicTrack SuperNakler2 = new MusicTrack("Supernakler","E1mo","Beat","supernakler.mp3");
        MusicTrack SuperNakler3 = new MusicTrack("Supernakler","E1mo","Beat","supernakler.mp3");
        MusicTrack SuperNakler4 = new MusicTrack("Supernakler","E1mo","Beat","supernakler.mp3");
        String filename;
        filename = WhatIveDone.getFilename();
        System.out.println(filename);

        MusicOrganizer organizer = new MusicOrganizer("Uni");
        organizer.addTrack(WhatIveDone);
        organizer.addTrack(LetMeEntertainYou);
        organizer.addTrack(SuperNakler);
        organizer.printLibrary();
        organizer.searchGenre("Rock");
        organizer.searchGenre("Soul");
        organizer.getFilename("Supernakler");
        organizer.removeGenre("Beat");
        organizer.printLibrary();
        organizer.removeTrackByTitle("Supernakler");
        organizer.removeTrackByTitle("Let me Entertain You");
    }
}