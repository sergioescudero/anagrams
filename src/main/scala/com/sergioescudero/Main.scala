package com.sergioescudero

import com.sergioescudero.anagrams.Anagram
import com.sergioescudero.anagrams.file.FileHelper

object Main {
  def main(args: Array[String]) = {
    if (args.length > 0) {
      val path = args(0)
      if (FileHelper.checkIfPathExists(path) && FileHelper.getListOfFiles(path).size>0) {
        while (true) {
          print("Match for> ")
          val givenSentence = scala.io.StdIn.readLine
          val anagram = Anagram((): Unit).getLongestAnagramInFiles(givenSentence, path)
          val result = anagram.isEmpty || anagram == givenSentence match {
            case true  => "not found here"
            case false => anagram
          }
          println(s"Longest anagram is...$result")
        }
      }
      else {
        println("Path does not contain files.")
      }
    }
    else {
      println("File path is missing.")
    }
  }
}
