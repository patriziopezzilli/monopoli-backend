package com.bee.content.backend.utils;

public class MerchantUtils {
    public static final String MERCHANT_HEADER_KEY = "M-ID";

    public static void validateMerchant(String merchant) {
        if (null == merchant) {
            throw new IllegalAccessError("Header " + MERCHANT_HEADER_KEY + " is missing.");
        }

        System.out.println("> set merchant " + merchant);
        ThreadState.INSTANCE.setMerchant(merchant);
    }
}
