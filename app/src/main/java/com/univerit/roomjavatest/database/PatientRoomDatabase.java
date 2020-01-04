package com.univerit.roomjavatest.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.univerit.roomjavatest.dao.MedicamentDao;
import com.univerit.roomjavatest.dao.MesureDao;
import com.univerit.roomjavatest.dao.PatientDao;
import com.univerit.roomjavatest.entities.Medicament;
import com.univerit.roomjavatest.entities.Mesure;
import com.univerit.roomjavatest.entities.Patient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Patient.class, Medicament.class, Mesure.class}, version = 1, exportSchema = false)
public abstract class PatientRoomDatabase extends RoomDatabase {

    public abstract PatientDao patientDao();
    public abstract MedicamentDao medicamentDao();
    public abstract MesureDao mesureDao();

    private static volatile PatientRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static PatientRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PatientRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PatientRoomDatabase.class, "patient_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
