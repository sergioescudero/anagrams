package com.sergioescudero.anagrams

import com.sergioescudero.anagrams.file.FileHelper

import scala.annotation.tailrec


final class Anagram {

  def getLongestAnagramInFiles(givenSentence: String, path: String): String = {
    FileHelper.checkIfPathExists(path) match {
      case true  => {
        val files = FileHelper.getListOfFiles(path)
        val anagramList = for {
          file <- files
          x = getLongestAnagramInAFile(givenSentence, file.getPath)
        } yield x
        getLongestString(anagramList)
      }
      case false => ""
    }
  }

  def getLongestAnagramInAFile(givenSentence: String, fileName: String): String = {
    val bufferedSource = scala.io.Source.fromFile(fileName)

    val anagrams = for {
      line <- bufferedSource.getLines()
      if areAnagrams(givenSentence, line)
    } yield line

    val x = anagrams.fold("")((a,i) => if (a.size < i.size) i else a)
    bufferedSource.close()
    x
  }

  def areAnagrams(a: String, b: String): Boolean = {
    @tailrec
    def check(a: List[Char], b: List[Char], acc: Int): Boolean = {
      (a, b) match {
        case (x :: xs, y :: ys) =>
          check(xs, ys, acc ^ x ^ y)
        case _ => acc == 0
      }
    }

    val x = a.filterNot((x: Char) => x.isWhitespace).toLowerCase
    val y = b.filterNot((x: Char) => x.isWhitespace).toLowerCase
    (x.length - y.length) match {
      case 0 => check(x.toList, y.toList, 0)
      case _ => false
    }
  }

  private def getLongestString(list: List[String]): String = {
    list.fold("")((a,i) => if (a.size < i.size) i else a)
  }

}

object Anagram {
  def apply(ignored: Unit): Anagram = {
    new Anagram
  }
}