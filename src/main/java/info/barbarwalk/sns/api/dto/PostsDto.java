package info.barbarwalk.sns.api.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 投稿Entityクラス。
 *
 * @author barbar-walk
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PostsDto extends DtoBase {

	/** ID */
	private Long id;

	/** ユーザーID */
	private Long usersId;

	/** タイトル */
	private String title;

	/** 本文 */
	private String body;

	/** 投稿画像情報の紐づけ */
	private List<PostImagesDto> postImagesList;

	/** 投稿コメント情報の紐づけ */
	private List<PostCommentsDto> postCommentsList;

	/** ユーザー情報の紐づけ */
	private UsersDto users;
}
