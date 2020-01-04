package com.univerit.roomjavatest;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.univerit.roomjavatest.entities.Medicament;
import com.univerit.roomjavatest.entities.Mesure;
import com.univerit.roomjavatest.entities.Patient;
import com.univerit.roomjavatest.entities.PatientMedicamentMesure;
import com.univerit.roomjavatest.repository.MedicamentRepository;
import com.univerit.roomjavatest.repository.MesureRepository;
import com.univerit.roomjavatest.repository.PatientRepository;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editNom, editSurname;

    PatientRepository patientRepository;
    MesureRepository mesureRepository;
    MedicamentRepository medicamentRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        patientRepository = new PatientRepository(getApplication());
        mesureRepository = new MesureRepository(getApplication());
        medicamentRepository = new MedicamentRepository(getApplication());
        createPatient();
    }

    private void createPatient() {
        Date newdate = new Date();
        Long dateLong = newdate.getTime();
        Patient patient = new Patient( "nom Patient2", "Prenom pateint2", dateLong, "", "F");

        patientRepository.insertPatient(patient);

        pause();
        Mesure mesure = new Mesure( dateLong, 50, 40, 30, 20, 2);
        mesureRepository.insertMesure(mesure);

        pause();
        Medicament medicament = new Medicament("KININE", "1 matin 2 midi", 2);
        medicamentRepository.insertMedicament(medicament);

        pause();

        getAllPatients();
    }

    private void getAllPatients() {
        LiveData<List<PatientMedicamentMesure>> allPatientWithDataLiveData = patientRepository.getAllPatientMedicamentMesure();
        allPatientWithDataLiveData.observe(this, new Observer<List<PatientMedicamentMesure>>() {
            @Override
            public void onChanged(List<PatientMedicamentMesure> patientMedicamentMesures) {
                for (PatientMedicamentMesure patientMedicamentMesure: patientMedicamentMesures){
                    Log.d("MainActivity", "Patient courent: "+patientMedicamentMesure.toString());
                }
            }
        });


    }

    void pause() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
