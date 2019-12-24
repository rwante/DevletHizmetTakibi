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
@Table(name = "BURS_BASVURU_LISTESI", catalog = "", schema = "BURS_BASVURU")
@NamedQueries({
    @NamedQuery(name = "BursBasvuruListesi.findAll", query = "SELECT b FROM BursBasvuruListesi b"),
    @NamedQuery(name = "BursBasvuruListesi.findByNumber", query = "SELECT b FROM BursBasvuruListesi b WHERE b.number = :number"),
    @NamedQuery(name = "BursBasvuruListesi.findByAd", query = "SELECT b FROM BursBasvuruListesi b WHERE b.ad = :ad"),
    @NamedQuery(name = "BursBasvuruListesi.findBySoyad", query = "SELECT b FROM BursBasvuruListesi b WHERE b.soyad = :soyad")})
public class BursBasvuruListesi implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUMBER")
    private Integer number;
    @Column(name = "AD")
    private String ad;
    @Column(name = "SOYAD")
    private String soyad;

    public BursBasvuruListesi() {
    }

    public BursBasvuruListesi(Integer number) {
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

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        String oldAd = this.ad;
        this.ad = ad;
        changeSupport.firePropertyChange("ad", oldAd, ad);
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        String oldSoyad = this.soyad;
        this.soyad = soyad;
        changeSupport.firePropertyChange("soyad", oldSoyad, soyad);
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
        if (!(object instanceof BursBasvuruListesi)) {
            return false;
        }
        BursBasvuruListesi other = (BursBasvuruListesi) object;
        if ((this.number == null && other.number != null) || (this.number != null && !this.number.equals(other.number))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proje.BursBasvuruListesi[ number=" + number + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
