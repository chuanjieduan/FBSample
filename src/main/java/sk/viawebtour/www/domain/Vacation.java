package sk.viawebtour.www.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name="vacation")
public class Vacation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "userid", nullable = false)
	private Integer userid;

	@Column(name = "resortid", nullable = false)
	private Integer resortid;
	
	@Column(name = "startdate", nullable = false)
	private Date startdate = new Date();
	
	@Column(name = "enddate", nullable = false)
	private Date enddate = new Date();

	@NotNull
	@Column(name = "createtime", nullable = false)
	private Date createtime = new Date();

    public Vacation() {
    }
    
    public Vacation(Integer userid, Integer resortid,
			Date startdate, Date enddate) {
		this.userid = userid;
		this.resortid = resortid;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public Vacation(Integer id, Integer userid, Integer resortid,
			Date startdate, Date enddate, Date createtime) {
		this.id = id;
		this.userid = userid;
		this.resortid = resortid;
		this.startdate = startdate;
		this.enddate = enddate;
		this.createtime = createtime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getResortid() {
		return resortid;
	}

	public void setResortid(Integer resortid) {
		this.resortid = resortid;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}
