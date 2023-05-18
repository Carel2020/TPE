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
    @NamedQuery(name = "Deplace.findAll", query = "SELECT d FROM Deplace d"),
    @NamedQuery(name = "Deplace.findById", query = "SELECT d FROM Deplace d WHERE d.id = :id"),
    @NamedQuery(name = "Deplace.findByIdentifiant", query = "SELECT d FROM Deplace d WHERE d.identifiant = :identifiant"),
    @NamedQuery(name = "Deplace.findBySignedistinctif", query = "SELECT d FROM Deplace d WHERE d.signedistinctif = :signedistinctif"),
    @NamedQuery(name = "Deplace.findByReference", query = "SELECT d FROM Deplace d WHERE d.reference = :reference"),
    @NamedQuery(name = "Deplace.findByDatecreation", query = "SELECT d FROM Deplace d WHERE d.datecreation = :datecreation")})
public class Deplace implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    private Integer identifiant;
    @Size(max = 254)
    @Column(length = 254)
    private String signedistinctif;
    @Size(max = 254)
    @Column(length = 254)
    private String reference;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreation;
    @OneToMany(mappedBy = "depid")
    private Collection<Hebergement> hebergementCollection;
    @OneToMany(mappedBy = "depid")
    private Collection<Entretien> entretienCollection;
    @OneToMany(mappedBy = "depid")
    private Collection<Plaintes> plaintesCollection;

    public Deplace() {
    }

    public Deplace(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Integer identifiant) {
        this.identifiant = identifiant;
    }

    public String getSignedistinctif() {
        return signedistinctif;
    }

    public void setSignedistinctif(String signedistinctif) {
        this.signedistinctif = signedistinctif;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
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
        if (!(object instanceof Deplace)) {
            return false;
        }
        Deplace other = (Deplace) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.Model.Deplace[ id=" + id + " ]";
    }
    
}
