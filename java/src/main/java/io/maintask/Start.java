package io.maintask;

import java.io.*;


public class Start {
  public static void main(String[] args) {
    TreeViewer treeViewer = new TreeViewer();
    String treePath = "C:/epam/info.txt";
    String fileToWrite = "C:/epam/info.txt";
    File file = new File(treePath);

    if (file.isDirectory()) {
      try (Writer out = new FileWriter(fileToWrite)) {
        treeViewer.displayTree(new File(treePath), "|++ " + file.getName(), out);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else
      treeViewer.scanFile(new File(treePath));
  }
}
