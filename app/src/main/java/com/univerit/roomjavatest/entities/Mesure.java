package com.univerit.roomjavatest.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "mesure_table",
        foreignKeys = @ForeignKey(entity = Patient.class,
                parentColumns = "id",
                childColumns = "patienIdMesur",
                onDelete = CASCADE)
)

public class Mesure {

    public Mesure() {
    }

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "mesureId")
    private Integer mesureId;

    @ColumnInfo(name = "date")
    private Long date;

    @ColumnInfo(name = "diastolic")
    private int diastolic;

    @ColumnInfo(name = "systolic")
    private int systolic;

    @ColumnInfo(name = "mean")
    private int mean;

    @ColumnInfo(name = "heartRate")
    private int heartRate;

    @ColumnInfo(name = "patienIdMesur", index = true)
    private int patienIdMesur;

    public Mesure(Long date, int diastolic, int systolic, int mean, int heartRate, int patienIdMesur) {
        this.mesureId = mesureId;
        this.date = date;
        this.diastolic = diastolic;
        this.systolic = systolic;
        this.mean = mean;
        this.heartRate = heartRate;
        this.patienIdMesur = patienIdMesur;
    }

    @NonNull
    public Integer getMesureId() {
        return mesureId;
    }

    public void setMesureId(@NonNull Integer mesureId) {
        this.mesureId = mesureId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }

    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getMean() {
        return mean;
    }

    public void setMean(int mean) {
        this.mean = mean;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getPatienIdMesur() {
        return patienIdMesur;
    }

    public void setPatienIdMesur(int patienIdMesur) {
        this.patienIdMesur = patienIdMesur;
    }

    @Override
    public String toString() {
        return "Mesure{" +
                "mesureId=" + mesureId +
                ", date=" + date +
                ", diastolic=" + diastolic +
                ", systolic=" + systolic +
                ", mean=" + mean +
                ", heartRate=" + heartRate +
                ", patienIdMesur=" + patienIdMesur +
                '}';
    }
}
