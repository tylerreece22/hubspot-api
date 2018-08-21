package com.hubspot.dto;

import java.util.List;
import java.util.Map;

public class Contact {
    private String addedAt;
    private String vid;
    private String canonicalVid;
    private List<String> mergedVids;
    private String portalId;
    private String isContact;
    private String profileToken;
    private String profileUrl;
    private Map properties;
    private List<String> formSubmissions;
    private List<IdentityProfile> identityProfiles;
    private List<String> mergeAudits;

    private class IdentityProfile {
        private String vid;
        private String savedAtTimestamp;
        private String deletedChangedTimstamp;
        private List<Identity> identities;
    }

    private class Identity {
        private String type;
        private String value;
        private String timestamp;
    }
}

