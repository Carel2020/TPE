/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Carel Njanko
 */
@Entity
@Table(catalog = "bd_tpe_etudiant_niveau3", schema = "")
@NamedQueries({
    @NamedQuery(name = "Plaintes.findAll", query = "SELECT p FROM Plaintes p"),
    @NamedQuery(name = "Plaintes.findById", query = "SELECT p FROM Plaintes p WHERE p.id = :id"),
    @NamedQuery(name = "Plaintes.findByMotif", query = "SELECT p FROM Plaintes p WHERE p.motif = :motif"),
    @NamedQuery(name = "Plaintes.findByFaits", query = "SELECT p FROM Plaintes p WHERE p.faits = :faits"),
    @NamedQuery(name = "Plaintes.findByDate", query = "SELECT p FROM Plaintes p WHERE p.date = :date"),
    @NamedQuery(name = "Plaintes.findByDatecreation", query = "SELECT p FROM Plaintes p WHERE p.datecreation = :datecreation")})
public class Plaintes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 254)
    @Column(length = 254)
    private String motif;
    private Integer faits;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreation;
    @JoinColumn(name = "Dep_id", referencedColumnName = "id")
    @ManyToOne
    private Deplace depid;
    @JoinColumn(name = "Heb_id", referencedColumnName = "id")
    @ManyToOne
    private Hebergeur hebid;

    public Plaintes() {
    }

    public Plaintes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Integer getFaits() {
        return faits;
    }

    public void setFaits(Integer faits) {
        this.faits = faits;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public Deplace getDepid() {
        return depid;
    }

    public void setDepid(Deplace depid) {
        this.depid = depid;
    }

    public Hebergeur getHebid() {
        return hebid;
    }

    public void setHebid(Hebergeur hebid) {
        this.hebid = hebid;
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
        if (!(object instanceof Plaintes)) {
            return false;
        }
        Plaintes other = (Plaintes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.Model.Plaintes[ id=" + id + " ]";
    }
    
}
