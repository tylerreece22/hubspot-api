package com.hubspot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {
    private String addedAt;
    private String vid;
    @JsonProperty("canonical-vid")
    private String canonicalVid;
    @JsonProperty("merged-vids")
    private String[] mergedVids;

    @JsonProperty("portal-id")
    private String portalId;
    @JsonProperty("is-contact")
    private String isContact;
    @JsonProperty("profile-token")
    private String profileToken;
    @JsonProperty("profile-url")
    private String profileUrl;
    private Properties properties;
    @JsonProperty("form-submissions")
    private String[] formSubmissions;
    @JsonProperty("identity-profiles")
    private IdentityProfile[] identityProfiles;
    @JsonProperty("merge-audits")
    private ArrayList<String> mergeAudits;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private class IdentityProfile {
        private String vid;
        @JsonProperty("saved-at-timestamp")
        private String savedAtTimestamp;
        @JsonProperty("deleted-changed-timestamp")
        private String deletedChangedTimstamp;
        @JsonProperty("identity-profiles")
        private Identity[] identities;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private class Identity {
        private String type;
        private String value;
        private String timestamp;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private class Properties {
        Map<String, String> firstname = new HashMap<>();
    }
}

