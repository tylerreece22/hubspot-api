package com.hubspot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IdentityProfile {
    private String vid;
    @JsonProperty("saved-at-timestamp")
    private String savedAtTimestamp;
    @JsonProperty("deleted-changed-timestamp")
    private String deletedChangedTimstamp;
    @JsonProperty("identity-profiles")
    private List<Identity> identities;
}

