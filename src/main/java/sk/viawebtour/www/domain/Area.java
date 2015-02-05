package sk.viawebtour.www.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Area {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(max = 64)
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "countryid", length = 11, nullable = false)
	private Integer countryid;

	@Column(name = "createtime", nullable = false)
	private Date createtime = new Date();
	
	public Area() {
	}
	
	public Area(String name, Integer countryid) {
		this.name = name;
		this.countryid = countryid;
	}

	public Area(Integer id, String name, Integer countryid, Date createtime) {
		this.id = id;
		this.name = name;
		this.countryid = countryid;
		this.createtime = createtime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

}
