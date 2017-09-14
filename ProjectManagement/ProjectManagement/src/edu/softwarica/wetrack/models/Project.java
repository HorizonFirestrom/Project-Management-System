/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.softwarica.wetrack.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Prashanna
 */
@Entity
@Table(name = "project", catalog = "wetrack", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project_1.findAll", query = "SELECT p FROM Project_1 p"),
    @NamedQuery(name = "Project_1.findById", query = "SELECT p FROM Project_1 p WHERE p.id = :id"),
    @NamedQuery(name = "Project_1.findByName", query = "SELECT p FROM Project_1 p WHERE p.name = :name")})
public class Project implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_id")
    private Integer proId;
    @Basic(optional = false)
    @Column(name = "skillsrequired")
    private String skillsrequired;
    @Basic(optional = false)
    @Column(name = "userid")
    private int userid;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "skills_required")
    private String skillsRequired;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId")
    private List<Phase> phaseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId")
    private List<ProjectTeam> projectTeamList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId")
    private List<Milestone> milestoneList;
    @JoinColumn(name = "project_owner", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User projectOwner;

    public Project() {
    }

    public Project(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(String skillsRequired) {
        String oldSkillsRequired = this.skillsRequired;
        this.skillsRequired = skillsRequired;
        changeSupport.firePropertyChange("skillsRequired", oldSkillsRequired, skillsRequired);
    }

    @XmlTransient
    public List<Phase> getPhaseList() {
        return phaseList;
    }

    public void setPhaseList(List<Phase> phaseList) {
        this.phaseList = phaseList;
    }

    @XmlTransient
    public List<ProjectTeam> getProjectTeamList() {
        return projectTeamList;
    }

    public void setProjectTeamList(List<ProjectTeam> projectTeamList) {
        this.projectTeamList = projectTeamList;
    }

    @XmlTransient
    public List<Milestone> getMilestoneList() {
        return milestoneList;
    }

    public void setMilestoneList(List<Milestone> milestoneList) {
        this.milestoneList = milestoneList;
    }

    public User getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(User projectOwner) {
        User oldProjectOwner = this.projectOwner;
        this.projectOwner = projectOwner;
        changeSupport.firePropertyChange("projectOwner", oldProjectOwner, projectOwner);
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
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.softwarica.wetrack.models.Project_1[ id=" + id + " ]";
    }

    /**
     *
     * @param proId
     */
    

    public Project(Integer proId, String skillsrequired, int userid) {
        this.proId = proId;
        this.skillsrequired = skillsrequired;
        this.userid = userid;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        Integer oldProId = this.proId;
        this.proId = proId;
        changeSupport.firePropertyChange("proId", oldProId, proId);
    }

    public String getSkillsrequired() {
        return skillsrequired;
    }

    public void setSkillsrequired(String skillsrequired) {
        String oldSkillsrequired = this.skillsrequired;
        this.skillsrequired = skillsrequired;
        changeSupport.firePropertyChange("skillsrequired", oldSkillsrequired, skillsrequired);
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        int oldUserid = this.userid;
        this.userid = userid;
        changeSupport.firePropertyChange("userid", oldUserid, userid);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    

    
   

  
   
    
}
