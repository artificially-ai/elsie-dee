package nl.ekholabs.nlp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class ExtractSubtitlesRequest {

  private VideoUrl url;
  private List<StreamDetails> streamDetails;

  ExtractSubtitlesRequest() {
  }

  public ExtractSubtitlesRequest(final VideoUrl url, final List<StreamDetails> streamDetails) {
    this.url = url;
    this.streamDetails = streamDetails;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final ExtractSubtitlesRequest that = (ExtractSubtitlesRequest) o;

    if (url != null ? !url.equals(that.url) : that.url != null) {
      return false;
    }
    return streamDetails != null ? streamDetails.equals(that.streamDetails) : that.streamDetails == null;
  }

  @Override
  public int hashCode() {
    int result = url != null ? url.hashCode() : 0;
    result = 31 * result + (streamDetails != null ? streamDetails.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ExtractSubtitlesRequest{" +
        "url=" + url +
        ", streamDetails=" + streamDetails +
        '}';
  }
}
