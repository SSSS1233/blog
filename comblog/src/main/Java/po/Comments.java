package po;

public class Comments {
  private Long id;
  private Long article_id;
  private String comm_ip;
  private String comment;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getArticle_id() {
    return article_id;
  }

  public void setArticle_id(Long article_id) {
    this.article_id = article_id;
  }

  public String getComm_ip() {
    return comm_ip;
  }

  public void setComm_ip(String comm_ip) {
    this.comm_ip = comm_ip;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
