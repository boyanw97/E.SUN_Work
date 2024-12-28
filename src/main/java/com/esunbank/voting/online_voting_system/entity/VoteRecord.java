package com.esunbank.voting.online_voting_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "voterecord")
public class VoteRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 使主鍵自動生成
	@Column(name = "record_id")  // 主鍵對應資料庫 record_id
	private Long recordId;
	
	@Column(name = "voter_name")  // 主鍵對應資料庫 voter_name
	private String voterName;
	
	@Column(name = "item_id")  // 主鍵對應資料庫 item_id
	private Long itemId;

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public String getVoterName() {
		return voterName;
	}

	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
}
