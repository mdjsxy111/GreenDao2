package com.estyle.greendao.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.estyle.greendao.R;
import com.estyle.greendao.application.MyApp;
import com.estyle.greendao.bean.PersonEntity;
import com.estyle.greendao.bean.PersonEntityDao;

import org.greenrobot.greendao.query.Query;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText ageEditText;

    private PersonEntityDao personDao;
    private Query<PersonEntity> personQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.name_et);
        ageEditText = (EditText) findViewById(R.id.age_et);

        MyApp app = (MyApp) getApplication();
        personDao = app.getDaoSession().getPersonEntityDao();
        personQuery = personDa
                .queryBuilder()
                .orderAsc(PersonEntityDao.Properties.CurTime)
//                .where(new WhereCondition.StringCondition("age < 67 and name = '66'"))
                .build();
    }

    public void clickBtn(View view) {
        switch (view.getId()) {
            case R.id.insert_btn:
                insertData();
                break;
            case R.id.delete_btn:
                deleteData();
                break;
            case R.id.update_btn:
                updateData();
                break;
            case R.id.query_btn:
                queryData();
                break;
        }
    }

    private void insertData() {
        String name = nameEditText.getText().toString();
        int age = Integer.parseInt(ageEditText.getText().toString());
        PersonEntity person = new PersonEntity(age, name, age, System.currentTimeMillis());
        personDao.insert(person);
        Toast.makeText(this, "insert OK", Toast.LENGTH_SHORT).show();
    }

    private void deleteData() {
//        PersonEntity p = new PersonEntity();
//        p.setId(66);
//        personDao.delete(p);

        Toast.makeText(this, "delete OK", Toast.LENGTH_SHORT).show();
    }

    private void updateData() {
        PersonEntity p = new PersonEntity();
        p.setId(54);
        p.setAge(56);
        personDao.update(p);
    }

    private void queryData() {
        List<PersonEntity> list = personQuery.list();
        for (PersonEntity entity : list) {
            Log.d("ee", "name : " + entity.getName() + ", age : " + entity.getAge());
        }
        Toast.makeText(this, "query OK", Toast.LENGTH_SHORT).show();

    }

}
