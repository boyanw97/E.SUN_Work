DROP DATABASE IF EXISTS esunbank;

-- 建立資料庫
CREATE DATABASE esunbank;

SHOW DATABASES;

-- 使用資料庫
USE esunbank;

-- 建立投票項目表
CREATE TABLE VoteItem (
    item_id INT AUTO_INCREMENT PRIMARY KEY, -- 投票項目編號
    item_name VARCHAR(255) NOT NULL,        -- 投票項目名稱
    votes_count INT DEFAULT 0              -- 累積票數
);

-- 建立投票紀錄表
CREATE TABLE VoteRecord (
    record_id INT AUTO_INCREMENT PRIMARY KEY, -- 紀錄編號
    voter_name VARCHAR(255) NOT NULL,         -- 投票人名稱
    item_id INT NOT NULL,                     -- 投票項目編號 (外鍵)
    FOREIGN KEY (item_id) REFERENCES VoteItem(item_id)
);

