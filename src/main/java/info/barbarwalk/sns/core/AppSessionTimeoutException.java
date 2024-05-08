package info.barbarwalk.sns.core;

/**
 * セッションタイムアウト時に使用する例外クラス。
 * ※NotFoundとして処理。
 *
 * @author barbar-walk
 */
public class AppSessionTimeoutException extends AppNotFoundException {

	/**
	 * デフォルトコンストラクタ
	 */
	public AppSessionTimeoutException() {
		super();
	}

	/**
	 * コンストラクタ
	 *
	 * @param message 詳細メッセージ。
	 * @param cause 原因。
	 * @param enableSuppression 抑制を有効化するか、それとも無効化するか。
	 * @param writableStackTrace スタック・トレースを書込み可能にするかどうか。
	 */
	public AppSessionTimeoutException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * コンストラクタ
	 *
	 * @param message 詳細メッセージ。
	 * @param cause 原因。
	 */
	public AppSessionTimeoutException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * コンストラクタ
	 *
	 * @param message 詳細メッセージ。
	 */
	public AppSessionTimeoutException(String message) {
		super(message);
	}

	/**
	 * コンストラクタ
	 *
	 * @param cause 原因。
	 */
	public AppSessionTimeoutException(Throwable cause) {
		super(cause);
	}
}
