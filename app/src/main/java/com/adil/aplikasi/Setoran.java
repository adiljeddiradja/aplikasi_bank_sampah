package com.adil.aplikasi;

public class Setoran {
    private String jenisSampah;
    private double weight;
    private double saldo;

    public Setoran() {
        // Diperlukan konstruktor kosong untuk Firebase
    }

    public Setoran(String jenisSampah, double weight, double saldo) {
        this.jenisSampah = jenisSampah;
        this.weight = weight;
        this.saldo = saldo;
    }

    public String getJenisSampah() {
        return jenisSampah;
    }

    public void setJenisSampah(String jenisSampah) {
        this.jenisSampah = jenisSampah;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
