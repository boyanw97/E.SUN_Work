package com.esunbank.voting.online_voting_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esunbank.voting.online_voting_system.entity.VoteItem;

public interface VoteItemRepository extends JpaRepository<VoteItem, Long> {

    @Query("SELECT v FROM VoteItem v WHERE v.itemName = :itemName")
    List<VoteItem> findByItemName(@Param("itemName") String itemName);
}
