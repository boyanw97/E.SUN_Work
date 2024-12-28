package com.esunbank.voting.online_voting_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esunbank.voting.online_voting_system.entity.VoteRecord;

public interface VoteRecordRepository extends JpaRepository<VoteRecord, Long> {

}
