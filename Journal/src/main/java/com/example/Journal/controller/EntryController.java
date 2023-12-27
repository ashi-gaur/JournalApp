package com.example.Journal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.example.Journal.entity.Entry;
import com.example.Journal.entity.MyEntry;
import com.example.Journal.service.EntryService;
import com.example.Journal.service.MyEntryService;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EntryController {
	@Autowired
	private EntryService service;

	@Autowired
	private MyEntryService myEntryService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	// @GetMapping("/new_entry")
	// public String entryRegister() {
	// 	return "register";
	// }
	@GetMapping("/new_entry")
    public String entryRegister(Model model) {
        // Add the 'entry' attribute to the model
        model.addAttribute("entry", new Entry());
        return "register";
    }

// 	@PostMapping("/save")
// public String entryRegister(@ModelAttribute Entry entry) {
//     // Your logic to save the entry
//     service.save(entry);
//     return "redirect:/my_entries";
// }

	@GetMapping("/my_entries")
	public ModelAndView getAllEntry() {
		List<Entry> list = service.getAllEntry();
		// ModelAndView m=new ModelAndView();
		// m.setViewName("bookList");
		// m.addObject("book",list);
		return new ModelAndView("entry", "entry", list);
	}

	@PostMapping("/save")
	public String addEntry(@ModelAttribute Entry e) {
		service.save(e);
		return "redirect:/my_entries"; // Corrected URL
	}

	@GetMapping("/favourites")
	public String getFavourites(Model model) {
		List<MyEntry> list = myEntryService.getAllEntry();
		model.addAttribute("myEntries", list);
		return "favourites";
	}

	// @RequestMapping("editEntry/{id}")
	// public String editEntry(@PathVariable("id") int id, Model model) {
	// 	Entry e = service.getEntryById(id);
	// 	model.addAttribute("myEnteries", e);
	// 	return "entryEdit";
	// }


	@RequestMapping("editEntry/{id}")
public String editEntry(@PathVariable("id") String id, Model model) {
    int entryId = Integer.parseInt(id);
    Entry e = service.getEntryById(entryId);
    model.addAttribute("myEnteries", e);
    return "entryEdit";
}


	@RequestMapping("/deleteEntry/{id}")
	public String deleteEntry(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/my_entries"; // Corrected URL
	}

}
