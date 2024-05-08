package info.barbarwalk.sns.controller;

import org.springframework.beans.factory.annotation.Autowired;

import info.barbarwalk.sns.AppConst;
import info.barbarwalk.sns.entity.Users;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

/**
 * コントローラ基底クラス。
 *
 * @author barbar-walk
 */
@Log4j2
public class AppController {

	/** セッション情報。 */
	@Autowired
	private HttpSession session;

	/**
	 * セッションに格納しているユーザーIDを取得する。
	 *
	 * @return ユーザーID（※セッション情報が取得出来ない場合は、nullを返す。）
	 */
	protected Long getUsersId() {
		// ユーザー情報の取得。
		Users users = (Users) session.getAttribute(AppConst.SESSION_KEY_LOGIN_INFO);

		if (users == null) {
			log.info("セッションにユーザー情報は保存されていません。");
			return null;
		}

		return users.getId();
	}

	/**
	 * セッションに格納しているユーザー情報を取得する。
	 *
	 * @return ユーザー情報（※セッション情報が取得出来ない場合は、nullを返す。）
	 */
	protected Users getUsers() {
		// ユーザー情報の取得。
		Users users = (Users) session.getAttribute(AppConst.SESSION_KEY_LOGIN_INFO);

		if (users == null) {
			log.info("セッションにユーザー情報は保存されていません。");
			return null;
		}

		return users;
	}
}
