public class GenericSearch {
    private Problem problem;
    private SearchStrategy searchStrategy;

    public GenericSearch(Problem problem, SearchStrategy searchStrategy) {
        this.problem = problem;
        this.searchStrategy = searchStrategy;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public SearchStrategy getSearchStrategy() {
        return searchStrategy;
    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }
}
