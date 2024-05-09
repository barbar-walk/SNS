package info.barbarwalk.sns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * アプリで使用する定数定義クラス。
 *
 * @author barbar-walk
 */
@Data
@Component
public class AppConst {

	/**
	 * プロパティファイルから読み取る設定値関連。
	 */
	@Data
	@Component
	@ConfigurationProperties(prefix = "app-setting")
	public static class AppSettingProperties {
		/** リスト画面において、1画面に表示する項目数。 */
		private int pageSize;
	}

	/** アプリで使用する定数定義。 */
	@Autowired
	private AppSettingProperties appSettingProperties;

	/** セッションキー：ログイン時のセッション情報。 */
	public static final String SESSION_KEY_LOGIN_INFO = "SESSION_KEY_LOGIN_INFO";

	/** フレンド 承認ステータス：1.申請中[自分] */
	public static final int FRIENDS_APPROVAL_STATUS_IN_PROGRESS = 1;
	/** フレンド 承認ステータス：2.承認待ち[相手] */
	public static final int FRIENDS_APPROVAL_STATUS_REVIEW = 2;
	/** フレンド 承認ステータス：3.承認[自分] */
	public static final int FRIENDS_APPROVAL_STATUS_GRANTED = 3;
	/** フレンド 承認ステータス：4.承諾[相手] */
	public static final int FRIENDS_APPROVAL_STATUS_CONSENT = 4;

	/**
	 * 1画面に表示する項目数。
	 *
	 * @return 1画面に表示する項目数を返す。
	 */
	public int getPageSize() {
		return appSettingProperties.getPageSize();
	}
}
