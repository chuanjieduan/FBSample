package sk.viawebtour.www.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sk.viawebtour.www.domain.Vacation;
import sk.viawebtour.www.service.VacationService;

@Controller
public class VacationController {

    private final VacationService vacationService;

    @Inject
    public VacationController(final VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @RequestMapping("/addVacation.html")
    public String addVacation(Vacation vacation) {
        vacationService.save(vacation);
        return "redirect:/countdown.html";
    }

}
