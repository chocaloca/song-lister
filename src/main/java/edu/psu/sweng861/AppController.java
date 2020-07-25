package edu.psu.sweng861;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {

	@Autowired
	Helper helper;
	
	@RequestMapping(value = "/term", method = RequestMethod.GET)
	public String home(
			Model model, 
			@RequestParam(name = "term", required = true) String term ) {
		System.out.println("home()- term: " + term);
		String s = helper.returnStands4(term);
		System.out.println("home()- s: " + s);
		model.addAttribute("objs", helper.parseStands4Json(s));
		
		return "result";
	}
	
//	@RequestMapping(value = "/apiseeds", method = RequestMethod.GET)
//	public String grabApiSeeds(
//			Model model,
//			@RequestParam(name = "song", required = true) String song,
//			@RequestParam(name = "artist", required = true) String artist) {
//		
//		String s = helper.returnApiSeeds(song, artist);
//		return s;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
