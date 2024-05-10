package info.barbarwalk.sns.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * フレンドEntityクラス。
 *
 * @author barbar-walk
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FriendsDto extends DtoBase {

	/** ID */
	private Long id;

	/** ユーザーID */
	private Long usersId;

	/** フレンドユーザーID */
	private Long friendUsersId;

	/** 承認ステータス（1.申請中[自分]、2.承認待ち[相手]、3.承認[自分]、4.承諾[相手]） */
	private Integer approvalStatus;

}
