/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSxSB.Controllers;

import DAO.StudentDAO;
import DAO.SchoolDAO;
import DAO.ScheduleBlockDAO;
import Mapping.POJO.Scheduleblocks;
import Mapping.POJO.Schools;
import Mapping.POJO.Students;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
import java.util.logging.*;
/**
 *
 * @author lun
 */
@Controller
public class AdminController {
    static final Logger logger = Logger.getLogger(AdminController.class.getName());

    @RequestMapping(value="/admin",method=RequestMethod.GET)
    public String adminPage(Model model){
        try {
            //Initialize the file that the logger writes to.
            Handler handler = new FileHandler("./ViewSchools.log");
            logger.addHandler(handler);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        logger.info("Admin Viewing List of Schools.");
        SchoolDAO schoolDAO = new SchoolDAO();
        ScheduleBlockDAO scheduleBlockDAO = new ScheduleBlockDAO();
        List<Schools> schools = schoolDAO.allSchools();
        logger.info("Returning list of schools..." + schools.size() + " schools found.");
        for(Schools school: schools){
            List<Scheduleblocks> scheduleBlocks = scheduleBlockDAO.getSchoolsScheduleBlocks(school.getSchoolid());
            String SB2Strings = "";
            for(Scheduleblocks sb : scheduleBlocks){
                SB2Strings += sb.toString();
            }
            school.setScheduleblocks(SB2Strings);
        }
        model.addAttribute("school", schools);
        logger.info("Schools successfully added to model.");
        return "admin";
    }

    @RequestMapping(value="/adminaddschool",method=RequestMethod.GET)
    public String addSchool(Model model){    
      return "adminaddschool";     
}
    
    @RequestMapping(value="/adminmanageaccounts",method=RequestMethod.GET)
    public String manageAccounts(Model model){    
        List<Students> allStudents= StudentDAO.allStudent();
      model.addAttribute("allstudents",allStudents);
      return "adminmanageaccounts";     
}
    
    @RequestMapping(value="/adminmanagerequests",method=RequestMethod.GET)
    public String manageRequests(Model model){ 
       List<Students> accountrequests= StudentDAO.getAccountRequests();
       model.addAttribute("accountrequests",accountrequests);
      return "adminmanagerequests";     
}

}
