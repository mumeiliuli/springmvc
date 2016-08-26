package test.spring.main;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.spring.model.Person;

@Controller
@RequestMapping("/validate")
public class ValidateController {

	
	@RequestMapping(value="/test", method = {RequestMethod.GET})
    public String test(Model model){
		List<String> roles = new ArrayList<String>();  
		 roles.add("演员");  
		 roles.add("医生");  
		Person p=new Person();
		p.setName("mm");
		p.setDate(new Date());
		p.setSex(true);
		p.setRoles(roles);
        if(!model.containsAttribute("contentModel")){
            model.addAttribute("contentModel", p);
        }
        List<String> roleList = new ArrayList<String>();  
        roleList.add("演员"); 
        roleList.add("老师");
        roleList.add("医生"); 
        model.asMap().put("roleList", roleList);
        return "validatetest";
    }
    
    @RequestMapping(value="/test", method = {RequestMethod.POST})
    public String test(Model model, @Valid @ModelAttribute("contentModel") Person validateModel, BindingResult result) throws NoSuchAlgorithmException{
        
        if(result.hasErrors())
            return test(model);
        return "validatesuccess";     
    }
}
