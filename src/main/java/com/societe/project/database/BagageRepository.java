package com.societe.project.database;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.societe.project.database.base.BaseCRUDRepository;
import com.societe.project.models.Bagage;
@Repository
public interface BagageRepository extends BaseCRUDRepository<Bagage> {

	List<Bagage> findByVolume(Double volume );
}
