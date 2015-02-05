package sk.viawebtour.www.service;

import java.util.List;

import sk.viawebtour.www.domain.Area;
import sk.viawebtour.www.domain.Country;
import sk.viawebtour.www.domain.Resort;

public interface DestinaceService {

    Boolean save();

	List<Country> getList();

	List<Area> getAreaListByCountry(Integer countryId);

	List<Resort> getResortListByAreaid(Integer areaid);

}
