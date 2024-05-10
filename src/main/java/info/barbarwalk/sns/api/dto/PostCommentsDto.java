package info.barbarwalk.sns.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 投稿コメントEntityクラス。
 *
 * @author barbar-walk
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PostCommentsDto extends DtoBase {

	/** ID */
	private Long id;

	/** 投稿ID */
	private Long postsId;

	/** ユーザーID */
	private Long usersId;

	/** コメント */
	private String comment;

	/** ユーザー情報の紐づけ */
	private UsersDto users;
}
