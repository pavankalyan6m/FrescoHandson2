package FrescoPlay.Springboot.HandsOn2.Entity;

import FrescoPlay.Springboot.HandsOn2.Results.Results;

public class News {

	private String section;

	private Results[] results;

	private String title;

	public Results[] getResults() {

		return results;

	}

	public void setResults(Results[] results) {

		this.results = results;

	}

	public String getSection() {

		return section;

	}

	public void setSection(String section) {

		this.section = section;

	}

	public String getTitle() {

		return title;

	}

	public void setTitle(String title) {

		this.title = title;

	}

}
