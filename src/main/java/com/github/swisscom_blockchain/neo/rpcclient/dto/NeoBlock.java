package com.github.swisscom_blockchain.neo.rpcclient.dto;

import java.util.ArrayList;
import java.util.List;

public class NeoBlock {
    private String hash;
    private long size;
    private long version;
    private String previousblockhash;
    private String merkleroot;
    private long time;
    private long index;
    private String nonce;
    private String nextconsensus;
    private NeoScript script;
    private List<Object> tx = new ArrayList<>(); //TBD instead object generate dto clazz
    private long confirmations;
    private String nextblockhash;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getPreviousblockhash() {
        return previousblockhash;
    }

    public void setPreviousblockhash(String previousblockhash) {
        this.previousblockhash = previousblockhash;
    }

    public String getMerkleroot() {
        return merkleroot;
    }

    public void setMerkleroot(String merkleroot) {
        this.merkleroot = merkleroot;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getNextconsensus() {
        return nextconsensus;
    }

    public void setNextconsensus(String nextconsensus) {
        this.nextconsensus = nextconsensus;
    }

    public NeoScript getScript() {
        return script;
    }

    public void setScript(NeoScript script) {
        this.script = script;
    }

    public List<Object> getTx() {
        return tx;
    }

    public void setTx(List<Object> tx) {
        this.tx = tx;
    }

    public long getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(long confirmations) {
        this.confirmations = confirmations;
    }

    public String getNextblockhash() {
        return nextblockhash;
    }

    public void setNextblockhash(String nextblockhash) {
        this.nextblockhash = nextblockhash;
    }
}
