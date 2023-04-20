package org.pure.assessment.services;

import java.util.ArrayList;
import java.util.List;


import org.pure.assessment.entities.ProcessArea;
import org.pure.assessment.repos.ProcessAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProcessAreaService {
	
	@Autowired
	private ProcessAreaRepository processAreaRepository;
	List<ProcessArea> _list = new ArrayList<>();
	
	public List<ProcessArea> getList()
	{
		//return this.processAreaRepository.findAll();
		return this._list;
	}
	
	public void addProcessArea(ProcessArea area)
	{
		this._list.add(area);
	}
	
	public boolean removeProcessArea(Long areaId)
	{
		if(areaId == null || areaId < 1) return false;
		
		var areaItem = this._list.stream()
				.filter(aItem -> 
					{
						return aItem.getId() == areaId;
					})
				.findFirst();
		
		if(areaItem.isEmpty() == true) return false;
		
		return this._list.remove(areaItem.get());
	}
}
