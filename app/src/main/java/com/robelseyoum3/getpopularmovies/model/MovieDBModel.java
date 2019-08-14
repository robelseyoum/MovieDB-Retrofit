
package com.robelseyoum3.getpopularmovies.model;

        import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class MovieDBModel {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

//    private List<com.robelseyoum3.getpopularmovies.model.Result> results = null;


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Result> getResults() {
        return results;
    }

//    public List<com.robelseyoum3.getpopularmovies.model.Result> getResults() {
//        return results;
//    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

//    public void setResults(List<com.robelseyoum3.getpopularmovies.model.Result> results) {
//        this.results = results;
//    }

}