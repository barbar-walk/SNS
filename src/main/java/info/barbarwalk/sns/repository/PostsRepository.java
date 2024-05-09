package info.barbarwalk.sns.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import info.barbarwalk.sns.entity.Posts;

/**
 * 投稿関連リポジトリインターフェース。
 *
 * @author barbar-walk
 */
public interface PostsRepository extends PagingAndSortingRepository<Posts, Long>, CrudRepository<Posts, Long> {

	/**
	 * 投稿一覧を取得する。
	 * 投稿IDの降順。
	 *
	 * @return 投稿一覧を返す。
	 */
	List<Posts> findByOrderByIdDesc();

	/**
	 * 投稿一覧を取得する。
	 * 投稿IDの降順。
	 *
	 * @return 投稿一覧を返す。
	 */
	Page<Posts> findAllByOrderByIdDesc(Pageable pageable);

	/**
	 * 投稿一覧を取得する。
	 * 投稿IDの降順。
	 *
	 * @param usersId ユーザーID
	 * @return 投稿一覧を返す。
	 */
	List<Posts> findByUsersIdOrderByIdDesc(Long usersId);

	/**
	 * 投稿情報を取得する。
	 *
	 * @param maxId 指定されたIDよりも古いものを取得する。
	 * @return 投稿一覧を返す。
	 */
	Page<Posts> findByIdLessThan(Long maxId, Pageable pageable);
}
