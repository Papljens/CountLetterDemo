# CountLetterDemo
This Project counts the occurrence of a given letter in a given text.

# Prerequisites
Backend Tech (Tomcat, Jboss, Wildfly, ...)
Browser (Firefox, Edge, Chrome, ...)

for development: Eclipse Java EE Oxygen
  -gradle Buildpath, WTB Plugins                 <--Included in latest Version of Eclipse Java EE Oxygen
  -Jacoco, Jersey Rest Service, log4j, jUnit     <--already configured in build.gradle dependencys
   
# How to use in Eclipse:   
- Pull Project
- Import as eclipse project
- Sync gradle (Right click on Project > Gradle > Sync)
- Download Backend Tech (e.g. Tomcat)
- configure Runtime (Window > Pref > Server > Runtime Env > Add)
- Right click on Project > Run as > Run on Server (Might need to choose Server on first start)

# How to deploy without IDE: 
- goto "CountLetterDemo\org.demo.lettercount\gradle_build\libs"
- deploy "demo.war" to desired backend tech
- open "CountLetterDemo\org.demo.lettercount\WebContent\demo.html"
- enjoy

# Check Test coverage
- Run jacocoTestReport via gradle
- open "CountLetterDemo\org.demo.lettercount\gradle_build\jacocoHtml\index.html" to check coverage
