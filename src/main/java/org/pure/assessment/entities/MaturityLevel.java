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
public class MaturityLevel extends BaseEntity {

	public MaturityLevel(Long id, String levelName, String levelCode, String levelDescription, int level,
			Maturity maturity) {
		super(id);
		this.levelName = levelName;
		this.levelCode = levelCode;
		this.levelDescription = levelDescription;
		this.level = level;
		this.maturity = maturity;
	}

	@Column(name = "maruritylevel_name")
	private String levelName;
	
	@Column(name = "maturitylevel_code")
	private String levelCode;
	
	@Column(name = "maturitylevel_description")
	private String levelDescription;
	
	@Column
	private int level;
	
	@ManyToOne(targetEntity = Maturity.class, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "maturity_id")
	private Maturity maturity;

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	public String getLevelDescription() {
		return levelDescription;
	}

	public void setLevelDescription(String levelDescription) {
		this.levelDescription = levelDescription;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Maturity getMaturity() {
		return maturity;
	}

	public void setMaturity(Maturity maturity) {
		this.maturity = maturity;
	}
	
	
}
