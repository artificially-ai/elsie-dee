package nl.ekholabs.nlp.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Language {

  private String code;

  Language() {
  }

  public Language(final String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return "Language{" +
        "code='" + code + '\'' +
        '}';
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final Language language = (Language) o;

    return code != null ? code.equals(language.code) : language.code == null;
  }

  @Override
  public int hashCode() {
    return code != null ? code.hashCode() : 0;
  }
}
