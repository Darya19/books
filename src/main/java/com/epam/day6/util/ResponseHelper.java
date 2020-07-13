package com.epam.day6.util;

import com.epam.day6.response.ErrorCode;
import com.epam.day6.response.Response;
import com.epam.day6.response.Status;

import static com.epam.day6.response.Status.ERROR;

public class ResponseHelper {

    public static <T> Response<T> makeOkResponse(T result) {
        return new Response<>(Status.OK, ErrorCode.NONE, result);
    }

    public static <T> Response<T> makeErrorResponse(ErrorCode errorCode) {
        return new Response<>(ERROR, errorCode, null);
    }
}
