package edu.swjtuhc.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.swjtuhc.demo.model.News;

@Mapper
public interface NewsDao {

	 News getTitle();

	 News getnewsId(int newsId) ;

	void updateNews(News news);

	void deleteNews(int newsId);

	 void insertNews(News news) ;

	News getnewstypeId(int typeId);

	List<News> findAllNewsBytypeId(int typeId);

	List<News> findAllNewsBytypeName(String typename);

	List<News> getAllnews();

	
}
