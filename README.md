Anagrams
==================================

An anagram is a word or sentence that can be rearranged to create another one, like LISTEN can be turn to SILENT, or RECITALS can turn into ARTICLES.

Assumptions
------------

Scala version used is 2.12.

The application developed check only txt files by default.

The files used in testing was created with anagrams got with the web page https://wordsmith.org/anagram/.

file_01.txt and file_02.txt contains anagrams of 'Astronomer'

file_03.txt and file_04.txt contains anagrams of 'Statue of Liberty'

file_05.txt contains a bunch of mixed anagrams used for small testing.

How to run
------------

The application was built using sbt.

### For testing

1. run sbt in project folder:

   ```sbt
   anagrams-sergio-escudero $ sbt
   [info] welcome to sbt 1.5.2 (Oracle Corporation Java 11.0.1)
   [info] loading global plugins from /Users/sarkis/.sbt/1.0/plugins
   [info] loading project definition from /HOME/development/workspaces/code_test/anagrams-sergio-escudero/project
   [info] loading settings for project anagrams-sergio-escudero from build.sbt ...
   [info] set current project to anagrams-sergio-escudero (in build file:/HOME/development/workspaces/code_test/anagrams-sergio-escudero/)
   [info] sbt server started at local:///Users/sarkis/.sbt/1.0/server/80d87c3b1b14d05d052c/sock
   [info] started sbt server
   ```

2. Clean project

   ```sbt
   sbt:anagrams-sergio-escudero> clean
   [success] Total time: 0 s, completed Dec 8, 2021, 6:34:21 PM
   ```

3. Run the test

   ```sbt
   sbt:anagrams-sergio-escudero> test
   [info] compiling 3 Scala sources to /HOME/development/workspaces/code_test/anagrams-sergio-escudero/target/scala-2.12/classes ...
   [info] compiling 3 Scala sources to /HOME/development/workspaces/code_test/anagrams-sergio-escudero/target/scala-2.12/test-classes ...
   [info] FileHelperSpec:
   [info] - should return false because it does not exists
   [info] - should return true because it does exists
   [info] - should return 5 files
   [info] - should return 0 files because there is not zip files
   [info] AnagramSpec:
   [info] 'Built to stay free'
   [info] - should be the anagram of 'Statue of Liberty'
   [info] 'A En Mr Or Sot'
   [info] - should be the anagram of 'Astronomer'
   [info] 'Built to stay free' in file_05.txt
   [info] - should be the longest anagram of 'Statue of Liberty'
   [info] 'We'
   [info] - should not have an anagram in file_01.txt for 'We'
   [info] 'A En Mr Or Sot'
   [info] - should be the longest anagram of 'Astronomer' in all files
   [info] 'Built to stay free'
   [info] - should be the longest anagram of 'Statue of Liberty' in all files
   [info] Run completed in 217 milliseconds.
   [info] Total number of tests run: 10
   [info] Suites: completed 2, aborted 0
   [info] Tests: succeeded 10, failed 0, canceled 0, ignored 0, pending 0
   [info] All tests passed.
   [success] Total time: 2 s, completed Dec 8, 2021, 6:53:26 PM
   ```

### For running the application

For running the application, I have used the folder test/resources.

There are 2 options:

1. Using sbt:

````sbt
sbt:anagrams-sergio-escudero> run /HOME/development/workspaces/code_test/anagrams-sergio-escudero/src/test/resources
[info] running com.sergioescudero.Main /HOME/development/workspaces/code_test/anagrams-sergio-escudero/src/test/resources
Match for> We
Longest anagram is...not found here
Match for> Astronomer
Longest anagram is...A En Mr Or Sot
Match for> Statue of Liberty
Longest anagram is...Built to stay free
Match for>
````

2. Packaging the code in a jar and execute with scala:

First, code is packaged:

```sbt
sbt:anagrams-sergio-escudero> clean
[success] Total time: 0 s, completed Dec 8, 2021, 6:55:51 PM
sbt:anagrams-sergio-escudero> package
[info] compiling 3 Scala sources to /HOME/development/workspaces/code_test/anagrams-sergio-escudero/target/scala-2.12/classes ...
[success] Total time: 1 s, completed Dec 8, 2021, 6:55:54 PM
sbt:anagrams-sergio-escudero>
```

Jar is placed in

```
./target/scala-2.12/anagrams-sergio-escudero_2.12-1.0.jar
```

The following command is used for run it:

```
anagrams-sergio-escudero $ scala /HOME/development/workspaces/code_test/anagrams-sergio-escudero/target/scala-2.12/anagrams-sergio-escudero_2.12-1.0.jar /HOME/development/workspaces/code_test/anagrams-sergio-escudero/src/test/resources
Match for> We
Longest anagram is...not found here
Match for> Statue of Liberty
Longest anagram is...Built to stay free
Match for> Astronomer
Longest anagram is...A En Mr Or Sot
Match for>
```
