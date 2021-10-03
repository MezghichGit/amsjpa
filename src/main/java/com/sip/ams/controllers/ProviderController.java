package com.sip.ams.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sip.ams.entities.Provider;
import com.sip.ams.repositories.ProviderRepository;

import java.util.List;
import javax.validation.Valid;

@Controller
@RequestMapping("/provider/")

public class ProviderController {
	@Autowired
	private final ProviderRepository providerRepository;

	// injection de dépencence + IOC(Inversion Of Control)
	public ProviderController(ProviderRepository providerRepository) {
		this.providerRepository = providerRepository;
	}

	@GetMapping("list")
	public String listProviders(Model model) {
		model.addAttribute("providers", providerRepository.findAll());
		return "provider/listProviders";
	}

}
