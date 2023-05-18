/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Hebergement.findAll", query = "SELECT h FROM Hebergement h"),
    @NamedQuery(name = "Hebergement.findById", query = "SELECT h FROM Hebergement h WHERE h.id = :id"),
    @NamedQuery(name = "Hebergement.findByNom", query = "SELECT h FROM Hebergement h WHERE h.nom = :nom"),
    @NamedQuery(name = "Hebergement.findByCapacite", query = "SELECT h FROM Hebergement h WHERE h.capacite = :capacite"),
    @NamedQuery(name = "Hebergement.findByNotation", query = "SELECT h FROM Hebergement h WHERE h.notation = :notation"),
    @NamedQuery(name = "Hebergement.findByDatecreation", query = "SELECT h FROM Hebergement h WHERE h.datecreation = :datecreation"),
    @NamedQuery(name = "Hebergement.findByEstactif", query = "SELECT h FROM Hebergement h WHERE h.estactif = :estactif")})
public class Hebergement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 254)
    @Column(length = 254)
    private String nom;
    private Integer capacite;
    private Integer notation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreation;
    private Boolean estactif;
    @OneToMany(mappedBy = "hebid")
    private Collection<Rue> rueCollection;
    @JoinColumn(name = "Heb_id", referencedColumnName = "id")
    @ManyToOne
    private Hebergeur hebid;
    @JoinColumn(name = "Dep_id", referencedColumnName = "id")
    @ManyToOne
    private Deplace depid;

    public Hebergement() {
    }

    public Hebergement(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public Integer getNotation() {
        return notation;
    }

    public void setNotation(Integer notation) {
        this.notation = notation;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public Boolean getEstactif() {
        return estactif;
    }

    public void setEstactif(Boolean estactif) {
        this.estactif = estactif;
    }

    public Collection<Rue> getRueCollection() {
        return rueCollection;
    }

    public void setRueCollection(Collection<Rue> rueCollection) {
        this.rueCollection = rueCollection;
    }

    public Hebergeur getHebid() {
        return hebid;
    }

    public void setHebid(Hebergeur hebid) {
        this.hebid = hebid;
    }

    public Deplace getDepid() {
        return depid;
    }

    public void setDepid(Deplace depid) {
        this.depid = depid;
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
        if (!(object instanceof Hebergement)) {
            return false;
        }
        Hebergement other = (Hebergement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.Model.Hebergement[ id=" + id + " ]";
    }
    
}
