package com.hse.ls.common.io;

import com.hse.ls.common.entity.Problem;
import com.hse.ls.common.exceptions.DataProcessingException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Arrays;

import static java.net.URLDecoder.decode;

public class Reader {
    private static final Logger logger = LoggerFactory.getLogger(Reader.class);

    private static int[][] readMatrix(BufferedReader reader, int n) throws IOException {
        if (n <= 0) throw new DataProcessingException("Dimension must be positive");
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            matrix[i] = Arrays.stream(line)
                    .filter(StringUtils::isNotBlank)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }

    public static Problem read(String fileName) {
        Problem p;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(decode(fileName, "UTF-8"))))) {
            int n = Integer.valueOf(reader.readLine().trim()); // read dimension
            int[][] distances = readMatrix(reader, n);  // read distance matrix
            reader.readLine();                          // skip line
            int[][] flows = readMatrix(reader, n);      // read flows

            p = new Problem(n, distances, flows);
        } catch (IOException ex) {
            logger.error("Error occurred, while reading file [{}], Message: ", fileName, ex);
            throw new DataProcessingException(ex);
        }

        return p;
    }
}
