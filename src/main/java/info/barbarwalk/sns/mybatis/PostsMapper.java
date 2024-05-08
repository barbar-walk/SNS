package info.barbarwalk.sns.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import info.barbarwalk.sns.mybatis.entity.PostsMappingEntity;

/**
 * 投稿マッパーインターフェース。
 *
 * @author barbar-walk
 */
@Mapper
public interface PostsMapper {

	/**
	 * 投稿テーブルより除外ユーザーID以外の投稿最新情報を取得する。
	 *
	 * @param excludedUsersId 除外ユーザーID
	 * @return 投稿最新情報を返す。
	 */
	List<PostsMappingEntity> getNewPosts(@Param("excludedUsersId") Long excludedUsersId);
}
