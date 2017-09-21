package nl.ekholabs.nlp.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class AssetSearchRequest {

  private VideoUrl url;
  private Language language;
  private AssetDetails assetDetails;

  AssetSearchRequest() {
  }

  public AssetSearchRequest(final VideoUrl url, final Language language, final AssetDetails assetDetails) {
    this.url = url;
    this.language = language;
    this.assetDetails = assetDetails;
  }

  public VideoUrl getUrl() {
    return url;
  }

  public Language getLanguage() {
    return language;
  }

  public AssetDetails getAssetDetails() {
    return assetDetails;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final AssetSearchRequest that = (AssetSearchRequest) o;

    if (url != null ? !url.equals(that.url) : that.url != null) {
      return false;
    }
    if (language != null ? !language.equals(that.language) : that.language != null) {
      return false;
    }
    return assetDetails != null ? assetDetails.equals(that.assetDetails) : that.assetDetails == null;
  }

  @Override
  public int hashCode() {
    int result = url != null ? url.hashCode() : 0;
    result = 31 * result + (language != null ? language.hashCode() : 0);
    result = 31 * result + (assetDetails != null ? assetDetails.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "AssetSearchRequest{" +
        "url=" + url +
        ", language=" + language +
        ", assetDetails=" + assetDetails +
        '}';
  }
}
