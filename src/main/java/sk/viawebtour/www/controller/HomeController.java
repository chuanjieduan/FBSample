package sk.viawebtour.www.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sk.viawebtour.www.domain.User;
import sk.viawebtour.www.domain.Vacation;
import sk.viawebtour.www.service.DestinaceService;
import sk.viawebtour.www.service.UserService;
import sk.viawebtour.www.service.VacationService;

@Controller
public class HomeController {

    private final UserService userService;
    private final VacationService vacationService;
    private final DestinaceService destinaceService;

    @Inject
    public HomeController(final UserService userService, final DestinaceService destinaceService,
    		 VacationService vacationService) {
        this.userService = userService;
        this.vacationService = vacationService;
        this.destinaceService = destinaceService;
    }

    @RequestMapping("/countdown.html")
    public ModelAndView getCountdownView() {
        ModelMap model = new ModelMap();
        User     user     = userService.getUserByName("Daniel");
        Vacation vacation = vacationService.getLatestVacationByUserid(user.getId());
        
        model.addAttribute("user",  	user);
        model.addAttribute("users",  	userService.getList());
        model.addAttribute("countries", destinaceService.getList());
        model.addAttribute("vacations", vacationService.getLatestVacationsByUserid(user));
        
        if (vacation != null) {
        	model.addAttribute("resort",    destinaceService.getResortById(vacation.getResortid()));
        	model.addAttribute("vacation",  vacation);
        }
        return new ModelAndView("countdown", model);
    }

}
