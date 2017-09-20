package nl.ekholabs.nlp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Streams {

  private List<StreamDetails> streams;

  public Streams() {
  }

  public Streams(final List<StreamDetails> streams) {
    this.streams = streams;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final Streams streams1 = (Streams) o;

    return streams != null ? streams.equals(streams1.streams) : streams1.streams == null;
  }

  @Override
  public int hashCode() {
    return streams != null ? streams.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Streams{" +
        "streams=" + streams +
        '}';
  }
}
