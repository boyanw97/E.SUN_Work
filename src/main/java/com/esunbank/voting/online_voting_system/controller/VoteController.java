package com.esunbank.voting.online_voting_system.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esunbank.voting.online_voting_system.dto.VoteRequestDto;
import com.esunbank.voting.online_voting_system.entity.VoteItem;
import com.esunbank.voting.online_voting_system.service.VoteService;

@RestController
@RequestMapping("/api/votes")
@CrossOrigin(origins = {"http://localhost:8080", "http://127.0.0.1:5500"})
public class VoteController {
	
	private VoteService voteService;
	
	public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }
	
	// 顯示所有投票項目
    @GetMapping
    public List<VoteItem> getAllVoteItems() {
        return voteService.getAllVoteItems();
    }
    
    // 新增投票項目
    @PostMapping
    public VoteItem addVoteItem(@RequestBody VoteItem voteItem) {
        return voteService.addVoteItem(voteItem);
    }
    
    // 刪除投票項目
    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteVoteItem(@PathVariable Long itemId) {
        voteService.deleteVoteItem(itemId);
        return ResponseEntity.noContent().build(); // 返回 404 No Content
    }
    
    // 投票
    @PostMapping("/{itemId}/vote")
    public void vote(@RequestParam String voterName, @PathVariable Long itemId) {
        voteService.vote(voterName, itemId);
    }
    
    // 多選投票 
    @PostMapping("/vote")
    public ResponseEntity<Void> voteMultiple(@RequestBody VoteRequestDto request) {
        voteService.voteMultiple(request.getVoterName(), request.getItemIds());
        return ResponseEntity.ok().build();
    }
}
