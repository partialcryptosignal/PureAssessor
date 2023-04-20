package org.pure.assessment.entities;

import java.util.Set;

import org.pure.assessment.library.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "process_area", indexes = @Index(columnList = "area_code"))
public class ProcessArea extends BaseEntity{

	
	@Column(name = "area_name")
	private String name;
	
	@Column(name = "area_code")
	private String abbrevationCode;
	
	@OneToMany(targetEntity = Process.class,mappedBy = "area",fetch = FetchType.LAZY)
	private Set<Process> processes;
	
	public String getName() {
		return name; 
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbrevationCode() {
		return abbrevationCode;
	}

	public void setAbbrevationCode(String abbrevationCode) {
		this.abbrevationCode = abbrevationCode;
	}

	public ProcessArea(Long Id, String name, String abbrevationCode) {
		super(Id);
		this.name = name;
		this.abbrevationCode = abbrevationCode;
	}
}
