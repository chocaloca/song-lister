package edu.psu.sweng861;


public class Stands4Obj implements Comparable<Stands4Obj> {

	private int id;
	private String song;
	private String artist;
	private String album;
	
	@Override
	public int compareTo(Stands4Obj o) {
		return this.artist.compareTo(o.artist);
	}
	
	public Stands4Obj(int id, String song, String artist, String album) {
		super();
		this.id = id;
		this.song = song;
		this.artist = artist;
		this.album = album;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	@Override
	public String toString() {
		return "Stands4Obj [id=" + id + ", song=" + song + ", artist=" + artist + ", album=" + album + "]";
	}


	
}
