package com.cpa.ehr.backend.dao.system;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpa.ehr.backend.dao.system.constants.EncQuestionOptionConstants;
import com.cpa.ehr.backend.dao.system.constants.EncounterQuestionGroupConstants;
import com.cpa.ehr.backend.dao.system.entities.EncounterQuestionGroup;


@Repository
@Transactional
public interface EncounterQuestionGroupRepository extends JpaRepository<EncounterQuestionGroup, Long> {

	 @Modifying
		@Query(value = EncounterQuestionGroupConstants.DELETE_BY_ENCID, nativeQuery = true)
		void deleteByEncounterIdAndSysType(@Param("encounterId") Long encounterId,@Param("sysType") String sysType);
}
