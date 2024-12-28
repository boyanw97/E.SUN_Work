# 投票系統 Voting System

## 專案簡介
提供使用者對多個投票項目進行單選或多選投票，同時具備後台管理功能，用於管理投票項目和查詢投票結果。

## 功能特色

### 前端功能
- 投票功能：
  - 使用者可以從列出的投票項目中進行多選投票，最多選擇 3 個項目。
  - 投票完成後即時刷新頁面，顯示最新的投票結果。
- 數據顯示：
  - 投票項目根據票數從高到低排序顯示。
- 投票限制：
  - 提示使用者最多只能選擇 3 個項目。

### 後台功能
- 投票項目管理：
  - 新增、刪除投票項目。
  - 查看投票結果。
  - 投票結果依票數從高到低排序顯示。

### 安全性功能
- 防止 SQL Injection：使用 Spring Data JPA 和 Hibernate 處理數據庫操作，確保查詢安全性。
- 防止 XSS 攻擊：透過 Spring Security 配置 XSS 保護。
- CORS 支援：允許從特定來源的跨域請求，確保系統的安全與前後端分離的兼容性。

## 使用技術
### 後端技術
- Java 17
- Spring Boot 3.4.1
  - Spring Security
  - Spring Data JPA
- MySQL 8.0

### 前端技術
- HTML5 / CSS
- JavaScript

## 系統架構
### 資料庫結構
資料表 1: VoteItem
| 欄位名稱    | 資料型別     | 說明    |
|-----------|-----------|-----------|
| item_id     | BIGINT     | 投票項目編號（主鍵）     |
| item_name     | VARCHAR(255)     | 投票項目名稱     |
| votes_count     | INT     | 投票累積票數     |

資料表 2: VoteRecord
| 欄位名稱    | 資料型別     | 說明    |
|-----------|-----------|-----------|
| record_id   | BIGINT     | 投票記錄編號（主鍵）     |
| voter_name     | VARCHAR(255)     | 投票人姓名     |
| item_id     | BIGINT     | 投票項目編號（外鍵）     |

## 快速開始
### 環境需求
- Java 17 或以上
- MySQL 8.0
- Maven 3.6+
- 瀏覽器（建議使用 Google Chrome 或 Firefox）

## 聯絡方式
如果您有任何問題，請透過以下方式聯絡：
- Email: boyanw81@gmail.com
- GitHub: boyanw97

感謝支持！
