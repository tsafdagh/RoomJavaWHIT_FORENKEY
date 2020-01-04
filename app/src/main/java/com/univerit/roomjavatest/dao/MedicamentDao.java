package com.univerit.roomjavatest.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.univerit.roomjavatest.entities.Medicament;
import com.univerit.roomjavatest.entities.MedicamentPatient;
import com.univerit.roomjavatest.entities.Patient;

import java.util.List;

@Dao
public interface MedicamentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Medicament pedicament);

    @Query("SELECT * FROM medicament_table ORDER BY nomMedicament ASC")
    LiveData<List<Medicament>> getAllMedicaments();

    @Query("SELECT * FROM medicament_table where medeicamentId = :id")
    Medicament getMedicamentById(Integer id);

    @Query("UPDATE medicament_table SET nomMedicament =:nveauNom, dose =:nvDose WHERE medeicamentId =:id")
    void updateMedicament(Integer id, String nveauNom, String nvDose);

    @Query("DELETE FROM medicament_table")
    void deleteAllMedicament();

    @Query("SELECT medicament_table.*, patient_table.* FROM medicament_table INNER JOIN patient_table ON medicament_table.patienIdMedic = patient_table.id")
    LiveData<List<MedicamentPatient>> findAllMedicamentAndPatient();
}
