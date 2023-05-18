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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Carel Njanko
 */
@Entity
@Table(catalog = "bd_tpe_etudiant_niveau3", schema = "")
@NamedQueries({
    @NamedQuery(name = "Rue.findAll", query = "SELECT r FROM Rue r"),
    @NamedQuery(name = "Rue.findById", query = "SELECT r FROM Rue r WHERE r.id = :id"),
    @NamedQuery(name = "Rue.findByNom", query = "SELECT r FROM Rue r WHERE r.nom = :nom"),
    @NamedQuery(name = "Rue.findByCode", query = "SELECT r FROM Rue r WHERE r.code = :code")})
public class Rue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    private Integer nom;
    private Integer code;
    @JoinColumn(name = "Heb_id", referencedColumnName = "id")
    @ManyToOne
    private Hebergement hebid;
    @JoinColumn(name = "Vil_id", referencedColumnName = "id")
    @ManyToOne
    private Ville vilid;

    public Rue() {
    }

    public Rue(Integer id) {
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Hebergement getHebid() {
        return hebid;
    }

    public void setHebid(Hebergement hebid) {
        this.hebid = hebid;
    }

    public Ville getVilid() {
        return vilid;
    }

    public void setVilid(Ville vilid) {
        this.vilid = vilid;
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
        if (!(object instanceof Rue)) {
            return false;
        }
        Rue other = (Rue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.Model.Rue[ id=" + id + " ]";
    }
    
}
