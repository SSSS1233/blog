package po;


import java.sql.Date;

public class Article {

  private long id;
  private String title;
  private String content;
  private int categoryid;
  private String summary;
  private java.sql.Date date;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getCategoryid() {
    return categoryid;
  }

  public void setCategoryid(int categoryid) {
    this.categoryid = categoryid;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "Article{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", categoryid=" + categoryid +
            ", summary='" + summary + '\'' +
            ", date=" + date +
            '}';
  }
}
