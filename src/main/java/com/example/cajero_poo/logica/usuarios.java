package com.example.cajero_poo.logica;

public class usuarios {
    int id;
    String user;
    StringBuilder PIN = new StringBuilder();
    double saldo;
    String telefono;
    public usuarios() {

    }
    public usuarios(int id) {
        this.id = id;
    }
    public usuarios(String PIN) {
        this.PIN = new StringBuilder(PIN);
    }
    public usuarios(int id,String user,String PIN) {
        this.id = id;
        this.user = user;
        this.PIN = new StringBuilder(PIN);
    }
    public usuarios(int id,String PIN) {
        this.id = id;
        this.PIN = new StringBuilder(PIN);
    }
    public usuarios(int id,String user,String PIN,double saldo,String telefono) {
        this.id = id;
        this.user= user;
        this.PIN.append(PIN);
        this.saldo = saldo;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }
    public String toString() {
        return "Id: "+id+"\nUser:"+user+"\nPIN: "+PIN+"\nSaldo Actual: "+saldo+"\nTelefono: "+telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public StringBuilder getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN.append(PIN);
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
