
class UsersController < ApplicationController
  
  attr_accessor :URL
 
  def initialize() 
 @URL = "http://localhost:8080/scribesfreedoor" 
 end
 
 def createUser
   
end

def createdUser
     @emailId = params[:emailId]
   @password = params[:password]
     @firstName = params[:firstName]
   @lastName = params[:lastName]
   
    
   @role = params[:role]  
   #puts @fname
   #puts @lname
   #puts @password
   #puts @email
   #puts @roleName
  
 rtn8 = RestClient.post("#@URL/users/createuser",{ :emailId => @emailId,:password => @password, :firstName => @firstName, :lastName => @lastName,:role => @role }.to_json,:content_type => :json , :accept => :json)
 #rtn1=RestClient.post("#@URL/users",{:firstName => "first2", :lastName => "last2", :password =>  "pass2", :emailId =>  "email2", :roleName =>  "role2"}.to_json,:content_type => :json, :accept => :json)
   return @rtn8 
 
end

  def users
     @title = "Users"
    
    rtn=RestClient.get("#@URL/users",:content_type => :json)
     result = ActiveSupport::JSON.decode(rtn)
   @return = result 
    
  end
   
 def user

 end

  def validate
   #@email = 'sonali'  
 end
 
end