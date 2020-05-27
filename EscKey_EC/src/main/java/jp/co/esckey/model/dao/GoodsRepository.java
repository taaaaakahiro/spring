package jp.co.esckey.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.esckey.model.entity.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
	
	
}



/*全商品をgoodsテーブルから検索するためのDAO（GoodsRepository）を作成する*/
