package model;

import java.util.List;
import java.util.Objects;

public class Root {
  
  private String unit;
  private String publication;
  private String edition;
  private String pubdate;
  private int pages;

  private List<Page> pubPages;

  public Root(String unit, String publication, String edition, String pubdate, int pages, List<Page> pubPages) {
    this.unit = unit;
    this.publication = publication;
    this.edition = edition;
    this.pubdate = pubdate;
    this.pages = pages;
    this.pubPages = pubPages;
  }

  public Root() {
  }

  public String getUnit() {
    return this.unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public String getPublication() {
    return this.publication;
  }

  public void setPublication(String publication) {
    this.publication = publication;
  }

  public String getEdition() {
    return this.edition;
  }

  public void setEdition(String edition) {
    this.edition = edition;
  }

  public String getPubdate() {
    return this.pubdate;
  }

  public void setPubdate(String pubdate) {
    this.pubdate = pubdate;
  }

  public int getPages() {
    return this.pages;
  }

  public void setPages(int pages) {
    this.pages = pages;
  }

  public List<Page> getPubPages() {
    return this.pubPages;
  }

  public void setPubPages(List<Page> pubPages) {
    this.pubPages = pubPages;
  }

  public Root unit(String unit) {
    setUnit(unit);
    return this;
  }

  public Root publication(String publication) {
    setPublication(publication);
    return this;
  }

  public Root edition(String edition) {
    setEdition(edition);
    return this;
  }

  public Root pubdate(String pubdate) {
    setPubdate(pubdate);
    return this;
  }

  public Root pages(int pages) {
    setPages(pages);
    return this;
  }

  public Root pubPages(List<Page> pubPages) {
    setPubPages(pubPages);
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Root)) {
            return false;
        }
        Root root = (Root) o;
        return Objects.equals(unit, root.unit) && Objects.equals(publication, root.publication) && Objects.equals(edition, root.edition) && Objects.equals(pubdate, root.pubdate) && pages == root.pages && Objects.equals(pubPages, root.pubPages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unit, publication, edition, pubdate, pages, pubPages);
  }

  @Override
  public String toString() {
    return "{" +
      " unit='" + getUnit() + "'" +
      ", publication='" + getPublication() + "'" +
      ", edition='" + getEdition() + "'" +
      ", pubdate='" + getPubdate() + "'" +
      ", pages='" + getPages() + "'" +
      ", pubPages='" + getPubPages() + "'" +
      "}";
  }

}
