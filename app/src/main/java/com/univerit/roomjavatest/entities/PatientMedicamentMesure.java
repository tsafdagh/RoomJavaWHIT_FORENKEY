package com.univerit.roomjavatest.entities;

import androidx.room.Embedded;

public class PatientMedicamentMesure {

    public PatientMedicamentMesure() {
    }

    @Embedded
    private Patient patient;

    @Embedded
    private Mesure mesure;

    @Embedded
    private Medicament medicament;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Mesure getMesure() {
        return mesure;
    }

    public void setMesure(Mesure mesure) {
        this.mesure = mesure;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    @Override
    public String toString() {
        return "PatientMedicamentMesure{" +
                "patient=" + patient +
                ", mesure=" + mesure +
                ", medicament=" + medicament +
                '}';
    }
}
