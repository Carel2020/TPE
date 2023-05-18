/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Carel Njanko
 */
@Entity
@Table(catalog = "bd_tpe_etudiant_niveau3", schema = "")
@NamedQueries({
    @NamedQuery(name = "Nationalites.findAll", query = "SELECT n FROM Nationalites n"),
    @NamedQuery(name = "Nationalites.findById", query = "SELECT n FROM Nationalites n WHERE n.id = :id"),
    @NamedQuery(name = "Nationalites.findByNom", query = "SELECT n FROM Nationalites n WHERE n.nom = :nom"),
    @NamedQuery(name = "Nationalites.findByIndicatif", query = "SELECT n FROM Nationalites n WHERE n.indicatif = :indicatif")})
public class Nationalites implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    private Integer nom;
    @Size(max = 254)
    @Column(length = 254)
    private String indicatif;

    public Nationalites() {
    }

    public Nationalites(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNom() {
        return nom;
    }

    public void setNom(Integer nom) {
        this.nom = nom;
    }

    public String getIndicatif() {
        return indicatif;
    }

    public void setIndicatif(String indicatif) {
        this.indicatif = indicatif;
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
        if (!(object instanceof Nationalites)) {
            return false;
        }
        Nationalites other = (Nationalites) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.Model.Nationalites[ id=" + id + " ]";
    }
    
}
