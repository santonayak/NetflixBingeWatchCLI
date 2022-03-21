package com.hashedin.csvreader;

import java.sql.Blob;

public class Netflix {

	private String showId;
	private String type;
	private String date_added;
	private String name;
	private String director;
	private String cast;
	private String release_year;
	private String season_code;
	private String season_count;
	private String category;
	private String description;
	private String country;

	public Netflix(String showId, String type, String date_added, String name, String director, String cast,
			String release_year, String season_code, String season_count, String category, String description,
			String country) {
		super();
		this.showId = showId;
		this.type = type;
		this.date_added = date_added;
		this.name = name;
		this.director = director;
		this.cast = cast;
		this.release_year = release_year;
		this.season_code = season_code;
		this.season_count = season_count;
		this.category = category;
		this.description = description;
		this.country = country;
	}

	public String getShowId() {
		return showId;
	}

	public String getType() {
		return type;
	}

	public String getDate_added() {
		return date_added;
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

	public String getCountry() {
		return country;
	}

}
