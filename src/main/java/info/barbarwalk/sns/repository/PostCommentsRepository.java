package info.barbarwalk.sns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import info.barbarwalk.sns.entity.PostComments;

/**
 * 投稿コメント関連リポジトリインターフェース。
 *
 * @author barbar-walk
 */
public interface PostCommentsRepository
		extends PagingAndSortingRepository<PostComments, Long>, CrudRepository<PostComments, Long> {
}
