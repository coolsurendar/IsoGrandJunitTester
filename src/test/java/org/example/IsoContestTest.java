package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class IsoContestTest {


  public byte[] readInputToBytes(String fileName) throws IOException {
    return Files.readAllBytes(readFile(fileName).toPath());
  }

  private File readFile(String fileName) {
    ClassLoader classLoader = getClass().getClassLoader();
    return new File(classLoader.getResource(fileName).getFile());
  }

  public String[] readOutput(String fileName) throws IOException {
    List<String> result = Files.readAllLines(readFile(fileName).toPath());
    return result.toArray(new String[0]);
  }

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  @BeforeEach
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

   @ParameterizedTest
   @CsvSource({
       "input1.txt, output1.txt",
       "input2.txt, output2.txt",
       "input3.txt, output3.txt",
       "input4.txt, output4.txt",
       "input5.txt, output5.txt",
       "input6.txt, output6.txt",
       "input7.txt, output7.txt",
       "input8.txt, output8.txt",
       "input9.txt, output9.txt",
   })
  void should_test_main_function(String inputFile,String outputFile) throws Exception {

    InputStream sysInBackup = System.in; // backup System.in to restore it later
    ByteArrayInputStream in = new ByteArrayInputStream(readInputToBytes(inputFile));
    System.setIn(in);

    IsoContest.main(new String[0]);

    // optionally, reset System.in to its original
    System.setIn(sysInBackup);
    assertEquals(readOutput(outputFile)[0].trim(), outContent.toString().trim());
  }
}