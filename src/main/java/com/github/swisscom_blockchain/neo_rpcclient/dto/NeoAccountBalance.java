package com.github.swisscom_blockchain.neo_rpcclient.dto;

/**
 * It may represent NEO or GAS.
 */
public class NeoAccountBalance {

    private String asset;
    private String value;

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
