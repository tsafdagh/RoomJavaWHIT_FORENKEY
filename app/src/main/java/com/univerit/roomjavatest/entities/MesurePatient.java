package com.univerit.roomjavatest.entities;

import androidx.room.Embedded;

public class MesurePatient {

    public MesurePatient() {
    }

    @Embedded
    private Mesure mesure;

    @Embedded
    private Patient patient;

    public Mesure getMesure() {
        return mesure;
    }

    public void setMesure(Mesure mesure) {
        this.mesure = mesure;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "MesurePatient{" +
                "mesure=" + mesure +
                ", patient=" + patient +
                '}';
    }
}
