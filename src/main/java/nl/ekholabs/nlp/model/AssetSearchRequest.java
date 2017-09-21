package nl.ekholabs.nlp.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class AssetSearchRequest {

  private VideoUrl videoUrl;
  private Language language;
  private AssetDetails assetDetails;

  AssetSearchRequest() {
  }

  public AssetSearchRequest(final VideoUrl videoUrl, final Language language, final AssetDetails assetDetails) {
    this.videoUrl = videoUrl;
    this.language = language;
    this.assetDetails = assetDetails;
  }

  public VideoUrl getVideoUrl() {
    return videoUrl;
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

    if (videoUrl != null ? !videoUrl.equals(that.videoUrl) : that.videoUrl != null) {
      return false;
    }
    if (language != null ? !language.equals(that.language) : that.language != null) {
      return false;
    }
    return assetDetails != null ? assetDetails.equals(that.assetDetails) : that.assetDetails == null;
  }

  @Override
  public int hashCode() {
    int result = videoUrl != null ? videoUrl.hashCode() : 0;
    result = 31 * result + (language != null ? language.hashCode() : 0);
    result = 31 * result + (assetDetails != null ? assetDetails.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "AssetSearchRequest{" +
        "videoUrl=" + videoUrl +
        ", language=" + language +
        ", assetDetails=" + assetDetails +
        '}';
  }
}
