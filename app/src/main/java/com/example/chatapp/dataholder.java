package com.example.chatapp;

import android.widget.EditText;

public class dataholder {
    EditText name,email2,newpaas,confirmpaas,phone;
    public dataholder(EditText name){

    }

    public dataholder(EditText name, EditText email2, EditText newpass, EditText confirmpass, EditText phone) {
        this.email2= email2;
        this.newpaas=newpass;
        this.confirmpaas=confirmpass;
        this.phone= phone;
        this.name= name;

    }

    public EditText getName() {
        return name;
    }

    public void setName(EditText name) {
        this.name = name;
    }

    public EditText getEmail2() {
        return email2;
    }

    public void setEmail2(EditText email2) {
        this.email2 = email2;
    }

    public EditText getNewpaas() {
        return newpaas;
    }

    public void setNewpaas(EditText newpaas) {
        this.newpaas = newpaas;
    }

    public EditText getConfirmpaas() {
        return confirmpaas;
    }

    public void setConfirmpaas(EditText confirmpaas) {
        this.confirmpaas = confirmpaas;
    }

    public EditText getPhone() {
        return phone;
    }

    public void setPhone(EditText phone) {
        this.phone = phone;
    }
}
