package sk.viawebtour.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sk.viawebtour.www.domain.Resort;

public interface ResortRepository extends JpaRepository<Resort, Integer> {
	List<Resort> findByAreaid(Integer areaid);
}
