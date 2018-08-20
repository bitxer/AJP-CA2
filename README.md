# Advanced Java Programming CA2

## Task
In assignment 2, you will code and implement a simplified crawler which will help you retrieve web documents from the internet based on a search phrase.<br>
From Wikipedia:
>A Web crawler starts with a list of URLs to visit, called the seeds. As the crawler visits these URLs, it identifies all the hyperlinks in the page and adds them to the list of URLs to visit, called the crawl frontier. URLs from the frontier are recursively visited according to a set of policies. If the crawler is performing archiving of websites it copies and saves the information as it goes. Such archives are usually stored such that they can be viewed, read and navigated as they were on the live web, but are preserved as ‘snapshots'.

Your simplified web crawler application is required to provide the following functionalities:
1. Enable user to enter a search phrase which may contain more than one word.
2. Send the query to two search engines of your choice such as yahoo or bing.
3. Program will need to analyze the downloaded html source from the first 2 search results from each search engine. This will form the seeds.
4. Program will need to analyze the downloaded html source from the seeds to find out the top 12 unique webpages through multi-threading. Your pool of urls will grow from analyzing of web content starting from the seeds You would have to look for the specific patterns to retrieve the web site address eg  http://....  as a pattern. You will need to apply suitable regular expressions to find such patterns.
5. Your application will create 2 separate threads which will download and process each web document to find the web URLs, which will be added to the Queue.
6. Each of these 12 webpages URLs will be queued to a Queue data structure as they are found.
7. The 2 threads will process the next available and unprocessed web URL once it has finished its current task. They will keep doing so, until the 12 websites are found with its contents downloaded.
8. The 12 website URLs and its html page contents (saved locally) should be shown to the user through a GUI (For example, after clicking on a selected URL, the web page content will be shown in a text area). The website URLs are to be displayed in a list in ascending order.
9. Keep track of the number of occurrences of the search phrase within the html page and display the number of occurrences.

## License/Copyright
This repository contains the source code, in fulfilment, for the module ST0316, Advanced Java Programming. As such, this project will not be maintained and all rights belong to the project contributors as well as to Singapore Polytechnic. Third party resources may be reused in accordance to their license and/or terms and conditions.