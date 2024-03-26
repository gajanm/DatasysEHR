package com.cpa.ehr.backend.dao.system;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cpa.ehr.backend.dao.system.constants.EncounterHistoryConstants;
import com.cpa.ehr.backend.dao.system.entities.EncounterHistory;
import javax.transaction.Transactional;
import org.springframework.data.repository.query.Param;

@Repository
@Transactional
public interface EncounterHistoryRepository extends JpaRepository<EncounterHistory,Long> {
	
	//Repository for getting all data..
	@Query(value = EncounterHistoryConstants.FIND_ALL, nativeQuery = true)
	List<Object> getAllEncountersByEncounterId(@Param("encounterId") Long encounterId);
	
	@Query(value = EncounterHistoryConstants.FIND_ALL, nativeQuery = true)
	List<EncounterHistory> getEncountersByEncounterId(@Param("encounterId") Long encounterId);
	

}	
