package com.sergioescudero.anagrams.file

import com.sergioescudero.anagrams.MyTestClass

class FileHelperSpec extends MyTestClass {

  val pathResources = getClass.getResource("/").getPath

  it should "return false because it does not exists" in {
    assert(!FileHelper.checkIfPathExists("/does_not_exists"))
  }

  it should "return true because it does exists" in {
    assert(FileHelper.checkIfPathExists(pathResources))
  }

  it should "return 5 files" in {
    val files = FileHelper.getListOfFiles(pathResources)
    assert(files.length === 5)
  }

  it should "return 0 files because there is not zip files" in {
    val files = FileHelper.getListOfFiles(pathResources, List("zip"))
    assert(files.length === 0)
  }
}
