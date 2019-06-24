package com.apps.devbee.login_pagevoorinc.Model;

public class Transaction {
    private String transactionId;
    private long trasactionTime;
    private float transactionAmount;
    private String transactionSettlementCurrency;
    private String transactionProcessingCurrency;
    private short transactionStatus;
    private String transactionSenderId;
    private String transactionRecipientId;

    public Transaction() {
    }

    public Transaction(String transactionId, long trasactionTime, float transactionAmount, String transactionSettlementCurrency, String transactionProcessingCurrency, short transactionStatus, String transactionSenderId, String transactionRecipientId) {
        this.transactionId = transactionId;
        this.trasactionTime = trasactionTime;
        this.transactionAmount = transactionAmount;
        this.transactionSettlementCurrency = transactionSettlementCurrency;
        this.transactionProcessingCurrency = transactionProcessingCurrency;
        this.transactionStatus = transactionStatus;
        this.transactionSenderId = transactionSenderId;
        this.transactionRecipientId = transactionRecipientId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setTrasactionTime(Long trasactionTime) {
        this.trasactionTime = trasactionTime;
    }

    public void setTransactionAmount(float transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void setTransactionSettlementCurrency(String transactionSettlementCurrency) {
        this.transactionSettlementCurrency = transactionSettlementCurrency;
    }

    public void setTransactionProcessingCurrency(String transactionProcessingCurrency) {
        this.transactionProcessingCurrency = transactionProcessingCurrency;
    }

    public void setTransactionStatus(Short transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public void setTransactionSenderId(String transactionSenderId) {
        this.transactionSenderId = transactionSenderId;
    }

    public void setTransactionRecipientId(String transactionRecipientId) {
        this.transactionRecipientId = transactionRecipientId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Long getTrasactionTime() {
        return trasactionTime;
    }

    public float getTransactionAmount() {
        return transactionAmount;
    }

    public String getTransactionSettlementCurrency() {
        return transactionSettlementCurrency;
    }

    public String getTransactionProcessingCurrency() {
        return transactionProcessingCurrency;
    }

    public Short getTransactionStatus() {
        return transactionStatus;
    }

    public String getTransactionSenderId() {
        return transactionSenderId;
    }

    public String getTransactionRecipientId() {
        return transactionRecipientId;
    }

}
