package edu.psu.sweng861;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		if( s.length() == 2 ) {
			return "not-found";
		} else {
			List<Stands4Obj> results = helper.parseStands4Json(s);
			Collections.sort(results);
			model.addAttribute("objs", results);
			return "result";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
