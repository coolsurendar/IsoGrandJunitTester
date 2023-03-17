package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class IsoContestTest {

  String extractedDirectory="/home/surendar/mdf2023/MasterDevFrance2023/src/test/resources/";

  public String[] readInput(String fileName) throws IOException {
    List<String> result = Files.readAllLines(Paths.get(extractedDirectory+fileName));
    return result.toArray(new String[0]);
  }

  public byte[] readInputToBytes(String fileName) throws IOException {
    return Files.readAllBytes(Paths.get(extractedDirectory+fileName));
  }

  public String[] readOutput(String fileName) throws IOException {
    List<String> result = Files.readAllLines(Paths.get(extractedDirectory+fileName));
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

  @Test
  public void testMain1() throws Exception {

    InputStream sysInBackup = System.in; // backup System.in to restore it later
    ByteArrayInputStream in = new ByteArrayInputStream(readInputToBytes("input1.txt"));
    System.setIn(in);

    IsoContest.main(new String[0]);

    // optionally, reset System.in to its original
    System.setIn(sysInBackup);
    assertEquals(readOutput("output1.txt")[0].trim(), outContent.toString().trim());
  }
  @Test
  public void testMain2() throws Exception {

    InputStream sysInBackup = System.in; // backup System.in to restore it later
    ByteArrayInputStream in = new ByteArrayInputStream(readInputToBytes("input2.txt"));
    System.setIn(in);

    IsoContest.main(new String[0]);

    // optionally, reset System.in to its original
    System.setIn(sysInBackup);
    assertEquals(readOutput("output2.txt")[0].trim(), outContent.toString().trim());
  }
  @Test
  public void testMain3() throws Exception {

    InputStream sysInBackup = System.in; // backup System.in to restore it later
    ByteArrayInputStream in = new ByteArrayInputStream(readInputToBytes("input3.txt"));
    System.setIn(in);

    IsoContest.main(new String[0]);

    // optionally, reset System.in to its original
    System.setIn(sysInBackup);
    assertEquals(readOutput("output3.txt")[0].trim(), outContent.toString().trim());
  }
  @Test
  public void testMain4() throws Exception {

    InputStream sysInBackup = System.in; // backup System.in to restore it later
    ByteArrayInputStream in = new ByteArrayInputStream(readInputToBytes("input4.txt"));
    System.setIn(in);

    IsoContest.main(new String[0]);

    // optionally, reset System.in to its original
    System.setIn(sysInBackup);
    assertEquals(readOutput("output4.txt")[0].trim(), outContent.toString().trim());
  }
  @Test
  public void testMain5() throws Exception {

    InputStream sysInBackup = System.in; // backup System.in to restore it later
    ByteArrayInputStream in = new ByteArrayInputStream(readInputToBytes("input5.txt"));
    System.setIn(in);

    IsoContest.main(new String[0]);

    // optionally, reset System.in to its original
    System.setIn(sysInBackup);
    assertEquals(readOutput("output5.txt")[0].trim(), outContent.toString().trim());
  }

  @Test
  public void testMain6() throws Exception {

    InputStream sysInBackup = System.in; // backup System.in to restore it later
    ByteArrayInputStream in = new ByteArrayInputStream(readInputToBytes("input6.txt"));
    System.setIn(in);

    IsoContest.main(new String[0]);

    // optionally, reset System.in to its original
    System.setIn(sysInBackup);
    assertEquals(readOutput("output6.txt")[0].trim(), outContent.toString().trim());
  }

  @Test
  public void testMain7() throws Exception {

    InputStream sysInBackup = System.in; // backup System.in to restore it later
    ByteArrayInputStream in = new ByteArrayInputStream(readInputToBytes("input7.txt"));
    System.setIn(in);

    IsoContest.main(new String[0]);

    // optionally, reset System.in to its original
    System.setIn(sysInBackup);
    assertEquals(readOutput("output7.txt")[0].trim(), outContent.toString().trim());
  }

  @Test
  public void testMain8() throws Exception {

    InputStream sysInBackup = System.in; // backup System.in to restore it later
    ByteArrayInputStream in = new ByteArrayInputStream(readInputToBytes("input8.txt"));
    System.setIn(in);

    IsoContest.main(new String[0]);

    // optionally, reset System.in to its original
    System.setIn(sysInBackup);
    assertEquals(readOutput("output8.txt")[0].trim(), outContent.toString().trim());
  }

  @Test
  public void testMain9() throws Exception {

    InputStream sysInBackup = System.in; // backup System.in to restore it later
    ByteArrayInputStream in = new ByteArrayInputStream(readInputToBytes("input9.txt"));
    System.setIn(in);

    IsoContest.main(new String[0]);

    // optionally, reset System.in to its original
    System.setIn(sysInBackup);
    assertEquals(readOutput("output9.txt")[0].trim(), outContent.toString().trim());
  }
}