package com.kiosccourtade.kiosc_api.exception;

import com.kiosccourtade.kiosc_api.dto.ProductDTO;
import org.springframework.http.HttpStatus;

public class FillFieldsException extends RuntimeException implements ApiException {
    public FillFieldsException(Object dto, String requiredFields) {
        super("Incomplete data" + (dto != null ? ": " + dto : "") +
                ". Required fields: " + requiredFields);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
