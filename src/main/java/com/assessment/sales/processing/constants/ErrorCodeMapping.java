package com.assessment.sales.processing.constants;

public enum ErrorCodeMapping {
    SNP_EXCEPTION_001("SNP_EXCEPTION_001","SNP_EXCEPTION_001 - Invalid Notification Message Received"),
    SNP_EXCEPTION_002("SNP_EXCEPTION_002","SNP_EXCEPTION_002 - Invalid Adjustment Operation"),
    SNP_EXCEPTION_003("SNP_EXCEPTION_003","SNP_EXCEPTION_003 - Not a valid JSON msg")
    ;

    private String name;
    private String value;

    ErrorCodeMapping(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }


}
