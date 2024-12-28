-- 插入範例投票項目
INSERT INTO VoteItem (item_name, votes_count) VALUES 
('電腦', 5), 
('滑鼠', 3);

-- 插入範例投票紀錄
INSERT INTO VoteRecord (voter_name, item_id) VALUES 
('Leo', 1), 
('Sandy', 1), 
('Sandy', 2), 
('Randy', 2), 
('RSY', 2);

-- 查詢所有投票項目和票數
SELECT item_id, item_name, votes_count FROM VoteItem;

-- 新增投票項目
INSERT INTO VoteItem (item_name) VALUES ('鍵盤');

-- 更新投票項目名稱
UPDATE VoteItem SET item_name = '螢幕' WHERE item_id = 3;

-- 刪除投票項目
DELETE FROM VoteItem WHERE item_id = 6;

-- 清空表格並重置流水號
TRUNCATE TABLE voteitem;

-- 初始化投票數
SET SQL_SAFE_UPDATES = 0;
UPDATE voteitem SET votes_count = 0 WHERE item_name = '電腦';
SET SQL_SAFE_UPDATES = 1;