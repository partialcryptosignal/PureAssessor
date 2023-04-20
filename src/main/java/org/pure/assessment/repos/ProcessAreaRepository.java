package org.pure.assessment.repos;

import java.util.List;

import org.pure.assessment.entities.ProcessArea;
import org.springframework.data.repository.CrudRepository;

public interface ProcessAreaRepository extends CrudRepository<ProcessArea, Long> {
	List<ProcessArea> findAll();
}
