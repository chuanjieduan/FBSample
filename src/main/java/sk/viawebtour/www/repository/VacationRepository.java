package sk.viawebtour.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sk.viawebtour.www.domain.Vacation;

public interface VacationRepository extends JpaRepository<Vacation, Integer> {
	@Query(value="select v.* from vacation v where v.userid=?1 and v.startdate > NOW() order by v.startdate asc limit 1", nativeQuery=true)
	Vacation findByUserid(Integer userid);

	@Query(value="select v.* from vacation v where v.userid=?1 and v.enddate > NOW() order by v.startdate limit 1", nativeQuery=true)
	List<Vacation> getListByUserid(Integer userid);
	
	@Query(value="select v.* from vacation v where v.userid=?1 and v.enddate < NOW() order by v.enddate desc limit 1", nativeQuery=true)
	List<Vacation> getListByUseridAndEnddate(Integer userid);
}
