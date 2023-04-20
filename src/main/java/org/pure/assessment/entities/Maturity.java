package org.pure.assessment.entities;

import java.util.Set;

import org.pure.assessment.library.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Maturity extends BaseEntity{
	
	public Maturity(Long id, String name, int minimumBoundry, int maximumBoundry) {
		super(id);
		this.name = name;
		this.minimumBoundry = minimumBoundry;
		this.maximumBoundry = maximumBoundry;
	}

	@Column(name = "maturity_name")
	private String name;
	
	@Column(name = "maturity_minimum")
	private int minimumBoundry;
	
	@Column(name = "maturity_maximum")
	private int maximumBoundry;
	
	@OneToMany(targetEntity = MaturityLevel.class, mappedBy = "maturity", fetch = FetchType.EAGER )
	private Set<MaturityLevel> levels;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinimumBoundry() {
		return minimumBoundry;
	}

	public void setMinimumBoundry(int minimumBoundry) {
		this.minimumBoundry = minimumBoundry;
	}

	public int getMaximumBoundry() {
		return maximumBoundry;
	}

	public void setMaximumBoundry(int maximumBoundry) {
		this.maximumBoundry = maximumBoundry;
	}

	public Set<MaturityLevel> getLevels() {
		return levels;
	}

	public void setLevels(Set<MaturityLevel> levels) {
		this.levels = levels;
	}

	
}
