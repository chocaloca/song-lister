package edu.psu.sweng861;

import java.util.List;

public interface Helper {

	
	List<Stands4Obj> parseStands4Json(String s) ;
	
	//String returnApiSeeds(String song, String artist);
	String returnStands4(String term);
}
