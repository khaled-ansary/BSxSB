/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSxSB.Controllers;

import DAO.StudentDAO;
import java.lang.annotation.Annotation;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
/**
 *
 * @author lun
 */
@Controller
public class AdminController {
    
     @RequestMapping(value="/admin",method=RequestMethod.GET)
    public String adminPage(Model model){
    
      return "admin";
      
}
}
