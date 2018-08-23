package com.hubspot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Identity {
    private String type;
    private String value;
    private String timestamp;
}

