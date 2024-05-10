package info.barbarwalk.sns.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import info.barbarwalk.sns.AppConst;
import info.barbarwalk.sns.AppPageWrapper;
import info.barbarwalk.sns.api.PostApiController.Response.PageInfo;
import info.barbarwalk.sns.api.dto.PostsDto;
import info.barbarwalk.sns.entity.Posts;
import info.barbarwalk.sns.entity.Users;
import info.barbarwalk.sns.service.PostsService;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * 投稿に関するRestAPI.
 *
 * @author barbar-walk
 */
@Log4j2
@RestController
@RequestMapping("/api/post")
public class PostApiController {

	/**
	 * セッション情報。
	 *   ※本来のRestAPIでは状態を保持しないアーキテクチャの為セッションを使うのはNGだが、
	 *    ローカルでのみ動かすことを想定している為、一旦セッションを使う方法で。
	 *    しっかり実装する場合は、トークンを発行して認証を行う必要がある。
	 */
	@Autowired
	private HttpSession session;

	/** ユーザー関連サービスクラス。 */
	@Autowired
	private PostsService postsService;


	/**
	 * 投稿一覧を取得する。
	 *
	 * @param maxId 指定されたIDよりも古いものを取得する。
	 * @return
	 * @throws JsonProcessingException
	 */
	@GetMapping(value = "/getPosts")
	public Response getPosts(@RequestParam(defaultValue = "0") Long maxId) throws JsonProcessingException {
		Response response = new Response(Response.RESPONSE_CODE_SUCCESS);
		PageInfo pageInfo = new PageInfo();
		System.out.println(maxId);

		// ※セッションから取得する実装は本来なら無し。トークンを生成するAPIを事前に呼び出し、トークンと紐づくユーザーを取得すべき。
		Users users = (Users) session.getAttribute(AppConst.SESSION_KEY_LOGIN_INFO);
		log.info(users);

		// ユーザー情報が取得できなかったらエラー。
		if (users == null) {
			response.setResponseCode(Response.RESPONSE_CODE_ERROR);
			return response;
		}

		// 投稿一覧取得。
		Page<Posts> pagePosts = postsService.findAllPosts(maxId, 0);
		AppPageWrapper<Posts> pager = new AppPageWrapper<Posts>(pagePosts);
		List<Posts> postsList = pagePosts.getContent();

		Long retMaxId = 0L;
		for (Posts posts : postsList) {
			retMaxId = posts.getId();
		}

		pageInfo.setHasNext(pager.isHasNextPage());
		pageInfo.setMaxId(retMaxId);

		// マッパーオブジェクトを使ってDTOにマッピング。
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		String jsonAsString = mapper.writeValueAsString(postsList);
		List<PostsDto> data = mapper.readValue(jsonAsString, new TypeReference<List<PostsDto>>() {});

		response.setData(data);
		response.setPageInfo(pageInfo);

		log.info(response);

		return response;
	}

	/**
	 * レスポンスデータ。
	 */
	@Data
	@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
	public static class Response {

		/** レスポンスコード：-1.失敗 */
		public static final int RESPONSE_CODE_ERROR = -1;
		/** レスポンスコード：0.成功 */
		public static final int RESPONSE_CODE_SUCCESS = 0;

		/** レスポンスコード：0.成功、-1.失敗 */
		private Integer responseCode;

		/** ページ情報。 */
		private PageInfo pageInfo;

		/** 取得結果。 */
		private List<PostsDto> data;

		/**
		 * コンストラクタ。
		 *
		 * @param responseCode レスポンスコード
		 */
		public Response(Integer responseCode) {
			this.responseCode = responseCode;
		}

		/**
		 * ページ情報。
		 */
		@Data
		@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
		public static class PageInfo {

			/** 指定されたIDよりも古いものを取得する為のID。 */
			private Long maxId = 0L;

			/** 次のページがあるか、否か。 */
			private boolean hasNext = false;
		}
	}
}
