package io.maintask;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Writer;

public class TreeViewer {

  public void displayTree(File file, String indent, Writer out) throws IOException {
    if (file.isDirectory()) {
      out.write(indent + System.lineSeparator());
      for (File child : file.listFiles()) {
        if (child.isFile()) {
          indent = "      |-- " + child.getName() + System.lineSeparator();
          out.write(indent);
        } else {
          indent = "   |++ " + child.getName();
          displayTree(child, indent, out);
        }
      }
    }
  }

  public void scanFile(File file) {
    String[] words;
    String s;
    final String fileInput = "|--";
    final String folderInput = "|++";
    double fileCount = 0;
    double folderCount = 0;
    double averageFilesInFolders;
    double filesAverageLength;

    double filesLength = 0;

    try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
      while ((s = reader.readLine()) != null) {
        words = s.split(" ");
        for (String word : words) {
          if (word.equals(fileInput)) {
            fileCount++;
          }
          if (word.equals(folderInput)) {
            folderCount++;
          }
          if (word.contains(".")) {
            filesLength += word.length();
          }
        }
      }
      averageFilesInFolders = fileCount / folderCount;
      filesAverageLength = filesLength / fileCount;


      System.out.println("There are " + fileCount + " files in " + file.getName() + " file");
      System.out.println("There are " + folderCount + " folders in " + file.getName() + " file");
      System.out.println("Average quantity of files in folders: " + averageFilesInFolders);
      System.out.println("Average length of a file name: " + filesAverageLength);
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
