Feature: Testing a REST API
  Users should be able to submit GET and POST requests to a web service
 
 Scenario: Data added to a web service
    When users add data on a project
    Then the server should handle it and return a success status
 
 Scenario: Data retrieval from a web service
    When users want to get information on the Cucumber project
    Then the requested data is returned
    
 Scenario: Data added to a product web service
    When add product with pid 1 to a project
    Then service getall should have only one product
    Then delete added product with pid 1