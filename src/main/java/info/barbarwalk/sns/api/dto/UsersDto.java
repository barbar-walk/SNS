package info.barbarwalk.sns.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザーEntityクラス。
 *
 * @author barbar-walk
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UsersDto extends DtoBase {

	/** ID */
	private Long id;

	/** ログインID */
	private String loginId;

	/** パスワード */
	private String password;

	/** 名前 */
	private String name;

	/** メールアドレス */
	private String emailAddress;

	/** プロフィールアイコンURI */
	private String iconUri;

	/** プロフィール */
	private String profile;
}
