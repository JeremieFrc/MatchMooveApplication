package com.societe.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.societe.project.database.BagageRepository;
import com.societe.project.database.PointRepository;
import com.societe.project.database.base.BaseCRUDRepository;
import com.societe.project.models.Point;
import com.societe.project.services.base.BaseService;
@Service
public class PointService extends BaseService<Point> {

	@Autowired
	private PointRepository pointRepository;
	
	@Override
	protected BaseCRUDRepository<Point> getCRUDRepository() {
		
		return pointRepository;
	}

	@Override
	protected List<Point> setItemsByCriterias(Point item, List<Point> result) {
		 if (!item.getAltitude().equals(null)) {
		result = this.pointRepository.findByLongitudeAndAltitude(item.getLongitude(), item.getAltitude());
	}
	return result;
	}

}
