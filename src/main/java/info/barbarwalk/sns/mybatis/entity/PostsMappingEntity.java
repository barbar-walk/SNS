package info.barbarwalk.sns.mybatis.entity;

import java.util.Date;

import lombok.Data;

/**
 * MyBatis投稿テーブルより除外ユーザーID以外の投稿最新情報を取得するマッパーEntityクラス。
 *
 * @author barbar-walk
 */
@Data
public class PostsMappingEntity {

	/** ID */
	private Long id;

	/** ユーザーID */
	private Long usersId;

	/** タイトル */
	private String title;

	/** 本文 */
	private String body;

	/** 作成日時 */
	private Date created;

	/** 投稿画像URI */
	private String imageUri;

	/** 名前 */
	private String name;

	/** プロフィールアイコンURI */
	private String iconUri;
}
