package com.univerit.roomjavatest.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.univerit.roomjavatest.entities.Mesure;
import com.univerit.roomjavatest.entities.MesurePatient;

import java.util.List;

@Dao
public interface MesureDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMesure(Mesure mesure);

    @Query("SELECT * FROM mesure_table")
    LiveData<List<Mesure>> getAllMesure();

    @Query("SELECT * FROM mesure_table where mesureId = :mesureId")
    Mesure getMesureById(Integer mesureId);

    @Query("UPDATE mesure_table SET date =:newDate, diastolic =:newDiastolic, systolic=:newSystolic, mean =:newMean, heartRate=:newHeartRate, patienIdMesur=:newIdPatient WHERE mesureId =:mesureId")
    void updateMesure(Integer mesureId, Long newDate, int newDiastolic, int newSystolic, int newMean, int newHeartRate, Integer newIdPatient);

    @Query("DELETE FROM medicament_table")
    void deleteAllMedicaments();

    @Query("SELECT mesure_table.*, patient_table.* FROM mesure_table INNER JOIN patient_table ON mesure_table.patienIdMesur = patient_table.id")
    LiveData<List<MesurePatient>> findAllMesureAndPatient();
}
