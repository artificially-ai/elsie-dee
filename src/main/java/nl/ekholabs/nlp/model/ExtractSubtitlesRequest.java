package nl.ekholabs.nlp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class ExtractSubtitlesRequest {

  private VideoUrl videoUrl;
  private List<StreamDetails> streamDetails;

  ExtractSubtitlesRequest() {
  }

  public ExtractSubtitlesRequest(final VideoUrl videoUrl, final List<StreamDetails> streamDetails) {
    this.videoUrl = videoUrl;
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

    if (videoUrl != null ? !videoUrl.equals(that.videoUrl) : that.videoUrl != null) {
      return false;
    }
    return streamDetails != null ? streamDetails.equals(that.streamDetails) : that.streamDetails == null;
  }

  @Override
  public int hashCode() {
    int result = videoUrl != null ? videoUrl.hashCode() : 0;
    result = 31 * result + (streamDetails != null ? streamDetails.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ExtractSubtitlesRequest{" +
        "videoUrl=" + videoUrl +
        ", streamDetails=" + streamDetails +
        '}';
  }
}
