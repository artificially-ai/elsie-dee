package nl.ekholabs.nlp.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class TextResponse {

  private String output;

  TextResponse() {
  }

  public TextResponse(final String output) {
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

    return output != null ? output.equals(that.output) : that.output == null;
  }

  @Override
  public int hashCode() {
    return output != null ? output.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "TextResponse{" +
        "output='" + output + '\'' +
        '}';
  }
}
