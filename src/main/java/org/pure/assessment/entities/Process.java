package org.pure.assessment.entities;

import org.pure.assessment.library.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Process extends BaseEntity {
	@Column(name ="process_name")
	private String name;
	
	public Process(Long id, String name, String code, String description, ProcessArea area) {
		super(id);
		this.name = name;
		this.code = code;
		this.description = description;
		this.area = area;
	}

	@Column(name = "process_code")
	private String code;
	
	@Column(name = "process_description")
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity = ProcessArea.class)
	@JoinColumn(nullable = false, name = "area_id")
	private ProcessArea area;
}
