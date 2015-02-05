package sk.viawebtour.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sk.viawebtour.www.domain.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
