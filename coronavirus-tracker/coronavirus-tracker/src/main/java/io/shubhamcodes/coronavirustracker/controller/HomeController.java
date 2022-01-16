package io.shubhamcodes.coronavirustracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.shubhamcodes.coronavirustracker.services.CoronaVirusDataService;

@Controller
public class HomeController {
@Autowired
CoronaVirusDataService coronaVirusDataService;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("locationStats",coronaVirusDataService.getAllStats());
		return"home";
	}
}
