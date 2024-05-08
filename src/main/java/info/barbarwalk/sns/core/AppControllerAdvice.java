package info.barbarwalk.sns.core;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.log4j.Log4j2;

/**
 * アプリケーション例外ハンドリングクラス。
 *
 * ※独自の例外をハンドリングしたい場合や、例外処理をカスタマイズしたい場合に実装する。
 * 特に処理を必要としない場合は、 {@code src/main/resources/templates/error/}
 * フォルダにステータスコードに合わせてファイルを用意するだけで参照される。
 *
 * @author barbar-walk
 * @see <a href="https://b1san-blog.com/post/spring/spring-error/">【Spring Boot】エラーハンドリング（REST API）</a>
 * @see <a href="https://dkssksk.com/springbootxceptionhandler/">SpringBootで例外処理を行う方法【丁寧に解説します】</a>
 */
@Log4j2
@ControllerAdvice
public class AppControllerAdvice extends ResponseEntityExceptionHandler {

	/**
	 * 例外ハンドリング。（500 システムエラー）
	 * ※ハンドルしきれなかった例外をハンドルする処理。500エラー（システムエラー）画面を表示する。
	 *
	 * @param exception 例外
	 * @return テンプレートpath
	 */
	@ExceptionHandler(Exception.class)
	public String handleOtherException(Exception exception) {
		log.error(exception, exception);
		return "error/500";
	}

	/**
	 * 例外ハンドリング。（404 Not Found）
	 * ※AppNotFoundExceptionクラス、もしくはAppNotFoundExceptionクラスを継承した子クラスをハンドルする処理。
	 * 　404エラー（Not Found）画面を表示する。
	 *
	 * @param exception 例外
	 * @return テンプレートpath
	 */
	@ExceptionHandler(AppNotFoundException.class)
	public String handleOtherException(AppNotFoundException exception) {
		log.error(exception, exception);
		return "error/404";
	}
}
