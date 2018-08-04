package org.aguinore;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FastScanner {
    private BufferedReader reader;
    private List<Object> tokenizedLine;
    private StringTokenizer tokenizer;

    public FastScanner(InputStream inputStream) {
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
        this.tokenizedLine = new ArrayList<>();
    }

    public String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new UncheckedIOException("cannot read line ", e);
        }
    }

    public Integer nextInt() {
        if (tokenizedLine.isEmpty()) {
            initTokenizer();
            while (tokenizer.hasMoreTokens()) {
                tokenizedLine.add(tokenizer.nextToken());
            }
        }
        return Integer.parseInt(tokenizedLine.remove(0) + "");
    }

    public Long nextLong() {
        if (tokenizedLine.isEmpty()) {
            initTokenizer();
            while (tokenizer.hasMoreTokens()) {
                tokenizedLine.add(tokenizer.nextToken());
            }
        }
        return Long.parseLong(tokenizedLine.remove(0) + "");
    }

    public Double nextDouble() {
        if (tokenizedLine.isEmpty()) {
            initTokenizer();
            while (tokenizer.hasMoreTokens()) {
                tokenizedLine.add(tokenizer.nextToken());
            }
        }
        return Double.parseDouble(tokenizedLine.remove(0) + "");
    }

    private void initTokenizer() {
        String line = nextLine();
        if (line == null) {
            throw new IllegalStateException("No more objects in Input stream");
        }
        tokenizer = new StringTokenizer(line);
    }
}
