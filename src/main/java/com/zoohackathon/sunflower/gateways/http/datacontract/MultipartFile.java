package com.zoohackathon.sunflower.gateways.http.datacontract;

import java.io.*;

public interface MultipartFile {
    String getName();

    String getOriginalFilename();

    String getContentType();

    boolean isEmpty();

    long getSize();

    byte[] getBytes();

    InputStream getInputStream();

    void transferTo(File dest) throws IOException;
}
