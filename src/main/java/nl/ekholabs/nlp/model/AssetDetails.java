package nl.ekholabs.nlp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.*;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class AssetDetails {

  private String id;

  private String assetTitle;

  public List<Keyword> keywords;

  AssetDetails() {
  }

  public AssetDetails(final String assetTitle, final List<Keyword> keywords) {
    this.assetTitle = assetTitle;
    this.keywords = keywords;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final AssetDetails that = (AssetDetails) o;

    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }
    if (assetTitle != null ? !assetTitle.equals(that.assetTitle) : that.assetTitle != null) {
      return false;
    }
    return keywords != null ? keywords.equals(that.keywords) : that.keywords == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (assetTitle != null ? assetTitle.hashCode() : 0);
    result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "AssetDetails{" +
        "id='" + id + '\'' +
        ", assetTitle='" + assetTitle + '\'' +
        ", keywords=" + keywords +
        '}';
  }
}
