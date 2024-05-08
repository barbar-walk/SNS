package info.barbarwalk.sns.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import info.barbarwalk.sns.entity.Friends;

/**
 * フレンド関連リポジトリインターフェース。
 *
 * @author barbar-walk
 */
public interface FriendsRepository extends PagingAndSortingRepository<Friends, Long>, CrudRepository<Friends, Long> {

	/**
	 * フレンド検索を行う。
	 *
	 * @param loginUsersId ログインユーザーID
	 * @param friendsUsersId フレンドユーザーID
	 * @return フレンド情報を返す。
	 */
	Friends findFirstByUsersIdAndFriendUsersId(@Param("usersId") Long loginUsersId,
			@Param("friendUsersId") Long friendsUsersId);

	/**
	 * フレンド検索を行う。
	 *
	 * @param loginUsersId ログインユーザーID
	 * @return フレンド一覧を返す。
	 */
	List<Friends> findByUsersId(@Param("usersId") Long loginUsersId);
}
