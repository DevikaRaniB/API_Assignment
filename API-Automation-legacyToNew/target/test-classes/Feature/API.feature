Feature: API testing

 
@APITestCase
Scenario Outline: Verify the API responce
      When I request for the OLD list of result through GET request "<LegacyAPIURL>"
      And I request for the NEW list of result through GET request "<newAPIURL>"
      Then I Validate the match in the response of both Response
      
     Examples: 
   |LegacyAPIURL |newAPIURL  |                               
   |https://api.agify.io/?name=bella  |https://api.agify.io/?name=bella     |
  





 
       
       
      
      
      
      
      
    
      
      
      
  
     
      
      
      
    
    
    
    
     
    
      
      
      
      
    
    
     
     
     
     
     
     
    
      
       
     
  
  
  
      
     


