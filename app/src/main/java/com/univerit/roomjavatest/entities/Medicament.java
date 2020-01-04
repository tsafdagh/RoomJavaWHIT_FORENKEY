package com.univerit.roomjavatest.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "medicament_table",
        foreignKeys = @ForeignKey(entity = Patient.class,
                parentColumns = "id",
                childColumns = "patienIdMedic",
                onDelete = CASCADE))

public class Medicament {


    public Medicament() {
    }

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "medeicamentId")
    private Integer medeicamentId;

    @ColumnInfo(name = "nomMedicament")
    private String nomMedicament;

    @ColumnInfo(name = "dose")
    private String dose;

    @ColumnInfo(name = "patienIdMedic", index = true)
    private Integer patienIdMedic;

    public Medicament( String nomMedicament, String dose, Integer patienIdMedic) {
        this.medeicamentId = medeicamentId;
        this.nomMedicament = nomMedicament;
        this.dose = dose;
        this.patienIdMedic = patienIdMedic;
    }

    @NonNull
    public Integer getMedeicamentId() {
        return medeicamentId;
    }

    public void setMedeicamentId(@NonNull Integer medeicamentId) {
        this.medeicamentId = medeicamentId;
    }

    public String getNomMedicament() {
        return nomMedicament;
    }

    public void setNomMedicament(String nomMedicament) {
        this.nomMedicament = nomMedicament;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public Integer getPatienIdMedic() {
        return patienIdMedic;
    }

    public void setPatienIdMedic(Integer patienIdMedic) {
        this.patienIdMedic = patienIdMedic;
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "medeicamentId=" + medeicamentId +
                ", nomMedicament='" + nomMedicament + '\'' +
                ", dose='" + dose + '\'' +
                ", patienIdMedic=" + patienIdMedic +
                '}';
    }
}
