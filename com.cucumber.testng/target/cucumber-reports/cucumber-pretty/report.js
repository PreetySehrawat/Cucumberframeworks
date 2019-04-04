$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("amasearch.feature");
formatter.feature({
  "line": 1,
  "name": "Test Amazon Search",
  "description": "",
  "id": "test-amazon-search",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Amazon Search for Fiction books",
  "description": "",
  "id": "test-amazon-search;amazon-search-for-fiction-books",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Amazon website is open",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "search is enabled",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "all fiction books should be listed",
  "keyword": "Then "
});
formatter.match({
  "location": "amasearchstepdef.amazon_website_is_open()"
});
formatter.result({
  "duration": 144508644,
  "status": "passed"
});
formatter.match({
  "location": "amasearchstepdef.search_is_enabled()"
});
formatter.result({
  "duration": 312529,
  "status": "passed"
});
formatter.match({
  "location": "amasearchstepdef.all_fiction_books_should_be_listed()"
});
formatter.result({
  "duration": 95452,
  "status": "passed"
});
});