package info.barbarwalk.sns.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import info.barbarwalk.sns.core.annotation.LoginCheck;
import info.barbarwalk.sns.dto.RequestComment;
import info.barbarwalk.sns.service.PostCommentsService;
import lombok.extern.log4j.Log4j2;

/**
 * 投稿コメントコントローラー。
 *
 * @author barbar-walk
 */
@LoginCheck
@Log4j2
@Controller
@RequestMapping("/comment")
public class CommentController extends AppController {

	/** 投稿コメント関連サービスクラス。 */
	@Autowired
	private PostCommentsService postCommentsService;

	/**
	 * [POST]記事コメント投稿アクション。
	 *
	 * @param referer リファラー
	 * @param postsId 投稿ID
	 * @param requestComment 入力フォームの内容
	 * @param result バリデーション結果
	 * @param redirectAttributes リダイレクト時に使用するオブジェクト
	 * @return テンプレートpath
	 * @throws URISyntaxException 例外
	 */
	@PostMapping("/{postsId}")
	public String index(
			@RequestHeader("Referer") String referer,
			@PathVariable("postsId") String postsId,
			@Validated @ModelAttribute RequestComment requestComment,
			BindingResult result,
			RedirectAttributes redirectAttributes) throws URISyntaxException {

		log.info("コメント投稿処理のアクションが呼ばれました。：requestComment={}, referer={}", requestComment, referer);

		// バリデーション。
		if (result.hasErrors()) {
			log.warn("バリデーションエラーが発生しました。：requestComment={}, result={}", requestComment, result);

			Map<Long, BindingResult> errorMap = new HashMap<Long, BindingResult>();
			errorMap.put(Long.parseLong(postsId), result);

			redirectAttributes.addFlashAttribute("validationCommentErrors", errorMap);
			redirectAttributes.addFlashAttribute("requestComment", requestComment);

			// 入力画面へリダイレクト。
			return "redirect:" + new URI(referer).getPath() + "#comment_" + postsId;
		}

		// TODO バリデーション（投稿ID：投稿が実際に存在するかチェックを入れる。）
		Long lPostsId = Long.parseLong(postsId);

		// ログインユーザー情報取得。
		Long usersId = getUsersId();

		// コメント登録処理。
		postCommentsService.save(requestComment, lPostsId, usersId);

		return "redirect:" + new URI(referer).getPath() + "#comment_" + postsId;
	}
}
