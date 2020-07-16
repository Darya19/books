package com.epam.day6.util;

import com.epam.day6.response.ErrorCode;
import com.epam.day6.response.Response;
import com.epam.day6.response.Status;

import java.util.Optional;

public class ResponseHelper {

    public static <T> Response makeOkResponse(T result) {
        return new Response<>(Status.OK, ErrorCode.NONE, result);
    }

    public static Response makeErrorResponse(ErrorCode errorCode) {
        return new Response<>(Status.ERROR, errorCode, Optional.empty());
    }
}
