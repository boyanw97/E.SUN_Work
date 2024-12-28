package com.esunbank.voting.online_voting_system.dto;

import java.util.List;

public class VoteRequestDto {
    private String voterName;
    private List<Long> itemIds;

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }
}

