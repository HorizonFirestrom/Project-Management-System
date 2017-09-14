/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softwarica.wetrack.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Prashanna
 */
@Entity
@Table(name = "phase", catalog = "wetrack", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phase.findAll", query = "SELECT p FROM Phase p"),
    @NamedQuery(name = "Phase.findById", query = "SELECT p FROM Phase p WHERE p.id = :id"),
    @NamedQuery(name = "Phase.findByExpectedTime", query = "SELECT p FROM Phase p WHERE p.expectedTime = :expectedTime"),
    @NamedQuery(name = "Phase.findByStartDate", query = "SELECT p FROM Phase p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "Phase.findByEndDate", query = "SELECT p FROM Phase p WHERE p.endDate = :endDate"),
    @NamedQuery(name = "Phase.findByDependentOnPhase", query = "SELECT p FROM Phase p WHERE p.dependentOnPhase = :dependentOnPhase")})
public class Phase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "expected_time")
    @Temporal(TemporalType.DATE)
    private Date expectedTime;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Lob
    @Column(name = "skills_required")
    private String skillsRequired;
    @Column(name = "dependent_on_phase")
    private Integer dependentOnPhase;
    @JoinColumn(name = "milestone_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Milestone milestoneId;
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Project projectId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public Phase() {
    }

    public Phase(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Date expectedTime) {
        this.expectedTime = expectedTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(String skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    public Integer getDependentOnPhase() {
        return dependentOnPhase;
    }

    public void setDependentOnPhase(Integer dependentOnPhase) {
        this.dependentOnPhase = dependentOnPhase;
    }

    public Milestone getMilestoneId() {
        return milestoneId;
    }

    public void setMilestoneId(Milestone milestoneId) {
        this.milestoneId = milestoneId;
    }

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phase)) {
            return false;
        }
        Phase other = (Phase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.softwarica.wetrack.models.Phase[ id=" + id + " ]";
    }
    
}
