package nl.ekholabs.nlp.model;

import java.util.List;

public class AssetKeyword {

  public List<Keyword> keywords;

  AssetKeyword() {
  }

  public AssetKeyword(final List<Keyword> keywords) {
    this.keywords = keywords;
  }

  public List<Keyword> getKeywords() {
    return keywords;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final AssetKeyword that = (AssetKeyword) o;

    return keywords != null ? keywords.equals(that.keywords) : that.keywords == null;
  }

  @Override
  public int hashCode() {
    return keywords != null ? keywords.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "AssetKeyword{" +
        "keywords=" + keywords +
        '}';
  }
}
