package sk.viawebtour.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sk.viawebtour.www.domain.Vacation;

public interface VacationRepository extends JpaRepository<Vacation, Integer> {
}
