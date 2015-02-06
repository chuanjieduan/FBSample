package sk.viawebtour.www.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import sk.viawebtour.www.domain.Area;
import sk.viawebtour.www.domain.Country;
import sk.viawebtour.www.domain.Resort;
import sk.viawebtour.www.domain.User;
import sk.viawebtour.www.domain.Vacation;
import sk.viawebtour.www.domain.VacationForm;
import sk.viawebtour.www.repository.VacationRepository;
import sk.viawebtour.www.util.TimeUtil;

@Service
@Validated
public class VacationServiceImpl implements VacationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VacationServiceImpl.class);
    private final VacationRepository repository;
    private final DestinaceService   destinaceService;

    @Inject
    public VacationServiceImpl(final VacationRepository repository, DestinaceService destinaceService) {
        this.repository = repository;
        this.destinaceService = destinaceService;
    }

    @Override
    @Transactional
    public Vacation save(@NotNull @Valid final Vacation vacation) {
        LOGGER.debug("Creating {}", vacation);
        return repository.save(vacation);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Vacation getLatestVacationByUserid(Integer userid) {
    	return repository.findByUserid(userid);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<VacationForm> getLatestVacationsByUserid(User user) {
    	List<VacationForm> form = new ArrayList<>();
    	List<Vacation> vacations = repository.getListByUserid(user.getId());
    	if (vacations.size() == 0) {
    		vacations = repository.getListByUseridAndEnddate(user.getId());
    	}
    	try {
    		for (Vacation vacation : vacations) {
        		Resort  resort  = destinaceService.getResortById (vacation.getResortid ());
        		Area    area    = destinaceService.getAreaById   (resort  .getAreaid   ());
        		Country country = destinaceService.getCountryById(area    .getCountryid());
        		
        		StringBuilder messagebuffer = new StringBuilder(user.getName());
        		int sdays = TimeUtil.daysBetween(new Date(), vacation.getStartdate());
        		int edays = TimeUtil.daysBetween(new Date(), vacation.getEnddate());
        		if (sdays > 0) {
        			messagebuffer.append(" will travel to ");
        		} else if (sdays < 0 && edays > 0) {
        			messagebuffer.append(" is visiting to ");
        		} else {
        			messagebuffer.append(" was travel to ");
        		}
        		messagebuffer.append(country.getName())
        					 .append(" (")
        					 .append(area.getName())
        					 .append(", ")
        					 .append(resort.getName())
        					 .append(") ");
        		if (sdays > 0) {
        			messagebuffer.append("in ").append(sdays).append(" days.");
        		} else if (sdays < 0 && edays > 0) {
        			messagebuffer.append("for ").append(edays).append(" more days.");
        		} else {
        			messagebuffer.append(Math.abs(edays)).append(" days ago.");
        		}
        		form.add(new VacationForm(messagebuffer.toString(), resort.getLink()));
        	}
    	} catch (Exception e) {
    		LOGGER.error(e.getMessage(), e);
    	}
    	return form;
    }

}
