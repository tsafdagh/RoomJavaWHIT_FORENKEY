package com.univerit.roomjavatest.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.univerit.roomjavatest.dao.MesureDao;
import com.univerit.roomjavatest.dao.PatientDao;
import com.univerit.roomjavatest.database.PatientRoomDatabase;
import com.univerit.roomjavatest.entities.Mesure;
import com.univerit.roomjavatest.entities.MesurePatient;
import com.univerit.roomjavatest.entities.Patient;
import com.univerit.roomjavatest.entities.PatientMedicamentMesure;

import java.util.List;

public class MesureRepository {

    private MesureDao mMesureDao;
    private LiveData<List<Mesure>> mAllMesures;
    private LiveData<List<MesurePatient>> mAllMesurePatient;

    public MesureRepository(Application application) {
        PatientRoomDatabase db = PatientRoomDatabase.getDatabase(application);
        mMesureDao = db.mesureDao();
        mAllMesures = mMesureDao.getAllMesure();
        mAllMesurePatient = mMesureDao.findAllMesureAndPatient();
    }

    LiveData<List<Mesure>> getAllMesures() {
        return mAllMesures;
    }
    LiveData<List<MesurePatient>> getAllMesuresAndPatients() {
        return mAllMesurePatient;
    }


    public void insertMesure(Mesure mesure) {
        PatientRoomDatabase.databaseWriteExecutor.execute(() -> {
            mMesureDao.insertMesure(mesure);
        });
    }

    public void updateMesure(Mesure newMesure) {
        PatientRoomDatabase.databaseWriteExecutor.execute(() -> {
            mMesureDao.updateMesure(newMesure.getMesureId(), newMesure.getDate(), newMesure.getDiastolic(), newMesure.getSystolic(), newMesure.getMean(), newMesure.getHeartRate(), newMesure.getPatienIdMesur());
        });
    }

    public Mesure getMesureById(Integer id) {
        return mMesureDao.getMesureById(id);
    }
}
