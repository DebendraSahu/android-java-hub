package com.deben.mvvmexample;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PersonViewModel extends ViewModel {
    private final PersonManager mPersonManager = new PersonManager();
    private final MutableLiveData<Person> mPersonMutableLiveData = new MutableLiveData<>();

    public void setPersonInfo(String name, String email) {
        if (name == null || email == null) return;
        Person person = mPersonManager.getPerson(name, email);
        mPersonMutableLiveData.setValue(person);
    }

    public MutableLiveData<Person> getPerson() {
        return mPersonMutableLiveData;
    }
}
