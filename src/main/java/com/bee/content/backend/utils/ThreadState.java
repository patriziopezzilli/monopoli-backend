package com.bee.content.backend.utils;

public enum ThreadState {
    INSTANCE;

    private ThreadLocal<String> merchant = new ThreadLocal<>();

    public void setMerchant(String tid) {
        merchant.set(tid);
    }

    public String getMerchant() {
        return merchant.get();
    }
}
