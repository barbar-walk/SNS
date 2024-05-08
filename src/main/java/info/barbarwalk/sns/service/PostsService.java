package info.barbarwalk.sns.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import info.barbarwalk.sns.dto.RequestShare;
import info.barbarwalk.sns.entity.PostImages;
import info.barbarwalk.sns.entity.Posts;
import info.barbarwalk.sns.mybatis.PostsMapper;
import info.barbarwalk.sns.mybatis.entity.PostsMappingEntity;
import info.barbarwalk.sns.repository.PostImagesRepository;
import info.barbarwalk.sns.repository.PostsRepository;
import lombok.extern.log4j.Log4j2;

/**
 * 投稿関連サービスクラス。
 *
 * @author barbar-walk
 */
@Log4j2
@Service
public class PostsService {

	/** Mapperインターフェース。 */
	@Autowired
	private PostsMapper postsMapper;

	/** リポジトリインターフェース。 */
	@Autowired
	private PostsRepository repository;

	/** 投稿関連リポジトリインターフェース。 */
	@Autowired
	private PostImagesRepository postsImagesRepository;

	/**
	 * 投稿処理を行う。
	 *
	 * @param requestShare コメント投稿DTO
	 * @param usersId ユーザーID
	 * @param postImagesFileUri 投稿画像URI
	 */
	public void save(RequestShare requestShare, Long usersId, String postImagesFileUri) {
		log.info("投稿処理を行います。：requestShare={}, usersId={}, postImagesFileUri={}", requestShare, usersId,
				postImagesFileUri);

		Posts posts = new Posts();
		posts.setUsersId(usersId);
		posts.setTitle(requestShare.getTitle());
		posts.setBody(requestShare.getBody());

		// 投稿データの登録及び、取得。
		Posts regPosts = repository.save(posts);
		Long postsId = regPosts.getId();

		if (postImagesFileUri != null) {
			PostImages postImages = new PostImages();
			postImages.setPostsId(postsId);
			postImages.setUsersId(usersId);
			postImages.setImageUri(postImagesFileUri);
			postsImagesRepository.save(postImages);
		}
	}

	/**
	 * 投稿情報を取得する。
	 *
	 * @param maxId 指定されたIDよりも古いものを取得する。
	 * @param page ページ
	 * @return ページング制御付きの投稿情報を返す。
	 */
	public Page<Posts> findAllPosts(Long maxId, Integer page) {
		List<Order> orderList = new ArrayList<Order>();
		orderList.add(new Order(Direction.DESC, "id"));

		Pageable pageable = PageRequest.of(page, 10, Sort.by(orderList));

		return repository.findByIdLessThan(maxId, pageable);
	}

	/**
	 * 投稿一覧を取得する。
	 * 投稿IDの降順。
	 *
	 * @return 投稿一覧を返す。
	 */
	public List<Posts> findAllPosts() {
		return (List<Posts>) repository.findByOrderByIdDesc();
	}

	/**
	 * 投稿一覧を取得する。
	 * 投稿IDの降順。
	 * @param usersId ユーザーID
	 * @return 投稿一覧を返す。
	 */
	public List<Posts> findByUsersId(Long usersId) {
		return (List<Posts>) repository.findByUsersIdOrderByIdDesc(usersId);
	}

	/**
	 * 投稿テーブルより除外ユーザーID以外の投稿最新情報を取得する。
	 *
	 * @param excludedUsersId 除外ユーザーID
	 * @return 投稿最新情報を返す。
	 */
	public List<PostsMappingEntity> getNewPosts(Long excludedUsersId) {
		return postsMapper.getNewPosts(excludedUsersId);
	}

}
