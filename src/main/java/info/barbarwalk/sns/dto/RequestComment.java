package info.barbarwalk.sns.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * コメント投稿DTOクラス。
 *
 * @author barbar-walk
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RequestComment extends DtoBase {

	/** 本文 */
	@NotBlank(message = "コメント本文を入力してください。")
	@Size(max = 2000, message = "コメント本文は最大2000文字です。")
	private String comment;
}
