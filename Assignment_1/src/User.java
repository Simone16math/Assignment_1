import java.util.ArrayList;

class User{
    // Attributes
    private String username;
    private ArrayList<Playlist> playlists;


    public User(String username) {
        // Constructor for User
        this.username = username;
        this.playlists = new ArrayList<>();
    }

    public Playlist createPlaylist(String name, String type){
        // Creates a playlist of a specified type (Pop, Rock, Jazz)
        Playlist playlist;

        // Determines the type of playlist to create based on user input
        if (type.equalsIgnoreCase("Pop")){
            playlist = new PopPlaylist(name);
        } else if (type.equalsIgnoreCase("Rock")){
            playlist = new RockPlaylist(name);
        } else if (type.equalsIgnoreCase("Jazz")){
            playlist = new JazzPlaylist(name);
        } else {
            System.out.println("Invalid playlist type. Please choose Pop, Rock, or Jazz. " +
                    "\n Playlist creation failed and no further playlist operations will work as intended.");
            return null;
        }

        // Adds the new playlist to the user's list of playlists
        if (playlists == null) {
            playlists = new ArrayList<>();
        }
        playlists.add(playlist);

        return playlist;
    }

    public void deletePlaylist(Playlist playlist) {
        // Deletes a specified playlist
        if (playlist == null) {
            System.out.println("Playlist cannot be null. Please create a playlist appropriately.");
            return;
        }
        if (playlists.contains(playlist)) {
            playlists.remove(playlist);
            System.out.println("Playlist deleted: " + playlist.name);
        } else {
            System.out.println("Playlist not found.");
        }
    }

    public void addSongToPlaylist(Playlist playlist, Song song) {
        // Adds a song to a specified playlist
        if (playlist == null || song == null) {
            System.out.println("Playlist or song cannot be null. \n Please create a playlist and/or a song appropriately.");
            return;
        }
        if (playlists.contains(playlist)) {
            playlist.addSong(song);
            System.out.println(song.getTitle() + " was added to your playlist titled: " + playlist.name);
        } else {
            System.out.println("Playlist not found. Please create the intended playlist first.");
        }
    }

    public void removeSongFromPlaylist(Playlist playlist, Song song) {
        // Removes a song from a specified playlist
        if (playlist == null || song == null) {
            System.out.println("Playlist or song cannot be null. \n Please create a playlist and/or a song appropriately.");
            return;
        }
        if (playlists.contains(playlist)) {
            playlist.removeSong(song);
            System.out.println(song.getTitle() + " was removed from your playlist titled: " + playlist.name);
        } else {
            System.out.println("Playlist not found.");
        }
    }

    public void songRecommendation(String genre){
        // Recommends songs based on the specified genre
        // need to add duration of the songs
        System.out.println("Recommended " + genre + " songs:");
        if (genre.equalsIgnoreCase("Pop")){
            System.out.println("- Blinding Lights by The Weeknd");
            System.out.println("- Watermelon Sugar by Harry Styles");
            System.out.println("- Levitating by Dua Lipa");
        } else if (genre.equalsIgnoreCase("Rock")){
            System.out.println("- Bohemian Rhapsody by Queen");
            System.out.println("- Stairway to Heaven by Led Zeppelin");
            System.out.println("- Hotel California by Eagles");
        } else if (genre.equalsIgnoreCase("Jazz")){
            System.out.println("- So What by Miles Davis");
            System.out.println("- Take Five by Dave Brubeck");
            System.out.println("- My Favorite Things by John Coltrane");
        } else {
            System.out.println("Genre not recognized. Please choose Pop, Rock, or Jazz.");
        }
    }
}
