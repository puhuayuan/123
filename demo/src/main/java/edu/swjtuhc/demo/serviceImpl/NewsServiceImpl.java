package edu.swjtuhc.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.swjtuhc.demo.mapper.NewsDao;
import edu.swjtuhc.demo.mapper.TuserDao;
import edu.swjtuhc.demo.model.News;
import edu.swjtuhc.demo.model.Tuser;

@Service
public class NewsServiceImpl {
	@Autowired
    NewsDao newsDao;
	public List<News> getListNews() {
		// TODO Auto-generated method stub
		return null;
	}

	public News getTitle() {
		// TODO Auto-generated method stub
		return newsDao.getTitle();
	}

	public News getnewsId( int newsId) {
		// TODO Auto-generated method stub
		return newsDao.getnewsId();
	}

	public void updateNews(News news) {
		// TODO Auto-generated method stub
		newsDao.updateNews(news);
	}

	
	public void deleteNews(int newsId) {
		// TODO Auto-generated method stub
		newsDao.deleteNews(newsId);
	}

	public  void insertNews(News news) {
		// TODO Auto-generated method stub
		newsDao.insertNews(news);
	}

	public News getnewstypeId(int typeId) {
		// TODO Auto-generated method stub
		 
		return newsDao.getnewstypeId(typeId);
	}

	public List<News> findAllNewsBYtypeId(int typeId) {
		// TODO Auto-generated method stub
		return newsDao.findAllNewsBytypeId( typeId);
	}

	public List<News> findAllNewsBYtypeName(String typename) {
		// TODO Auto-generated method stub
		return newsDao.findAllNewsBytypeName( typename);
	}

	public List<News> getAllnews() {
		// TODO Auto-generated method stub
		return newsDao.getAllnews();
	}

}
