package info.barbarwalk.sns.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ショルダー確認用コントローラー。
 * ※ショルダー（ヘッダー、フッター、その他ショルダー）の見栄えを確認するためのコントローラー。
 *
 * @author barbar-walk
 */
@Controller
@RequestMapping("/shoulder")
public class ShoulderController {

	/**
	 * [GET]ショルダー確認用アクション。
	 *
	 * @return テンプレートpath
	 */
	@GetMapping(path = {"", "/"})
	public String indes() {
		return "common/shoulder_fragment";
	}
}
