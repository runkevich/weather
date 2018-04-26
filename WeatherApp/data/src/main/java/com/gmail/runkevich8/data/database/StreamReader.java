package com.gmail.runkevich8.data.database;


import java.io.IOException;
import java.io.InputStream;

public interface StreamReader {
    String read(InputStream in) throws IOException;
}
