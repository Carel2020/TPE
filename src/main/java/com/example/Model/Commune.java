/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Model;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author Carel Njanko
 */
@Entity
@Table(catalog = "bd_tpe_etudiant_niveau3", schema = "")
@NamedQueries({
    @NamedQuery(name = "Commune.findAll", query = "SELECT c FROM Commune c"),
    @NamedQuery(name = "Commune.findById", query = "SELECT c FROM Commune c WHERE c.id = :id"),
    @NamedQuery(name = "Commune.findByNom", query = "SELECT c FROM Commune c WHERE c.nom = :nom"),
    @NamedQuery(name = "Commune.findByCode", query = "SELECT c FROM Commune c WHERE c.code = :code")})
public class Commune implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    private Integer nom;
    private Integer code;
    @OneToMany(mappedBy = "comid")
    private Collection<Ville> villeCollection;
    @JoinColumn(name = "Reg_id", referencedColumnName = "id")
    @ManyToOne
    private Region regid;

    public Commune() {
    }

    public Commune(Integer id) {
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

    public Collection<Ville> getVilleCollection() {
        return villeCollection;
    }

    public void setVilleCollection(Collection<Ville> villeCollection) {
        this.villeCollection = villeCollection;
    }

    public Region getRegid() {
        return regid;
    }

    public void setRegid(Region regid) {
        this.regid = regid;
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
        if (!(object instanceof Commune)) {
            return false;
        }
        Commune other = (Commune) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.Model.Commune[ id=" + id + " ]";
    }
    
}
