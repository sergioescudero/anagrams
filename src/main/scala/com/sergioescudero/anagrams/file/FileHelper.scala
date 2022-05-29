package com.sergioescudero.anagrams.file

import java.io.File
import java.nio.file.{Files, Paths}

object FileHelper {
  def checkIfPathExists(path: String): Boolean =
    Files.exists(Paths.get(path))

  def getListOfFiles(path: String, extensions: List[String] = List("txt")): List[File] = {
    val x = new File(path)
    if (x.exists && x.isDirectory) {
      x.listFiles.filter(_.isFile).toList.filter { file =>
        extensions.exists(file.getName.endsWith(_))
      }
    } else {
      List[File]()
    }
  }
}
