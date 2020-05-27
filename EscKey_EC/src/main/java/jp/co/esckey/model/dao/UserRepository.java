package jp.co.esckey.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.esckey.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByUserNameAndPassword(String userName,String password);


	/*LogiFormから渡されるユーザー情報（ユーザー名、パスワード）を条件にDB検索するためのDAO(UserRepository)を作成*/
}

