package info.barbarwalk.sns.core;

/**
 * NotFound時に使用する例外クラス。
 *
 * @author barbar-walk
 */
public class AppNotFoundException extends RuntimeException {

	/**
	 * デフォルトコンストラクタ
	 */
	public AppNotFoundException() {
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
	public AppNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * コンストラクタ
	 *
	 * @param message 詳細メッセージ。
	 * @param cause 原因。
	 */
	public AppNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * コンストラクタ
	 *
	 * @param message 詳細メッセージ。
	 */
	public AppNotFoundException(String message) {
		super(message);
	}

	/**
	 * コンストラクタ
	 *
	 * @param cause 原因。
	 */
	public AppNotFoundException(Throwable cause) {
		super(cause);
	}
}
