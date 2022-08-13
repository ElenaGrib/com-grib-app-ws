package com.grib.mobile.app.ws.ui.model.responce;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ErrorMessage {
    private Date timestamp;

    public ErrorMessage(Date timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    private String message;


}
