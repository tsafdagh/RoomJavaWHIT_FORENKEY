package com.univerit.roomjavatest.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.univerit.roomjavatest.dao.PatientDao;
import com.univerit.roomjavatest.database.PatientRoomDatabase;
import com.univerit.roomjavatest.entities.Patient;
import com.univerit.roomjavatest.entities.PatientMedicamentMesure;

import java.util.List;

public class PatientRepository {

    private PatientDao mPatientDao;
    private LiveData<List<Patient>> mAllPatients;
    private LiveData<List<PatientMedicamentMesure>> mAllPatienMedicamentmesure;

    public PatientRepository(Application application) {
        PatientRoomDatabase db = PatientRoomDatabase.getDatabase(application);
        mPatientDao = db.patientDao();
        mAllPatients = mPatientDao.getAllPatients();
        mAllPatienMedicamentmesure = mPatientDao.findAllMedicamentAndPatient();
    }

    public LiveData<List<Patient>> getAllPatients() {
        return mAllPatients;
    }
    public LiveData<List<PatientMedicamentMesure>> getAllPatientMedicamentMesure() {
        return mAllPatienMedicamentmesure;
    }


    public void insertPatient(Patient patient) {
        PatientRoomDatabase.databaseWriteExecutor.execute(() -> {
            mPatientDao.insert(patient);
        });
    }

    public void updatePatient(Patient newPatient) {
        PatientRoomDatabase.databaseWriteExecutor.execute(() -> {
            mPatientDao.updatePatient(newPatient.getId(), newPatient.getNom(), newPatient.getPrenom(), newPatient.getDateNaissance(), newPatient.getImageUri(), newPatient.getSex());
        });
    }

    public Patient getPatientById(Integer id) {
        return mPatientDao.getPatientById(id);
    }
}
