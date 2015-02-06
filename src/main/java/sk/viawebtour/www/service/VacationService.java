package sk.viawebtour.www.service;

import java.util.List;

import sk.viawebtour.www.domain.User;
import sk.viawebtour.www.domain.Vacation;
import sk.viawebtour.www.domain.VacationForm;

public interface VacationService {

	Vacation save(Vacation user);

	Vacation getLatestVacationByUserid(Integer userid);

	List<VacationForm> getLatestVacationsByUserid(User user);

}
