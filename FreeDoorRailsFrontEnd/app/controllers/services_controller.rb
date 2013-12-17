class ServicesController < ApplicationController
  attr_accessor :URL
 
def initialize() 
 @URL = "http://localhost:8080/scribesfreedoor" 
end
 def services
     @title = "Services"
    
    rtn=RestClient.get("#@URL/services",:content_type => :json)
  
       result = ActiveSupport::JSON.decode(rtn)
   @return = result 
end
def createServices 
end

def main
end



def createdServices
    @name = params[:name]
    @description = params[:description]
    @status= params[:status]  
    @createrEmail = params[:createrEmail] 
     
    rtn1 = RestClient.post("#@URL/services",{:name => @name, :description => @description, :createrEmail => @createrEmail, :status => @status}.to_json,:content_type => :json, :accept => :json)
  puts @rtn1 
end


def bids
     @title = "Bids"
     @serviceId=params[:serviceId]
    rtn6=RestClient.get("#@URL/services/offers/"+@serviceId,:content_type => :json)
  
       result = ActiveSupport::JSON.decode(rtn6)
   @return = result 
end

def gbids
     @title = "Bids"
     @goodId=params[:goodId]
    rtn6=RestClient.get("#@URL/goods/offers/"+@goodId,:content_type => :json)
  
       result = ActiveSupport::JSON.decode(rtn6)
   @return = result 
end


  
  
   
  def editServices 
   @serviceId=params[:serviceId]
      rtn2=RestClient.get("#@URL/services/"+@serviceId,:content_type => :json)
  
       result = ActiveSupport::JSON.decode(rtn2)
   @return = result 
    @name = params[:name]
    @description = params[:description]
    @status= params[:status]  
    @createrEmail = params[:createrEmail] 
   # @ownerId = '1'
  #  @serviceId=params[:serviceId]
    
end
 def editedServices
     @serviceId=params[:serviceId]
    @name = params[:name]
    @description = params[:description]
    @status= params[:status]  
    @createrEmail = params[:createrEmail] 
  # @ownerId = '1'
    rtn3 = RestClient.put("#@URL/services/"+@serviceId,{:name => @name, :description => @description, :createrEmail => @createrEmail, :status => @status}.to_json,:content_type => :json, :accept => :json)
  puts @rtn3 
    
  end
def editBids
   @serviceId=params[:serviceId]
      rtn2=RestClient.get("#@URL/services/"+@serviceId,:content_type => :json)
  
       result = ActiveSupport::JSON.decode(rtn2)
   @return = result 
    @bidId = params[:bidId]
    
    @comment= params[:comment]  
    @bidderEmail = params[:bidderEmail] 
    @serviceId=params[:serviceId]
    
end




def deleteServices 
end

def deletedServices
    @name = params[:name]
    @description = params[:description]
    @status= params[:status]  
    @createrEmail = params[:createrEmail]  
    @serviceId=params[:serviceId]
    rtn4 = RestClient.delete("#@URL/services/"+@serviceId,:content_type => :json)
  puts @rtn4 
end

def BidServiceSuccessful
    @name = params[:name]
    @description = params[:description]
    @status= params[:status]  
    @createrEmail = params[:createrEmail]  
    @serviceId=params[:serviceId]
    @bidderEmail=params[:bidderEmail]
    @comment=params[:comment]
    rtn5 = RestClient.post("#@URL/services/offers/"+@serviceId,{:bidderEmail => @bidderEmail,:comment => @comment,:serviceId => @serviceId}.to_json,:content_type => :json, :accept => :json)
  puts @rtn5 
end
def createServiceBid 
   @serviceId=params[:serviceId]
      rtn2=RestClient.get("#@URL/services/"+@serviceId,:content_type => :json)
  
       result = ActiveSupport::JSON.decode(rtn2)
   @return = result 
    @name = params[:name]
    @description = params[:description]
    @status= params[:status]  
    @createrEmail = params[:createrEmail] 
    @serviceId=params[:serviceId]
    
end


def searchService
end
  
def searchServiceResult
     @name = "gardening"
     @status= params[:status]  
    @createrEmail = params[:createrEmail] 
    @thisisasample = "testing sampple"
    
   rtn = RestClient.post("#@URL/services/search",@name.to_param,:content_type => :json, :accept => :json)
   result = ActiveSupport::JSON.decode(rtn4)
   @return= result 
    @name = params[:name]
    @description = params[:description]
    @status= params[:status]  
    @createrEmail = params[:createrEmail] 
    @serviceId=params[:serviceId]
   
 
end

  
end