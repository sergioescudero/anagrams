package com.sergioescudero.anagrams

class AnagramSpec extends MyTestClass {

  val pathResources = getClass.getResource("/").getPath

  "'Built to stay free'" should "be the anagram of 'Statue of Liberty'" in {
    val areAnagrams = Anagram((): Unit).areAnagrams("Statue of Liberty", "Built to stay free")
    assert(areAnagrams)
  }

  "'A En Mr Or Sot'" should "be the anagram of 'Astronomer'" in {
    val areAnagrams = Anagram((): Unit).areAnagrams("Astronomer", "A En Mr Or Sot")
    assert(areAnagrams)
  }

  "'Built to stay free' in file_05.txt" should "be the longest anagram of 'Statue of Liberty'" in {
    val givenSentence = "Statue of Liberty"
    val expectedAnagram = "Built to stay free"
    val fileName = getClass.getResource("/file_05.txt").getPath
    val anagram = Anagram((): Unit).getLongestAnagramInAFile(givenSentence, fileName)
    assert(expectedAnagram === anagram)
  }

  "'We'" should "not have an anagram in file_01.txt for 'We'" in {
    val givenSentence = "We"
    val fileName = getClass.getResource("/file_01.txt").getPath
    val anagram = Anagram((): Unit).getLongestAnagramInAFile(givenSentence, fileName)
    assert(anagram.isEmpty)
  }

  "'A En Mr Or Sot'" should "be the longest anagram of 'Astronomer' in all files" in {
    val givenSentence = "Astronomer"
    val expectedAnagram = "A En Mr Or Sot"
    val anagram = Anagram((): Unit).getLongestAnagramInFiles(givenSentence, pathResources)
    assert(expectedAnagram === anagram)
  }

  "'Built to stay free'" should "be the longest anagram of 'Statue of Liberty' in all files" in {
    val givenSentence = "Statue of Liberty"
    val expectedAnagram = "Built to stay free"
    val anagram = Anagram((): Unit).getLongestAnagramInFiles(givenSentence, pathResources)
    assert(expectedAnagram === anagram)
  }
}
