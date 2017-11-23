package lab.phb.tokobukuapp.controller;

import lab.phb.tokobukuapp.repo.TokobukuRepo;
import lab.phb.tokobukuapp.entity.Tokobuku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;

@Controller
public class WebController {
    
    @Autowired
    private TokobukuRepo tkbukuRepo;
	
    @RequestMapping("/daftar-tokobuku")
    public void daftarTokobuku(Model model) {
        model.addAttribute("daftarTokobuku", 
                tkbukuRepo.findAll());
    }

    @RequestMapping("/tambah-data")
    public void tambahData(
    	@ModelAttribute("tkbuku") Tokobuku tkbuku,
    	BindingResult result) {}

    @RequestMapping(value = "/tambah-data",
    	method = RequestMethod.POST) 
    public String simpanDataBaru(
    		@ModelAttribute("tkbuku") Tokobuku tkbuku,
    		BindingResult result) {
    	System.out.println(tkbuku.getId());
    	tkbukuRepo.save(tkbuku);

    	return "redirect:/daftar-tokobuku";
    }

    @RequestMapping("/edit")
    public void getEditForm(
    		@RequestParam("id") String id, 
    		Model model) {
    	Tokobuku result = tkbukuRepo.findOne(id);
    	model.addAttribute("tkbuku", result);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String simpanEditData(
    		@ModelAttribute("tkbuku") Tokobuku tkbuku,
    		BindingResult result) {
    	System.out.println("id : " + tkbuku.getId());
    	tkbukuRepo.save(tkbuku);
    	return "redirect:/daftar-tokobuku";
    }
    
    @RequestMapping("/hapus")
    public String hapusData(@RequestParam("id") String id) {
        tkbukuRepo.delete(id);
        return "redirect:/daftar-tokobuku";
    }
    
}
