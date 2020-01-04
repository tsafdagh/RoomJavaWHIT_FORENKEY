package com.univerit.roomjavatest.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.univerit.roomjavatest.dao.MedicamentDao;
import com.univerit.roomjavatest.database.PatientRoomDatabase;
import com.univerit.roomjavatest.entities.Medicament;
import com.univerit.roomjavatest.entities.MedicamentPatient;

import java.util.List;

public class MedicamentRepository {

    private MedicamentDao mMedicamentDao;
    private LiveData<List<Medicament>> mAllMedicaments;
    private LiveData<List<MedicamentPatient>> mAllMedicamentPatient;

    public MedicamentRepository(Application application) {
        PatientRoomDatabase db = PatientRoomDatabase.getDatabase(application);
        mMedicamentDao = db.medicamentDao();
        mAllMedicaments = mMedicamentDao.getAllMedicaments();
        mAllMedicamentPatient = mMedicamentDao.findAllMedicamentAndPatient();
    }

    LiveData<List<Medicament>> getAllMedicaments() {
        return mAllMedicaments;
    }

    public LiveData<List<MedicamentPatient>> getmAllMedicamentPatient() {
        return mAllMedicamentPatient;
    }

    public void insertMedicament(Medicament medicament) {
        PatientRoomDatabase.databaseWriteExecutor.execute(() -> {
            mMedicamentDao.insert(medicament);
        });
    }

    public void updateMedicament(Medicament newMedicament) {
        PatientRoomDatabase.databaseWriteExecutor.execute(() -> {
            mMedicamentDao.updateMedicament(newMedicament.getMedeicamentId(), newMedicament.getNomMedicament(), newMedicament.getDose());
        });
    }

    public Medicament getMedicamentById(Integer id) {
        return mMedicamentDao.getMedicamentById(id);
    }
}
