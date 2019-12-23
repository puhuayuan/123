package edu.swjtuhc.demo.controller;

import static org.hamcrest.CoreMatchers.nullValue;

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

	
	@RequestMapping(value = "/query", method=RequestMethod.POST)
	@ResponseBody
	public List<News> getNews() {
	    
	   List<News> list=new ArrayList<>();
	    list =  newsServiceImpl.getAllnews();
	   
	    return list;
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
	   News news=newsServiceImpl.getnewsId(newsId);
	   mm.put("news", news);
	    return news;
	}

	/**
	 * 更新新闻 
	 */
	@RequestMapping(value = "/updateNews",method=RequestMethod.POST)
	@ResponseBody
	public String updateNews( String author,  String content ,  int newsId, String imgurl, String datetime, String title, int typeId, String state ) {
	    
	   News news= newsServiceImpl.getnewsId(newsId);
	 
		   news.setAuthor(author);
		   news.setContent(content);
		   news.setDatetime(datetime);
		   news.setImgurl(imgurl);
		   
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
	@ResponseBody
	public String delete(int newsId) {
	    newsServiceImpl.deleteNews(newsId);
	    return "已删除";
	}

	/**
	 * 添加新闻
	 * @return 
	 * 传入的对象有点多
	 * 业务逻辑需要再整理一下
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
	
	@RequestMapping(value = "/classify", method = RequestMethod.POST)
	@ResponseBody
	public List<News> classify(int typeId) {
		 
		 List<News> list=newsServiceImpl.findAllNewsBYtypeId(typeId);
		 
		 return list;
		
		
	}
	@RequestMapping(value = "/classifybyName", method = RequestMethod.GET)
	@ResponseBody
	public List<News> classifybyName(String typename) {
		 
		 List<News> list=newsServiceImpl.findAllNewsBYtypeName(typename);
		 
		 return list;
		
		
	}
}
