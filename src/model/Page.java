package model;

import java.util.Objects;

public class Page {
  
  private int physical_page_number;
  private int logical_page_number;
  private String base_editions;
  private int height;
  private int width;
  private int color;
  private String unique_id;
  private String modifier;
  private String section;
  private int dps;

  public Page(int physical_page_number, int logical_page_number, String base_editions, int height, int width, int color, String unique_id, String modifier, String section, int dps) {
    this.physical_page_number = physical_page_number;
    this.logical_page_number = logical_page_number;
    this.base_editions = base_editions;
    this.height = height;
    this.width = width;
    this.color = color;
    this.unique_id = unique_id;
    this.modifier = modifier;
    this.section = section;
    this.dps = dps;
  }

  public Page() {
  }

  public int getPhysical_page_number() {
    return this.physical_page_number;
  }

  public void setPhysical_page_number(int physical_page_number) {
    this.physical_page_number = physical_page_number;
  }

  public int getLogical_page_number() {
    return this.logical_page_number;
  }

  public void setLogical_page_number(int logical_page_number) {
    this.logical_page_number = logical_page_number;
  }

  public String getBase_editions() {
    return this.base_editions;
  }

  public void setBase_editions(String base_editions) {
    this.base_editions = base_editions;
  }

  public int getHeight() {
    return this.height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return this.width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getColor() {
    return this.color;
  }

  public void setColor(int color) {
    this.color = color;
  }

  public String getUnique_id() {
    return this.unique_id;
  }

  public void setUnique_id(String unique_id) {
    this.unique_id = unique_id;
  }

  public String getModifier() {
    return this.modifier;
  }

  public void setModifier(String modifier) {
    this.modifier = modifier;
  }

  public String getSection() {
    return this.section;
  }

  public void setSection(String section) {
    this.section = section;
  }

  public int getDps() {
    return this.dps;
  }

  public void setDps(int dps) {
    this.dps = dps;
  }

  public Page physical_page_number(int physical_page_number) {
    setPhysical_page_number(physical_page_number);
    return this;
  }

  public Page logical_page_number(int logical_page_number) {
    setLogical_page_number(logical_page_number);
    return this;
  }

  public Page base_editions(String base_editions) {
    setBase_editions(base_editions);
    return this;
  }

  public Page height(int height) {
    setHeight(height);
    return this;
  }

  public Page width(int width) {
    setWidth(width);
    return this;
  }

  public Page color(int color) {
    setColor(color);
    return this;
  }

  public Page unique_id(String unique_id) {
    setUnique_id(unique_id);
    return this;
  }

  public Page modifier(String modifier) {
    setModifier(modifier);
    return this;
  }

  public Page section(String section) {
    setSection(section);
    return this;
  }

  public Page dps(int dps) {
    setDps(dps);
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Page)) {
            return false;
        }
        Page page = (Page) o;
        return physical_page_number == page.physical_page_number && logical_page_number == page.logical_page_number && Objects.equals(base_editions, page.base_editions) && height == page.height && width == page.width && color == page.color && Objects.equals(unique_id, page.unique_id) && Objects.equals(modifier, page.modifier) && Objects.equals(section, page.section) && dps == page.dps;
  }

  @Override
  public int hashCode() {
    return Objects.hash(physical_page_number, logical_page_number, base_editions, height, width, color, unique_id, modifier, section, dps);
  }

  @Override
  public String toString() {
    return "{" +
      " physical_page_number='" + getPhysical_page_number() + "'" +
      ", logical_page_number='" + getLogical_page_number() + "'" +
      ", base_editions='" + getBase_editions() + "'" +
      ", height='" + getHeight() + "'" +
      ", width='" + getWidth() + "'" +
      ", color='" + getColor() + "'" +
      ", unique_id='" + getUnique_id() + "'" +
      ", modifier='" + getModifier() + "'" +
      ", section='" + getSection() + "'" +
      ", dps='" + getDps() + "'" +
      "}";
  }

}
