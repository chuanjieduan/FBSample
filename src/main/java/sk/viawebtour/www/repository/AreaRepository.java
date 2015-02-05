package sk.viawebtour.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sk.viawebtour.www.domain.Area;

public interface AreaRepository extends JpaRepository<Area, Integer> {
	List<Area> findByCountryid(Integer countryid);
}
