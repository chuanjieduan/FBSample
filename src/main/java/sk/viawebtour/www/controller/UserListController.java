package sk.viawebtour.www.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sk.viawebtour.www.service.DestinaceService;
import sk.viawebtour.www.service.UserService;

@Controller
public class UserListController {

    private final UserService userService;
    private final DestinaceService destinaceService;

    @Inject
    public UserListController(final UserService userService, final DestinaceService destinaceService) {
        this.userService = userService;
        this.destinaceService = destinaceService;
    }

    @RequestMapping("/countdown.html")
    public ModelAndView getCountdownView() {
        ModelMap model = new ModelMap();
        model.addAttribute("user",  	"Daniel");
        model.addAttribute("countries", destinaceService.getList());
        model.addAttribute("users", 	userService   .getList());
        return new ModelAndView("countdown", model);
    }

}
