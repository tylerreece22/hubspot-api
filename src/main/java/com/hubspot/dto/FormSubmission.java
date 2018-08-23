package com.hubspot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FormSubmission {
    @JsonProperty("conversion-id")
    private String conversionId;
    private String timestamp;
    @JsonProperty("form-id")
    private String formId;
    @JsonProperty("portal-id")
    private String portalId;
    @JsonProperty("page-url")
    private String pageUrl;
    @JsonProperty("page-title")
    private String pageTitle;
    @JsonProperty("page-id")
    private String pageId;
    private String title;
    @JsonProperty("form-type")
    private String formType;
    @JsonProperty("meta-data")
    private List<String> metaData;

}

