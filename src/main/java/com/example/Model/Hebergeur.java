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
    @NamedQuery(name = "Hebergeur.findAll", query = "SELECT h FROM Hebergeur h"),
    @NamedQuery(name = "Hebergeur.findById", query = "SELECT h FROM Hebergeur h WHERE h.id = :id"),
    @NamedQuery(name = "Hebergeur.findByNumauth", query = "SELECT h FROM Hebergeur h WHERE h.numauth = :numauth"),
    @NamedQuery(name = "Hebergeur.findByCredit", query = "SELECT h FROM Hebergeur h WHERE h.credit = :credit"),
    @NamedQuery(name = "Hebergeur.findByDatecreation", query = "SELECT h FROM Hebergeur h WHERE h.datecreation = :datecreation"),
    @NamedQuery(name = "Hebergeur.findByEstactif", query = "SELECT h FROM Hebergeur h WHERE h.estactif = :estactif")})
public class Hebergeur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 254)
    @Column(length = 254)
    private String numauth;
    private Integer credit;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreation;
    private Boolean estactif;
    @OneToMany(mappedBy = "hebid")
    private Collection<Hebergement> hebergementCollection;
    @OneToMany(mappedBy = "hebid")
    private Collection<Entretien> entretienCollection;
    @OneToMany(mappedBy = "hebid")
    private Collection<Plaintes> plaintesCollection;

    public Hebergeur() {
    }

    public Hebergeur(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumauth() {
        return numauth;
    }

    public void setNumauth(String numauth) {
        this.numauth = numauth;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
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

    public Collection<Hebergement> getHebergementCollection() {
        return hebergementCollection;
    }

    public void setHebergementCollection(Collection<Hebergement> hebergementCollection) {
        this.hebergementCollection = hebergementCollection;
    }

    public Collection<Entretien> getEntretienCollection() {
        return entretienCollection;
    }

    public void setEntretienCollection(Collection<Entretien> entretienCollection) {
        this.entretienCollection = entretienCollection;
    }

    public Collection<Plaintes> getPlaintesCollection() {
        return plaintesCollection;
    }

    public void setPlaintesCollection(Collection<Plaintes> plaintesCollection) {
        this.plaintesCollection = plaintesCollection;
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
        if (!(object instanceof Hebergeur)) {
            return false;
        }
        Hebergeur other = (Hebergeur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.Model.Hebergeur[ id=" + id + " ]";
    }
    
}
