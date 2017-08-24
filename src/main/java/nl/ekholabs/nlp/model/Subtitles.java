package nl.ekholabs.nlp.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Subtitles {

  private String text;

  Subtitles() {
  }

  public Subtitles(final String text) {
    this.text = text;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final Subtitles subtitles = (Subtitles) o;

    return text != null ? text.equals(subtitles.text) : subtitles.text == null;
  }

  @Override
  public int hashCode() {
    return text != null ? text.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Subtitles{" +
        "text='" + text + '\'' +
        '}';
  }
}
