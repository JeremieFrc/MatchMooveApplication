package com.societe.project.database;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.societe.project.database.base.BaseCRUDRepository;
import com.societe.project.models.Point;
@Repository
public interface PointRepository extends BaseCRUDRepository<Point> {
	 List<Point>      findByLongitudeAndAltitude(Double longitude ,Double altitude );
}
