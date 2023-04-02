package ma.cigma.springsecurity.service.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Emp {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Double salary;
	
	@Basic(fetch = FetchType.LAZY)
	private String fonction;

	public Emp(String name, Double salary, String fonction) {
		super();
		this.name = name;
		this.salary = salary;
		this.fonction = fonction;
	}
}