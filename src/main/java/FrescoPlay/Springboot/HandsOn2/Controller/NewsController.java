package FrescoPlay.Springboot.HandsOn2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import FrescoPlay.Springboot.HandsOn2.Entity.News;
import FrescoPlay.Springboot.HandsOn2.Service.NewsService;

@RestController

@RequestMapping("/api")

public class NewsController {

	@Autowired

	NewsService newsService;

	@RequestMapping(value = "/news/topstories", method = RequestMethod.GET)

	public News getNews() throws Exception {

		return newsService.getTopStories();

	}

}
