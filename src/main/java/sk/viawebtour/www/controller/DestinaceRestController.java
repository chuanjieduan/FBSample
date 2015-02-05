package sk.viawebtour.www.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sk.viawebtour.www.domain.Area;
import sk.viawebtour.www.domain.Resort;
import sk.viawebtour.www.service.DestinaceService;

@RestController
public class DestinaceRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DestinaceRestController.class);
    private final DestinaceService destinaceService;

    @Inject
    public DestinaceRestController(final DestinaceService destinaceService) {
        this.destinaceService = destinaceService;
    }

    @RequestMapping(value = "/destinace/loader.htm", method = RequestMethod.GET)
    public String loadDestinace() {
        LOGGER.debug("Start to load destinace data");
        Boolean success = destinaceService.save();
        return String.format("Load data %s", success.toString());
    }
    
    @RequestMapping(value = "/area/{countryid}", method = RequestMethod.GET)
    public List<Area> listArea(@PathVariable Integer countryid) {
        LOGGER.debug("Received request to list all areas");
        return destinaceService.getAreaListByCountry(countryid);
    }
    
    @RequestMapping(value = "/resort/{areaid}", method = RequestMethod.GET)
    public List<Resort> listResort(@PathVariable Integer areaid) {
        LOGGER.debug("Received request to list all resorts");
        return destinaceService.getResortListByAreaid(areaid);
    }

}
