package FrescoPlay.Springboot.HandsOn2.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import FrescoPlay.Springboot.HandsOn2.Entity.News;
import FrescoPlay.Springboot.HandsOn2.Results.Results;

@Service

public class NewsService {

	private String apiKey = "gIIWu7P82GBslJAd0MUSbKMrOaqHjWOo";

	private RestTemplate restTemplate = new RestTemplate();

	private JSONObject jsonObject;

	private JSONArray jsonArray;

	private Results[] resultsArray;

	private News news = new News();

	public News getTopStories() throws Exception {

		List<News> topNewsStories = new ArrayList<>();

		String Url = "https://api.nytimes.com/svc/topstories/v2/home.json?api-key=" + apiKey;

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity entity = new HttpEntity(headers);

		ResponseEntity<Map> newsList = restTemplate.exchange(Url, HttpMethod.GET, entity, Map.class);

		if (newsList.getStatusCode() == HttpStatus.OK) {

			jsonObject = new JSONObject(newsList.getBody());

			jsonArray = jsonObject.getJSONArray("results");

			resultsArray = new Results[jsonArray.length()];

			for (int i = 0; i < jsonArray.length(); i++) {

				news.setTitle(jsonArray.getJSONObject(i).get("title").toString());

				news.setSection(jsonArray.getJSONObject(i).get("section").toString());

				resultsArray[i] = new Results();

				resultsArray[i].setTitle(jsonArray.getJSONObject(i).get("title").toString());

				news.setResults(resultsArray);

				topNewsStories.add(news);

			}

		}

		return topNewsStories.get(0);

	}

}
