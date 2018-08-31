package com.github.swisscom_blockchain.neo_rpcclient.dto;

import java.util.ArrayList;
import java.util.List;

public class NeoAccountState {
    private int version;
    private String script_hash;
    private boolean frozen;
    private List<Object> votes = new ArrayList<>();

    /**
     * Usually two entries in it. One entry represent NEO balance and the other entry GAS balance.<br />
     * Usually the first entry is GAS and the second NEO.
     */
    private List<NeoAccountBalance> balances = new ArrayList<>();

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getScript_hash() {
        return script_hash;
    }

    public void setScript_hash(String script_hash) {
        this.script_hash = script_hash;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public List<Object> getVotes() {
        return votes;
    }

    public void setVotes(List<Object> votes) {
        this.votes = votes;
    }

    public List<NeoAccountBalance> getBalances() {
        return balances;
    }

    public void setBalances(List<NeoAccountBalance> balances) {
        this.balances = balances;
    }
}
