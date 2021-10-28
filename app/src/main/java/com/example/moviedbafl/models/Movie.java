package com.example.moviedbafl.models;

import com.google.gson.Gson;

import java.util.List;

public class Movie {
    public static class NowPlayingUpcoming {
        private Dates dates;
        private int page;
        private List<Results> results;
        private int total_pages;
        private int total_results;

        public static NowPlayingUpcoming objectFromData(String str) {

            return new com.google.gson.Gson().fromJson(str, NowPlayingUpcoming.class);
        }

        public Dates getDates() {
            return dates;
        }

        public void setDates(Dates dates) {
            this.dates = dates;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public List<Results> getResults() {
            return results;
        }

        public void setResults(List<Results> results) {
            this.results = results;
        }

        public int getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(int total_pages) {
            this.total_pages = total_pages;
        }

        public int getTotal_results() {
            return total_results;
        }

        public void setTotal_results(int total_results) {
            this.total_results = total_results;
        }

        public static class Dates {
            private String maximum;
            private String minimum;

            public static Dates objectFromData(String str) {

                return new com.google.gson.Gson().fromJson(str, Dates.class);
            }

            public String getMaximum() {
                return maximum;
            }

            public void setMaximum(String maximum) {
                this.maximum = maximum;
            }

            public String getMinimum() {
                return minimum;
            }

            public void setMinimum(String minimum) {
                this.minimum = minimum;
            }
        }

        public static class Results {
            private boolean adult;
            private String backdrop_path;
            private List<Integer> genre_ids;
            private int id;
            private String original_language;
            private String original_title;
            private String overview;
            private double popularity;
            private String poster_path;
            private String release_date;
            private String title;
            private boolean video;
            private double vote_average;
            private int vote_count;

            public static Results objectFromData(String str) {

                return new com.google.gson.Gson().fromJson(str, Results.class);
            }

            public boolean isAdult() {
                return adult;
            }

            public void setAdult(boolean adult) {
                this.adult = adult;
            }

            public String getBackdrop_path() {
                return backdrop_path;
            }

            public void setBackdrop_path(String backdrop_path) {
                this.backdrop_path = backdrop_path;
            }

            public List<Integer> getGenre_ids() {
                return genre_ids;
            }

            public void setGenre_ids(List<Integer> genre_ids) {
                this.genre_ids = genre_ids;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getOriginal_language() {
                return original_language;
            }

            public void setOriginal_language(String original_language) {
                this.original_language = original_language;
            }

            public String getOriginal_title() {
                return original_title;
            }

            public void setOriginal_title(String original_title) {
                this.original_title = original_title;
            }

            public String getOverview() {
                return overview;
            }

            public void setOverview(String overview) {
                this.overview = overview;
            }

            public double getPopularity() {
                return popularity;
            }

            public void setPopularity(double popularity) {
                this.popularity = popularity;
            }

            public String getPoster_path() {
                return poster_path;
            }

            public void setPoster_path(String poster_path) {
                this.poster_path = poster_path;
            }

            public String getRelease_date() {
                return release_date;
            }

            public void setRelease_date(String release_date) {
                this.release_date = release_date;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public boolean isVideo() {
                return video;
            }

            public void setVideo(boolean video) {
                this.video = video;
            }

            public double getVote_average() {
                return vote_average;
            }

            public void setVote_average(double vote_average) {
                this.vote_average = vote_average;
            }

            public int getVote_count() {
                return vote_count;
            }

            public void setVote_count(int vote_count) {
                this.vote_count = vote_count;
            }
        }
    }

    public static class Details {

        private boolean adult;
        private String backdrop_path;
        private BelongsToCollection belongs_to_collection;
        private int budget;
        private List<Genres> genres;
        private String homepage;
        private int id;
        private String imdb_id;
        private String original_language;
        private String original_title;
        private String overview;
        private double popularity;
        private String poster_path;
        private List<ProductionCompanies> production_companies;
        private List<ProductionCountries> production_countries;
        private String release_date;
        private int revenue;
        private int runtime;
        private List<SpokenLanguages> spoken_languages;
        private String status;
        private String tagline;
        private String title;
        private boolean video;
        private double vote_average;
        private int vote_count;

        public static Details objectFromData(String str) {

            return new com.google.gson.Gson().fromJson(str, Details.class);
        }

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public BelongsToCollection getBelongs_to_collection() {
            return belongs_to_collection;
        }

        public void setBelongs_to_collection(BelongsToCollection belongs_to_collection) {
            this.belongs_to_collection = belongs_to_collection;
        }

        public int getBudget() {
            return budget;
        }

        public void setBudget(int budget) {
            this.budget = budget;
        }

        public List<Genres> getGenres() {
            return genres;
        }

        public void setGenres(List<Genres> genres) {
            this.genres = genres;
        }

        public String getHomepage() {
            return homepage;
        }

        public void setHomepage(String homepage) {
            this.homepage = homepage;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImdb_id() {
            return imdb_id;
        }

        public void setImdb_id(String imdb_id) {
            this.imdb_id = imdb_id;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public List<ProductionCompanies> getProduction_companies() {
            return production_companies;
        }

        public void setProduction_companies(List<ProductionCompanies> production_companies) {
            this.production_companies = production_companies;
        }

        public List<ProductionCountries> getProduction_countries() {
            return production_countries;
        }

        public void setProduction_countries(List<ProductionCountries> production_countries) {
            this.production_countries = production_countries;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public int getRevenue() {
            return revenue;
        }

        public void setRevenue(int revenue) {
            this.revenue = revenue;
        }

        public int getRuntime() {
            return runtime;
        }

        public void setRuntime(int runtime) {
            this.runtime = runtime;
        }

        public List<SpokenLanguages> getSpoken_languages() {
            return spoken_languages;
        }

        public void setSpoken_languages(List<SpokenLanguages> spoken_languages) {
            this.spoken_languages = spoken_languages;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTagline() {
            return tagline;
        }

        public void setTagline(String tagline) {
            this.tagline = tagline;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public static class BelongsToCollection {
            private int id;
            private String name;
            private String poster_path;
            private String backdrop_path;

            public static BelongsToCollection objectFromData(String str) {

                return new com.google.gson.Gson().fromJson(str, BelongsToCollection.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPoster_path() {
                return poster_path;
            }

            public void setPoster_path(String poster_path) {
                this.poster_path = poster_path;
            }

            public String getBackdrop_path() {
                return backdrop_path;
            }

            public void setBackdrop_path(String backdrop_path) {
                this.backdrop_path = backdrop_path;
            }
        }

        public static class Genres {
            private int id;
            private String name;

            public static Genres objectFromData(String str) {

                return new com.google.gson.Gson().fromJson(str, Genres.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class ProductionCompanies {
            private int id;
            private String logo_path;
            private String name;
            private String origin_country;

            public static ProductionCompanies objectFromData(String str) {

                return new com.google.gson.Gson().fromJson(str, ProductionCompanies.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLogo_path() {
                return logo_path;
            }

            public void setLogo_path(String logo_path) {
                this.logo_path = logo_path;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getOrigin_country() {
                return origin_country;
            }

            public void setOrigin_country(String origin_country) {
                this.origin_country = origin_country;
            }
        }

        public static class ProductionCountries {
            private String iso_3166_1;
            private String name;

            public static ProductionCountries objectFromData(String str) {

                return new com.google.gson.Gson().fromJson(str, ProductionCountries.class);
            }

            public String getIso_3166_1() {
                return iso_3166_1;
            }

            public void setIso_3166_1(String iso_3166_1) {
                this.iso_3166_1 = iso_3166_1;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class SpokenLanguages {
            private String english_name;
            private String iso_639_1;
            private String name;

            public static SpokenLanguages objectFromData(String str) {

                return new com.google.gson.Gson().fromJson(str, SpokenLanguages.class);
            }

            public String getEnglish_name() {
                return english_name;
            }

            public void setEnglish_name(String english_name) {
                this.english_name = english_name;
            }

            public String getIso_639_1() {
                return iso_639_1;
            }

            public void setIso_639_1(String iso_639_1) {
                this.iso_639_1 = iso_639_1;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class Credits {

        private int id;
        private List<Cast> cast;
        private List<Crew> crew;

        public static Credits objectFromData(String str) {

            return new Gson().fromJson(str, Credits.class);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<Cast> getCast() {
            return cast;
        }

        public void setCast(List<Cast> cast) {
            this.cast = cast;
        }

        public List<Crew> getCrew() {
            return crew;
        }

        public void setCrew(List<Crew> crew) {
            this.crew = crew;
        }

        public static class Cast {
            private boolean adult;
            private int gender;
            private int id;
            private String known_for_department;
            private String name;
            private String original_name;
            private double popularity;
            private String profile_path;
            private int cast_id;
            private String character;
            private String credit_id;
            private int order;

            public static Cast objectFromData(String str) {

                return new Gson().fromJson(str, Cast.class);
            }

            public boolean isAdult() {
                return adult;
            }

            public void setAdult(boolean adult) {
                this.adult = adult;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getKnown_for_department() {
                return known_for_department;
            }

            public void setKnown_for_department(String known_for_department) {
                this.known_for_department = known_for_department;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getOriginal_name() {
                return original_name;
            }

            public void setOriginal_name(String original_name) {
                this.original_name = original_name;
            }

            public double getPopularity() {
                return popularity;
            }

            public void setPopularity(double popularity) {
                this.popularity = popularity;
            }

            public String getProfile_path() {
                return profile_path;
            }

            public void setProfile_path(String profile_path) {
                this.profile_path = profile_path;
            }

            public int getCast_id() {
                return cast_id;
            }

            public void setCast_id(int cast_id) {
                this.cast_id = cast_id;
            }

            public String getCharacter() {
                return character;
            }

            public void setCharacter(String character) {
                this.character = character;
            }

            public String getCredit_id() {
                return credit_id;
            }

            public void setCredit_id(String credit_id) {
                this.credit_id = credit_id;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }
        }

        public static class Crew {
            private boolean adult;
            private int gender;
            private int id;
            private String known_for_department;
            private String name;
            private String original_name;
            private double popularity;
            private String profile_path;
            private String credit_id;
            private String department;
            private String job;

            public static Crew objectFromData(String str) {

                return new Gson().fromJson(str, Crew.class);
            }

            public boolean isAdult() {
                return adult;
            }

            public void setAdult(boolean adult) {
                this.adult = adult;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getKnown_for_department() {
                return known_for_department;
            }

            public void setKnown_for_department(String known_for_department) {
                this.known_for_department = known_for_department;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getOriginal_name() {
                return original_name;
            }

            public void setOriginal_name(String original_name) {
                this.original_name = original_name;
            }

            public double getPopularity() {
                return popularity;
            }

            public void setPopularity(double popularity) {
                this.popularity = popularity;
            }

            public String getProfile_path() {
                return profile_path;
            }

            public void setProfile_path(String profile_path) {
                this.profile_path = profile_path;
            }

            public String getCredit_id() {
                return credit_id;
            }

            public void setCredit_id(String credit_id) {
                this.credit_id = credit_id;
            }

            public String getDepartment() {
                return department;
            }

            public void setDepartment(String department) {
                this.department = department;
            }

            public String getJob() {
                return job;
            }

            public void setJob(String job) {
                this.job = job;
            }
        }
    }

    public static class Recommendations {

        private int page;
        private List<Results> results;
        private int total_pages;
        private int total_results;

        public static Recommendations objectFromData(String str) {

            return new Gson().fromJson(str, Recommendations.class);
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public List<Results> getResults() {
            return results;
        }

        public void setResults(List<Results> results) {
            this.results = results;
        }

        public int getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(int total_pages) {
            this.total_pages = total_pages;
        }

        public int getTotal_results() {
            return total_results;
        }

        public void setTotal_results(int total_results) {
            this.total_results = total_results;
        }

        public static class Results {
            private boolean adult;
            private String backdrop_path;
            private List<Integer> genre_ids;
            private int id;
            private String media_type;
            private String title;
            private String original_language;
            private String original_title;
            private String overview;
            private double popularity;
            private String poster_path;
            private String release_date;
            private boolean video;
            private double vote_average;
            private int vote_count;

            public static Results objectFromData(String str) {

                return new Gson().fromJson(str, Results.class);
            }

            public boolean isAdult() {
                return adult;
            }

            public void setAdult(boolean adult) {
                this.adult = adult;
            }

            public String getBackdrop_path() {
                return backdrop_path;
            }

            public void setBackdrop_path(String backdrop_path) {
                this.backdrop_path = backdrop_path;
            }

            public List<Integer> getGenre_ids() {
                return genre_ids;
            }

            public void setGenre_ids(List<Integer> genre_ids) {
                this.genre_ids = genre_ids;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMedia_type() {
                return media_type;
            }

            public void setMedia_type(String media_type) {
                this.media_type = media_type;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getOriginal_language() {
                return original_language;
            }

            public void setOriginal_language(String original_language) {
                this.original_language = original_language;
            }

            public String getOriginal_title() {
                return original_title;
            }

            public void setOriginal_title(String original_title) {
                this.original_title = original_title;
            }

            public String getOverview() {
                return overview;
            }

            public void setOverview(String overview) {
                this.overview = overview;
            }

            public double getPopularity() {
                return popularity;
            }

            public void setPopularity(double popularity) {
                this.popularity = popularity;
            }

            public String getPoster_path() {
                return poster_path;
            }

            public void setPoster_path(String poster_path) {
                this.poster_path = poster_path;
            }

            public String getRelease_date() {
                return release_date;
            }

            public void setRelease_date(String release_date) {
                this.release_date = release_date;
            }

            public boolean isVideo() {
                return video;
            }

            public void setVideo(boolean video) {
                this.video = video;
            }

            public double getVote_average() {
                return vote_average;
            }

            public void setVote_average(double vote_average) {
                this.vote_average = vote_average;
            }

            public int getVote_count() {
                return vote_count;
            }

            public void setVote_count(int vote_count) {
                this.vote_count = vote_count;
            }
        }
    }
}
