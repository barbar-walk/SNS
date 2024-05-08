package info.barbarwalk.sns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import info.barbarwalk.sns.core.annotation.LoginCheck;
import info.barbarwalk.sns.dto.RequestComment;
import info.barbarwalk.sns.dto.RequestShare;
import info.barbarwalk.sns.entity.Posts;
import info.barbarwalk.sns.mybatis.entity.PostsMappingEntity;
import info.barbarwalk.sns.service.PostsService;
import info.barbarwalk.sns.service.StorageService;
import info.barbarwalk.sns.util.StringUtil;
import lombok.extern.log4j.Log4j2;

/**
 * ホーム画面コントローラー。
 *
 * @author barbar-walk
 */
@LoginCheck
@Log4j2
@Controller
@RequestMapping("/home")
public class HomeController extends AppController {

	/** ファイルアップロード関連サービスクラス。 */
	@Autowired
	private StorageService storageService;

	/** ユーザー関連サービスクラス。 */
	@Autowired
	private PostsService postsService;

	/**
	 * [GET]ホーム画面のアクション。
	 *
	 * @param model 入力フォームのオブジェクト
	 * @return テンプレートpath
	 */
	@GetMapping(path = { "", "/" })
	public String index(Model model) {
		log.info("ホーム画面のアクションが呼ばれました。");

		if (!model.containsAttribute("requestShare")) {
			model.addAttribute("requestShare", new RequestShare());
		}
		if (!model.containsAttribute("requestComment")) {
			model.addAttribute("requestComment", new RequestComment());
		}

		// ログインユーザー情報取得。
		Long usersId = getUsersId();

		// 投稿一覧取得。
		List<Posts> postsList = postsService.findAllPosts();
		model.addAttribute("postsList", postsList);

		Long maxId = 0L;
		if (postsList != null && !postsList.isEmpty()) {
			int length = postsList.size() - 1;
			maxId = postsList.get(length).getId();
		}

		// ニュース一覧取得。
		List<PostsMappingEntity> newsList = postsService.getNewPosts(usersId);
		model.addAttribute("newsList", newsList);

		// TODO ダミーID
		model.addAttribute("maxId", 5);

		return "home/index";
	}

	/**
	 * [POST]自身のコメント投稿アクション。
	 *
	 * @param requestShare 入力フォームの内容
	 * @param result バリデーション結果
	 * @param postImagesFile マルチパートリクエストで受信したアップロードファイル
	 * @param redirectAttributes リダイレクト時に使用するオブジェクト
	 * @return テンプレートpath
	 */
	@PostMapping("/share")
	public String share(@Validated @ModelAttribute RequestShare requestShare,
			BindingResult result,
			@RequestParam("postImagesFile") MultipartFile postImagesFile,
			RedirectAttributes redirectAttributes) {

		log.info("コメント投稿処理のアクションが呼ばれました。：requestShare={}", requestShare);

		// バリデーション。
		if (result.hasErrors()) {
			log.warn("バリデーションエラーが発生しました。：requestShare={}, result={}", requestShare, result);

			redirectAttributes.addFlashAttribute("validationErrors", result);
			redirectAttributes.addFlashAttribute("requestShare", requestShare);

			// 入力画面へリダイレクト。
			return "redirect:/home";
		}

		// ファイルチェックを行う。
		if (!StorageService.isImageFile(postImagesFile)) {
			log.warn("指定されたファイルは、画像ファイルではありません。：requestShare={}", requestShare);

			// エラーメッセージをセット。
			result.rejectValue("profileFileHidden", StringUtil.BLANK, "画像ファイルを指定してください。");

			redirectAttributes.addFlashAttribute("validationErrors", result);
			redirectAttributes.addFlashAttribute("requestShare", requestShare);

			// 入力画面へリダイレクト。
			return "redirect:/home";
		}

		// ログインユーザー情報取得。
		Long usersId = getUsersId();

		// ファイルアップロード処理。
		String postImagesFileUri = storageService.store(postImagesFile);

		// コメント登録処理。
		postsService.save(requestShare, usersId, postImagesFileUri);

		return "redirect:/home";
	}
}
