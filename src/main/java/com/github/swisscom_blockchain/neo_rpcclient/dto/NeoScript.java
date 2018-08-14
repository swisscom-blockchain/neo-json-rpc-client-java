package com.github.swisscom_blockchain.neo_rpcclient.dto;


public class NeoScript {
    private String invocation;
    private String verification;

    public String getInvocation() {
        return invocation;
    }

    public void setInvocation(String invocation) {
        this.invocation = invocation;
    }

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }
}
