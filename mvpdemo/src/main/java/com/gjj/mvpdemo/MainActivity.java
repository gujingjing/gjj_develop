package com.gjj.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gjj.mvpdemo.presenter.UserPresenter;
import com.gjj.mvpdemo.view.IUserView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IUserView {

    @Bind(R.id.id)
    EditText id;
    @Bind(R.id.firstName)
    EditText firstName;
    @Bind(R.id.lastName)
    EditText lastName;
    @Bind(R.id.btn_save)
    Button btnSave;
    @Bind(R.id.btn_read)
    Button btnRead;
    UserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new UserPresenter(this);
    }

    @OnClick({R.id.btn_save, R.id.btn_read})
    void onclick(View view) {
        switch (view.getId()) {
            case R.id.btn_save://存
                presenter.saveUser(getID(), getFristName(), getLastName());
                break;
            case R.id.btn_read://取
                presenter.loadUser(getID());
                break;
        }
    }

    @Override
    public int getID() {
        return new Integer(id.getText().toString());
    }

    @Override
    public String getFristName() {
        return firstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return lastName.getText().toString();
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName.setText(lastName);
    }
}
