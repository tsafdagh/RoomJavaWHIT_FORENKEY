package com.univerit.roomjavatest.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.univerit.roomjavatest.entities.Patient;
import com.univerit.roomjavatest.entities.PatientMedicamentMesure;

import java.util.List;

@Dao
public interface PatientDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Patient patient);

    @Query("SELECT * FROM patient_table ORDER BY nom ASC")
    LiveData<List<Patient>> getAllPatients();

    @Query("SELECT * FROM patient_table where id = :id")
    Patient getPatientById(Integer id);

    @Query("UPDATE patient_table SET nom =:nveauNom, prenom =:nouveauPrenom, dateNaissance=:nouvelleDateNaissance, imageUri =:nvImageURI, sex=:nvSex WHERE id =:id")
    void updatePatient(Integer id, String nveauNom, String nouveauPrenom, Long nouvelleDateNaissance, String nvImageURI, String nvSex);

    @Query("DELETE FROM patient_table")
    void deleteAllPatients();

    @Query("SELECT patient_table.*, medicament_table.*, mesure_table.* FROM patient_table INNER JOIN medicament_table INNER JOIN mesure_table ON (patient_table.id = medicament_table.patienIdMedic)" +
            " AND (patient_table.id = mesure_table.patienIdMesur)")
    LiveData<List<PatientMedicamentMesure>> findAllMedicamentAndPatient();
}
