package com.example.until;


import com.example.module.SecnResponse;

public class SecnResponseUtil {


    public SecnResponseUtil() {
    }

    public static SecnResponse ok() {
        return SecnResponse.ok();
    }

    public static SecnResponse ok(Object data) {
        return SecnResponse.ok(data);
    }

    public static SecnResponse fail(String errMsg) {
        return SecnResponse.fail(errMsg);
    }
}
