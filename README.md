# DocumentSearch
Target Case Study

The goal of this exercise is to create a working program to search a set of documents for the given search term or phrase (single token), and return results in order of relevance. 
Relevancy is defined as number of times the exact term or phrase appears in the document. 
Create three methods for searching the documents: 
•	Simple string matching
•	Text search using regular expressions
•	Preprocess the content and then search the index
Prompt the user to enter a search term and search method, execute the search, and return results.

Three files have been provided for you to read and use as sample search content.
Run a performance test that does 2M searches with random search terms, and measures execution time. Which approach is fastest? Why?
Provide some thoughts on what you would do on the software or hardware side to make this program scale to handle massive content and/or very large request volume (5000 requests/second or more).  

This application is built and runs in:
IntelliJ IDEA 2018.1 (Community Edition)
Build #IC-181.4203.550, built on March 26, 2018
JRE: 1.8.0_152-release-1136-b20 amd64
JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
Windows 10 10.0

To test/run:
1.  Clone repository
2.  Import project into IntelliJ
3.  Run 

I chose to write this application in Kotlin since I have been learning it and teaching myself recently and I thought this would be a good way to reinforce that knowledge.
I also use Kotlin in Android development professionally and in my personal projects.  Writing this application in Kotlin allows me to showcase the fact that I know Kotlin plus reap the benefits of its features.
I use Kotlin's object-oriented and functional features at different points when I feel they're useful.  Namely, abstract class, inheritance, and lambdas.

Indexed search is the fastest because of the typical O(1) complexity of putting and getting elements in hash map.
