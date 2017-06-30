package nl.ekholabs.nlp.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class TextResponse {

  private Language language;
  private String output;

  TextResponse() {
  }

  public TextResponse(final Language language, final String output) {
    this.language = language;
    this.output = output;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final TextResponse that = (TextResponse) o;

    if (language != null ? !language.equals(that.language) : that.language != null) {
      return false;
    }
    return output != null ? output.equals(that.output) : that.output == null;
  }

  @Override
  public int hashCode() {
    int result = language != null ? language.hashCode() : 0;
    result = 31 * result + (output != null ? output.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "TextResponse{" +
        "language=" + language +
        ", output='" + output + '\'' +
        '}';
  }
}
