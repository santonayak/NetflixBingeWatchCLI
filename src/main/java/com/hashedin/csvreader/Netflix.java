package com.hashedin.csvreader;

import java.sql.Blob;

public class Netflix {

	private String showId;
	private String type;
	private String name;
	private String director;
	private String cast;
	private String country;
	private String date_added;
	private String release_year;
	private String season_code;
	private String season_count;
	private String category;
	private String description;

	public Netflix(String showId, String type, String name, String director, String cast, String country, String date_added, String release_year, String season_code, String season_count, String category, String description) {
		this.showId = showId;
		this.type = type;
		this.name = name;
		this.director = director;
		this.cast = cast;
		this.country = country;
		this.date_added = date_added;
		this.release_year = release_year;
		this.season_code = season_code;
		this.season_count = season_count;
		this.category = category;
		this.description = description;
	}


	public String getShowId() {
		return showId;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getDirector() {
		return director;
	}

	public String getCast() {
		return cast;
	}

	public String getCountry() {
		return country;
	}

	public String getDate_added() {
		return date_added;
	}

	public String getRelease_year() {
		return release_year;
	}

	public String getSeason_code() {
		return season_code;
	}

	public String getSeason_count() {
		return season_count;
	}

	public String getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}
}
