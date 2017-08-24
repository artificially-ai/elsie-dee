package nl.ekholabs.nlp.util.multipart;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class ByteArrayMultipartFile implements MultipartFile {

  private final byte[] bytes;
  private final String contentType;
  private final String name;

  public ByteArrayMultipartFile(final byte[] bytes, final String contentType) {
    this.bytes = bytes;
    this.contentType = contentType;
    name = UUID.randomUUID().toString();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getOriginalFilename() {
    return name;
  }

  @Override
  public String getContentType() {
    return contentType;
  }

  @Override
  public boolean isEmpty() {
    return bytes == null || bytes.length == 0;
  }

  @Override
  public long getSize() {
    return bytes.length;
  }

  @Override
  public byte[] getBytes() throws IOException {
    return bytes;
  }

  @Override
  public InputStream getInputStream() throws IOException {
    return new ByteArrayInputStream(bytes);
  }

  @Override
  public void transferTo(final File dest) throws IOException, IllegalStateException {
    new FileOutputStream(dest).write(bytes);
  }
}
