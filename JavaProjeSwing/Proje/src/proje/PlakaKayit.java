/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "PLAKA_KAYIT", catalog = "", schema = "PLAKA_KAYIT")
@NamedQueries({
    @NamedQuery(name = "PlakaKayit.findAll", query = "SELECT p FROM PlakaKayit p"),
    @NamedQuery(name = "PlakaKayit.findByNumber", query = "SELECT p FROM PlakaKayit p WHERE p.number = :number"),
    @NamedQuery(name = "PlakaKayit.findByPlaka", query = "SELECT p FROM PlakaKayit p WHERE p.plaka = :plaka"),
    @NamedQuery(name = "PlakaKayit.findByArac", query = "SELECT p FROM PlakaKayit p WHERE p.arac = :arac")})
public class PlakaKayit implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUMBER")
    private Integer number;
    @Column(name = "PLAKA")
    private String plaka;
    @Column(name = "ARAC")
    private String arac;

    public PlakaKayit() {
    }

    public PlakaKayit(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        Integer oldNumber = this.number;
        this.number = number;
        changeSupport.firePropertyChange("number", oldNumber, number);
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        String oldPlaka = this.plaka;
        this.plaka = plaka;
        changeSupport.firePropertyChange("plaka", oldPlaka, plaka);
    }

    public String getArac() {
        return arac;
    }

    public void setArac(String arac) {
        String oldArac = this.arac;
        this.arac = arac;
        changeSupport.firePropertyChange("arac", oldArac, arac);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (number != null ? number.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlakaKayit)) {
            return false;
        }
        PlakaKayit other = (PlakaKayit) object;
        if ((this.number == null && other.number != null) || (this.number != null && !this.number.equals(other.number))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proje.PlakaKayit[ number=" + number + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
