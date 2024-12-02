package com.example.googlesearch;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;

@WebService(name = "GoogleSearchService", targetNamespace = "urn:GoogleSearch")
public interface GoogleSearchService {

    @WebMethod(operationName = "doGetCachedPage")
    @XmlMimeType("application/octet-stream")
    byte[] doGetCachedPage(
        @WebParam(name = "key") String key,
        @WebParam(name = "url") String url);

    @WebMethod(operationName = "doSpellingSuggestion")
    String doSpellingSuggestion(
        @WebParam(name = "key") String key,
        @WebParam(name = "phrase") String phrase);

    @WebMethod(operationName = "doGoogleSearch")
    GoogleSearchResult doGoogleSearch(
        @WebParam(name = "key") String key,
        @WebParam(name = "q") String query,
        @WebParam(name = "start") int startIndex,
        @WebParam(name = "maxResults") int maxResults,
        @WebParam(name = "filter") boolean documentFiltering,
        @WebParam(name = "restrict") String restrict,
        @WebParam(name = "safeSearch") boolean safeSearch,
        @WebParam(name = "lr") String languageRestrict,
        @WebParam(name = "ie") String inputEncoding,
        @WebParam(name = "oe") String outputEncoding);
}

class GoogleSearchResult {
    private int estimatedTotalResultsCount;
    private boolean documentFiltering;
    private boolean estimateIsExact;
    private String searchQuery;
    private int startIndex;
    private int endIndex;
    private double searchTime;
    private ResultElement[] resultElements;


    public static class ResultElement {
        private String summary;
        private String URL;
        private String snippet;
        private String title;
        private String cachedSize;
        private boolean relatedInformationPresent;
        private String hostName;
        private DirectoryCategory directoryCategory;
        private String directoryTitle;
    }

    public static class DirectoryCategory {
        private String fullViewableName;
        private String specialEncoding;
    }
}
