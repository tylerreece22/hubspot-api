package com.hubspot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {
    private String addedAt;
    private String vid;
    @JsonProperty("canonical-vid")
    private String canonicalVid;
    @JsonProperty("merged-vids")
    private List<String> mergedVids;
    @JsonProperty("portal-id")
    private String portalId;
    @JsonProperty("is-contact")
    private String isContact;
    @JsonProperty("profile-token")
    private String profileToken;
    @JsonProperty("profile-url")
    private String profileUrl;
    private HashMap properties;
    @JsonProperty("form-submissions")
    private List<FormSubmission> formSubmissions;
    @JsonProperty("identity-profiles")
    private List<IdentityProfile> identityProfiles;
    @JsonProperty("merge-audits")
    private ArrayList<String> mergeAudits;




}

