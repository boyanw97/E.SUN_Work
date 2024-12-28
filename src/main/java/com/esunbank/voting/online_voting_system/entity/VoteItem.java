package com.esunbank.voting.online_voting_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "voteitem")
public class VoteItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 使主鍵自動生成
	@Column(name = "item_id")  // 主鍵對應資料庫 item_id
	private Long itemId;
	
	@Column(name = "item_name")  // 主鍵對應資料庫 item_name
	private String itemName;
	
	@Column(name = "votes_count")  // 主鍵對應資料庫 votes_count
	private int votesCount;
	
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getVotesCount() {
		return votesCount;
	}
	public void setVotesCount(int votesCount) {
		this.votesCount = votesCount;
	}
}
