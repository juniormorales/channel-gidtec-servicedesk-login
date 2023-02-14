package com.pe.gidtec.servicedesk.login.util;

import com.pe.gidtec.servicedesk.login.model.response.ResultResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ResponseUtil {

    public <T> ResponseEntity<ResultResponse<T>> getResponseEntityStatus(ResultResponse<T> response) {
        if( response.getResponseCode().equals("00")) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        } else {
            response.setData(null);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }
}
