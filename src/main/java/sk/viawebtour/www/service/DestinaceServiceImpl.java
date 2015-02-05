package sk.viawebtour.www.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk.viawebtour.www.controller.DestinaceRestController;
import sk.viawebtour.www.domain.Area;
import sk.viawebtour.www.domain.Country;
import sk.viawebtour.www.domain.Resort;
import sk.viawebtour.www.repository.AreaRepository;
import sk.viawebtour.www.repository.CountryRepository;
import sk.viawebtour.www.repository.ResortRepository;

@Service
public class DestinaceServiceImpl implements DestinaceService {

    private final CountryRepository countryRepository;
    private final AreaRepository 	areaRepository;
    private final ResortRepository 	resortRepository;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DestinaceRestController.class);

    @Inject
    public DestinaceServiceImpl(final CountryRepository countryRepository, final AreaRepository areaRepository,
    		final ResortRepository resortRepository) {
        this.countryRepository = countryRepository;
        this.areaRepository    = areaRepository;
        this.resortRepository  = resortRepository;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Country> getList() {
        LOGGER.debug("Retrieving the list of all countries");
        return countryRepository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Area> getAreaListByCountry(Integer countryid) {
        LOGGER.debug("Retrieving the list of all areas");
        return areaRepository.findByCountryid(countryid);
    }
    
    @Override
    @Transactional(readOnly = true)
	public List<Resort> getResortListByAreaid(Integer areaid) {
    	LOGGER.debug("Retrieving the list of all resorts");
        return resortRepository.findByAreaid(areaid);
	}

	@Override
	public Boolean save() {
		BufferedReader file = null;
		try {
			countryRepository.deleteAll();
			areaRepository.deleteAll();
			resortRepository.deleteAll();
			
			Map<String, Integer> countryIdMap = new HashMap<>();
			Map<String, Integer> areaIdMap    = new HashMap<>();
			
			file = new BufferedReader(new FileReader(getConfigFile("Destinace.txt"))) ;
			String line = null;
			while ((line = file.readLine()) != null) {
				String[] columns = line.toLowerCase().split("\t");
				if (columns.length != 4) {
					continue;
				}
				String countryName = columns[0];
				String areaName	   = columns[1];
				String resortName  = columns[2];
				String link        = columns[3];
				
				if (!countryIdMap.containsKey(countryName)) {
					Country country = countryRepository.save(new Country(countryName));
					countryIdMap.put(countryName, country.getId());
				}
				Integer countryId = countryIdMap.get(countryName);
				
				if (!areaIdMap.containsKey(areaName)) {
					Area area = areaRepository.save(new Area(areaName, countryId));
					areaIdMap.put(areaName, area.getId());
				}
				Integer areaId = areaIdMap.get(areaName);
				
				resortRepository.save(new Resort(resortName, areaId, link));
			}
			
			return true;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return false;
		} finally {
			try {
				if (file != null) file.close();
			} catch (IOException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
	}
	
	private static File getConfigFile(String fileName) throws Exception {
		File file;
		file = new File(fileName);
		if (!file.exists()) {
			file = new File("config/" + fileName);
			if (!file.exists()) {
				file = new File("conf/" + fileName);
				if (!file.exists()) {
					URL url = null;
					ClassLoader aClassLoader = getCurrentThreadClassLoader();
					if (aClassLoader != null) {
						url = aClassLoader.getResource(fileName);
					}
					if (url != null) {
						file = new File(url.getFile());
					} else {
						aClassLoader = getThisClassLoader();
						if (aClassLoader != null) {
							url = aClassLoader.getResource(fileName);
						} 
						if (aClassLoader != null && url == null) {
							url = aClassLoader.getResource("properties/" + fileName);
						}
						if (url != null) {
							file = new File(url.getFile());
						} else {
							LOGGER.error("reload app.properties");
							throw new Exception("not found config file");
						}
					}
				}
			}
		}
		return file;
	}
	
    private static ClassLoader classLoader;
    static {
        classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = DestinaceServiceImpl.class.getClassLoader();
        } 
    }
    
 

	public static ClassLoader getCurrentThreadClassLoader() {
		return Thread.currentThread().getContextClassLoader();
	}

	public static ClassLoader getThisClassLoader() {
		return DestinaceServiceImpl.class.getClassLoader();
	}

	

}
