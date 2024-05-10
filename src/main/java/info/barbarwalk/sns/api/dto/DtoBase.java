package info.barbarwalk.sns.api.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Entity基底クラス。
 * ※共通のカラムを定義する。
 *
 * @author barbar-walk
 */
@Data
public class DtoBase implements Serializable {

	/** 作成日時 */
	private Date created;

	/** 更新日時 */
	private Date updated;
}
