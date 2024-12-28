package com.esunbank.voting.online_voting_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esunbank.voting.online_voting_system.entity.VoteItem;
import com.esunbank.voting.online_voting_system.entity.VoteRecord;
import com.esunbank.voting.online_voting_system.repository.VoteItemRepository;
import com.esunbank.voting.online_voting_system.repository.VoteRecordRepository;

@Service
public class VoteService {
	
	@Autowired
	private VoteItemRepository voteItemRepository;
	
	@Autowired
	private VoteRecordRepository voteRecordRepository;
	
	public VoteService(VoteItemRepository voteItemRepository, VoteRecordRepository voteRecordRepository) {
        this.voteItemRepository = voteItemRepository;
        this.voteRecordRepository = voteRecordRepository;
    }
	
	public List<VoteItem> getAllVoteItems() {
        return voteItemRepository.findAll();
    }
	
	public VoteItem addVoteItem(VoteItem voteItem) {
        return voteItemRepository.save(voteItem);
    }
	
 	public void deleteVoteItem(Long itemId) {
        if (!voteItemRepository.existsById(itemId)) {
            throw new RuntimeException("投票項目不存在");
        }
        voteItemRepository.deleteById(itemId);
    }
	
 	@Transactional
	public void vote(String voterName, Long itemId) {
 		// 插入投票紀錄
	    VoteRecord voteRecord = new VoteRecord();
	    voteRecord.setVoterName(voterName);
	    voteRecord.setItemId(itemId);
	    voteRecordRepository.save(voteRecord);

	    // 更新投票項目的票數
	    VoteItem voteItem = voteItemRepository.findById(itemId).orElseThrow();
	    voteItem.setVotesCount(voteItem.getVotesCount() + 1);
	    voteItemRepository.save(voteItem);
	    
	    // 防止投票者名字爲空
	    if (voterName == null || voterName.isEmpty()) {
            throw new RuntimeException("投票人名稱無效");
        }
	}

 	// 多選投票邏輯
 	@Transactional
    public void voteMultiple(String voterName, List<Long> itemIds) {
        for (Long itemId : itemIds) {
            if (!voteItemRepository.existsById(itemId)) {
                throw new RuntimeException("投票項目不存在: " + itemId);
            }

            // 記錄投票
            VoteRecord voteRecord = new VoteRecord();
            voteRecord.setVoterName(voterName);
            voteRecord.setItemId(itemId);
            voteRecordRepository.save(voteRecord);

            // 更新票數
            VoteItem voteItem = voteItemRepository.findById(itemId).orElseThrow();
            voteItem.setVotesCount(voteItem.getVotesCount() + 1);
            voteItemRepository.save(voteItem);
        }
    }
}
