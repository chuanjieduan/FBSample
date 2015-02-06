package sk.viawebtour.www.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Resort {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(max = 64)
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "areaid", length = 11, nullable = false)
	private Integer areaid;
	
	@Size(max = 255)
	@Column(name = "link", nullable = false)
	private String link;

	@Column(name = "createtime", nullable = false)
	private Date createtime = new Date();

	public Resort() {
	}
	
	public Resort(String name, Integer areaid, String link) {
		this.name = name;
		this.areaid = areaid;
		this.link = link;
	}

	public Resort(Integer id, String name, Integer areaid, Date createtime) {
		this.id = id;
		this.name = name;
		this.areaid = areaid;
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

	public Integer getAreaid() {
		return areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
