package com.univerit.roomjavatest.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "patient_table")
public class Patient {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;

    @ColumnInfo(name = "nom")
    private String nom;

    @ColumnInfo(name = "prenom")
    private String prenom;

    @ColumnInfo(name = "dateNaissance")
    private Long dateNaissance;

    @ColumnInfo(name = "imageUri")
    private String imageUri;

    @ColumnInfo(name = "sex")
    private String sex;

    public Patient() {
    }

    public Patient( String nom, String prenom, Long dateNaissance, String imageUri, String sex) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.imageUri = imageUri;
        this.sex = sex;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    @NonNull
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Long getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Long dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", imageUri='" + imageUri + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
