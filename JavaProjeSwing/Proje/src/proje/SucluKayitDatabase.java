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
@Table(name = "SUCLU_KAYIT_DATABASE", catalog = "", schema = "SUCLU_KAYIT")
@NamedQueries({
    @NamedQuery(name = "SucluKayitDatabase.findAll", query = "SELECT s FROM SucluKayitDatabase s"),
    @NamedQuery(name = "SucluKayitDatabase.findByNumber", query = "SELECT s FROM SucluKayitDatabase s WHERE s.number = :number"),
    @NamedQuery(name = "SucluKayitDatabase.findByAd", query = "SELECT s FROM SucluKayitDatabase s WHERE s.ad = :ad"),
    @NamedQuery(name = "SucluKayitDatabase.findBySoyad", query = "SELECT s FROM SucluKayitDatabase s WHERE s.soyad = :soyad"),
    @NamedQuery(name = "SucluKayitDatabase.findBySuc", query = "SELECT s FROM SucluKayitDatabase s WHERE s.suc = :suc"),
    @NamedQuery(name = "SucluKayitDatabase.findByRenk", query = "SELECT s FROM SucluKayitDatabase s WHERE s.renk = :renk")})
public class SucluKayitDatabase implements Serializable {
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
    @Column(name = "SUC")
    private String suc;
    @Column(name = "RENK")
    private String renk;

    public SucluKayitDatabase() {
    }

    public SucluKayitDatabase(Integer number) {
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

    public String getSuc() {
        return suc;
    }

    public void setSuc(String suc) {
        String oldSuc = this.suc;
        this.suc = suc;
        changeSupport.firePropertyChange("suc", oldSuc, suc);
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        String oldRenk = this.renk;
        this.renk = renk;
        changeSupport.firePropertyChange("renk", oldRenk, renk);
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
        if (!(object instanceof SucluKayitDatabase)) {
            return false;
        }
        SucluKayitDatabase other = (SucluKayitDatabase) object;
        if ((this.number == null && other.number != null) || (this.number != null && !this.number.equals(other.number))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proje.SucluKayitDatabase[ number=" + number + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
