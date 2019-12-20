package edu.swjtuhc.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.swjtuhc.demo.model.News;

import edu.swjtuhc.demo.serviceImpl.NewsServiceImpl;
import edu.swjtuhc.demo.serviceImpl.TuserServiceImpl;

@RequestMapping("/news")
@Controller
public class NewsController {
	@Autowired
	 private NewsServiceImpl newsServiceImpl;
	 
	
	public ModelAndView getIndex(Map<String, Object> map) {
	    List<News> list = new ArrayList<News>();     // 获取区域列表
	    list = newsServiceImpl.getListNews();
	    map.put("list", list);
	    return new ModelAndView("index3", map);
	}
	/**
	 * 根据标题得到新闻
	 * @return 
	 */
	@RequestMapping(value = "/querybyTitle", method=RequestMethod.POST)
	@ResponseBody
	public News getNews(@RequestParam("title") String title) {
	    
	   News news = new News();
	    news =  newsServiceImpl.getTitle();
	   
	    return news;
	}

	/**
	 * 根据id获取新闻
	 */
	@RequestMapping(value = "/querybyId", method = RequestMethod.GET)
	@ResponseBody
	public News getNewsById(int newsId) {
	    Map<String, Object> mm = new HashMap<String, Object>();
	    News news =newsServiceImpl.getnewsId(newsId);
	    mm.put("news", news);
	    return news;
	}

	/**
	 * 更新新闻
	 */
	@RequestMapping(value = "/updateUser",method=RequestMethod.POST)
	@ResponseBody
	public String updateNews(@RequestParam("author") String author, @RequestParam("content") String content,@RequestParam("datetime") String datetime,@RequestParam("imgurl") String imgurl,@RequestParam("newsId") int newsId,@RequestParam("state") String state,@RequestParam("title") String title,@RequestParam("typeId") int typeId) {
	    News news = newsServiceImpl.getnewsId(newsId);
	    news.setAuthor(author);
	    news.setContent(content);
	    news.setDatetime(datetime);
	    news.setImgurl(imgurl);
	    news.setNewsId(newsId);
	    news.setState(state);
	    news.setTitle(title);
	    news.setTypeId(typeId);
	    newsServiceImpl.updateNews(news);
	    return "success";
	}

	/**
	 * 删除新闻
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(int newsId) {
	    newsServiceImpl.deleteNews(newsId);
	    return newsId+"已删除";
	}

	/**
	 * 添加新闻
	 * @return 
	 */
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public News save( String author,  String content, String datetime, String imgurl, int newsId, String state, String title, int typeId) {
	    News news = new News();
	    news.setAuthor(author);
	    news.setContent(content);
	    news.setDatetime(datetime);
	    news.setImgurl(imgurl);
	    news.setNewsId(newsId);
	    news.setState(state);
	    news.setTitle(title);
	    news.setTypeId(typeId);
	    newsServiceImpl.insertNews(news);
	    return news;
	}
	
	
	
}
