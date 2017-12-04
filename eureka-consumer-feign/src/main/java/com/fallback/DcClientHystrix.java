package com.fallback;

import com.feign.DcClient;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2017/11/21.
 */
@Component
public class DcClientHystrix implements DcClient {
    @Override
    public String consumer() {
        System.out.println("hello fallback");
        return "this message send failed";
    }
}
