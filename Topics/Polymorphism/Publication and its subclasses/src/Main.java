class Publication {

    private String title;

    public Publication(String title) {
        this.title = title;
    }

    public final String getInfo() {

        String info;

        info = getType()+" ";

        if(getDetails()!="") {
            info +="("+ getDetails()+"): ";
        }
        info += title;


        return info;
    }

    public String getType() {
        return "Publication:";
    }

    public String getDetails() {
        return "";
    }

}

class Newspaper extends Publication {

    private String source;

    public Newspaper(String title, String source) {
        super(title);
        this.source = source;
    }
    @Override
    public String getType() {
        return "Newspaper";
    }
    @Override
    public String getDetails() {
        return "source - "+ source;
    }

    // write your code here

}

class Article extends Publication {

    private String author;

    public Article(String title, String author) {
        super(title);
        this.author = author;
    }

    // write your code here
    @Override
    public String getType() {
        return "Article";
    }
    @Override
    public String getDetails() {
        return "author - "+ author;
    }

}

class Announcement extends Publication {

    private int daysToExpire;

    public Announcement(String title, int daysToExpire) {
        super(title);
        this.daysToExpire = daysToExpire;
    }

    // write your code here
    @Override
    public String getType() {
        return "Announcement";
    }
    @Override
    public String getDetails() {


        return "days to expire - " + Integer.toString(daysToExpire);
    }

}
