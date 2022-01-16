package io.shubhamcodes.coronavirustracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.shubhamcodes.coronavirustracker.models.LocationStats;
import io.shubhamcodes.coronavirustracker.services.CoronaVirusDataService;

@Controller
public class HomeController {
@Autowired
CoronaVirusDataService coronaVirusDataService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<LocationStats> allStats = coronaVirusDataService.getAllStats();
		int totalReportedCases=allStats.stream().mapToInt(stat-> stat.getLatestTotalCases()).sum();
		model.addAttribute("locationStats",allStats);
		model.addAttribute("totalReportedCases",totalReportedCases);
		return"home";
	}
}
