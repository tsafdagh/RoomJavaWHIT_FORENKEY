package com.univerit.roomjavatest.entities;

import androidx.room.Embedded;

public class MedicamentPatient {

    public MedicamentPatient() {
    }

    @Embedded
    private Medicament medicament;

    @Embedded
    private Patient patient;

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "MedicamentPatient{" +
                "medicament=" + medicament +
                ", patient=" + patient +
                '}';
    }
}
