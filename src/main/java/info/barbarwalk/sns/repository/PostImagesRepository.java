package info.barbarwalk.sns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import info.barbarwalk.sns.entity.PostImages;

/**
 * 投稿画像関連リポジトリインターフェース。
 *
 * @author barbar-walk
 */
public interface PostImagesRepository
		extends PagingAndSortingRepository<PostImages, Long>, CrudRepository<PostImages, Long> {
}
