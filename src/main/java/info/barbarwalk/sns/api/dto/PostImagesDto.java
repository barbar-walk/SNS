package info.barbarwalk.sns.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 投稿画像Entityクラス。
 *
 * @author barbar-walk
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PostImagesDto extends DtoBase {

	/** ID */
	private Long id;

	/** 投稿ID */
	private Long postsId;

	/** ユーザーID */
	private Long usersId;

	/** 投稿画像URI */
	private String imageUri;
}
