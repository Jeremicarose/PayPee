package com.arose.phonepee.model;

public class TransactionModel {
    private String txn_date,tnx_med,tnx_dealer,tnx_amt,tnx_amt_cd;
    private  int img_tnx_way;

    public TransactionModel(String txn_date, String tnx_med, String tnx_dealer, String tnx_amt, String tnx_amt_cd, int img_tnx_way) {
        this.txn_date = txn_date;
        this.tnx_med = tnx_med;
        this.tnx_dealer = tnx_dealer;
        this.tnx_amt = tnx_amt;
        this.tnx_amt_cd = tnx_amt_cd;
        this.img_tnx_way = img_tnx_way;
    }

    public String getTxn_date() {
        return txn_date;
    }

    public void setTxn_date(String txn_date) {
        this.txn_date = txn_date;
    }

    public String getTnx_med() {
        return tnx_med;
    }

    public void setTnx_med(String tnx_med) {
        this.tnx_med = tnx_med;
    }

    public String getTnx_dealer() {
        return tnx_dealer;
    }

    public void setTnx_dealer(String tnx_dealer) {
        this.tnx_dealer = tnx_dealer;
    }

    public String getTnx_amt() {
        return tnx_amt;
    }

    public void setTnx_amt(String tnx_amt) {
        this.tnx_amt = tnx_amt;
    }

    public String getTnx_amt_cd() {
        return tnx_amt_cd;
    }

    public void setTnx_amt_cd(String tnx_amt_cd) {
        this.tnx_amt_cd = tnx_amt_cd;
    }

    public int getImg_tnx_way() {
        return img_tnx_way;
    }

    public void setImg_tnx_way(int img_tnx_way) {
        this.img_tnx_way = img_tnx_way;
    }
}
