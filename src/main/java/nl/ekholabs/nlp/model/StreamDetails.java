package nl.ekholabs.nlp.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class StreamDetails {

  private String id;
  private String language;
  private String type;

  StreamDetails() {
  }

  public StreamDetails(final String id, final String language, final String type) {
    this.id = id;
    this.language = language;
    this.type = type;
  }

  public String getId() {
    return id;
  }

  public String getLanguage() {
    return language;
  }

  public String getType() {
    return type;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final StreamDetails that = (StreamDetails) o;

    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }
    if (language != null ? !language.equals(that.language) : that.language != null) {
      return false;
    }
    return type != null ? type.equals(that.type) : that.type == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (language != null ? language.hashCode() : 0);
    result = 31 * result + (type != null ? type.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "StreamDetails{" +
        "id='" + id + '\'' +
        ", language='" + language + '\'' +
        ", type='" + type + '\'' +
        '}';
  }
}
