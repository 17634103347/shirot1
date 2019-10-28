package org.xq.shiro.common;

import java.util.HashMap;
import java.util.Map;

public class JsonResponse {

    /**
     * 返回成功的json串
     * @param status
     * @param msg
     * @param data
     * @return
     */
    public static Map<String,Object> success(int status, String msg, Object data) {
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("status", status);
        result.put("msg", msg);
        if (data !=null)
            result.put("data", data);
        return result;
    }

    public static Map<String,Object> success(int status, String msg) {
        return success(status, msg, null);
    }

    public static Map<String,Object> success(int status) {
        return success(status, "", null);
    }
}
