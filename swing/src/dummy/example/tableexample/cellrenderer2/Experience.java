package dummy.example.tableexample.cellrenderer2;

public class Experience {
    private String name;
    private Integer directive;
    private Integer done;

    public Experience(String name, Integer directive, Integer done) {
        this.name = name;
        this.directive = directive;
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDirective() {
        return directive;
    }

    public void setDirective(Integer directive) {
        this.directive = directive;
    }

    public Integer getDone() {
        return done;
    }

    public void setDone(Integer done) {
        this.done = done;
    }
}
