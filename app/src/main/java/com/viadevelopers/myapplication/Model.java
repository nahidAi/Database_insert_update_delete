package com.viadevelopers.myapplication;
// در کلاس مدل نیازی به وارد کردن باتن ها نیست چون قرار نیست چیزی بهشون ست کنیم یا چیزی ازشون بگیریم.


public class Model {
    private int id;
   // private int btnDelete;
   // private int btnEdit;
    private String txtUser;
    private String txtPass;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //public int getBtnDelete() {
       // return btnDelete;
   // }

   /* public void setBtnDelete(int btnDelete) {
        this.btnDelete = btnDelete;
    }*/

   /* public int getBtnEdit() {
        return btnEdit;
    }*/

   /* public void setBtnEdit(int btnEdit) {
        this.btnEdit = btnEdit;
    }*/

    public String getTxtUser() {
        return txtUser;
    }

    public void setTxtUser(String txtUser) {
        this.txtUser = txtUser;
    }

    public String getTxtPass() {
        return txtPass;
    }

    public void setTxtPass(String txtPass) {
        this.txtPass = txtPass;
    }
}

