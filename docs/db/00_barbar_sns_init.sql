/* スキーマ（DB）作成 */
CREATE SCHEMA IF NOT EXISTS `barbar_sns` DEFAULT CHARACTER SET utf8 ;

/* ユーザー作成 */
CREATE USER 'barbar_sns_user'@'localhost' IDENTIFIED BY 'barbar_pass';

/* ユーザー権限設定 */
GRANT ALL PRIVILEGES ON barbar_sns.* TO 'barbar_sns_user'@'localhost';
FLUSH PRIVILEGES;

/* ユーザー削除（※為念、消す方法。コメントを外して使用する。） */
-- DROP USER 'barbar_sns_user'@'localhost';
