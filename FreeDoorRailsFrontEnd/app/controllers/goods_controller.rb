
class GoodsController < ApplicationController

attr_accessor :URL
  
 def initialize() 
 @URL = "http://localhost:8080/scribesfreedoor" 
 end
 
def main
  
end

def gbids
     @title = "Bids"
     @goodId=params[:goodId]
    rtn6=RestClient.get("#@URL/goods/offers/"+@goodId,:content_type => :json)
  
       result = ActiveSupport::JSON.decode(rtn6)
   @return = result 
end

def createGoodBid 
   @goodId=params[:goodId]
      rtn2=RestClient.get("#@URL/goods/"+@goodId,:content_type => :json)
  
       result = ActiveSupport::JSON.decode(rtn2)
   @return = result 
    @name = params[:name]
    @description = params[:description]
    @status= params[:status]  
    @createrEmail = params[:createrEmail] 
    @goodId=params[:goodId]
    
end

def editgBids
   @goodId=params[:goodId]
      rtn2=RestClient.get("#@URL/goods/"+@goodId,:content_type => :json)
  
       result = ActiveSupport::JSON.decode(rtn2)
   @return = result 
    @bidId = params[:bidId]
    
    @comment= params[:comment]  
    @bidderEmail = params[:bidderEmail] 
    @goodId=params[:goodId]
    
end
 
def bidGoodSuccessul
     @name = params[:name]
    @description = params[:description]
    @status= params[:status]  
    @createrEmail = params[:createrEmail]  
    @goodId=params[:goodId]
    @bidderEmail=params[:bidderEmail]
    @comment=params[:comment]
    rtn5 = RestClient.post("#@URL/goods/offers/"+@goodId,{:bidderEmail => @bidderEmail,:comment => @comment,:goodId => @goodId}.to_json,:content_type => :json, :accept => :json)
  puts @rtn5 
end



def createGood 
end

def createdGood  
    @name = params[:name]
    @description = params[:description]
    @status= params[:status]  
    @createrEmail = params[:createrEmail]  
    rtn1 = RestClient.post("#@URL/goods",{:name => @name, :description => @description, :createrEmail => @createrEmail, :status => @status}.to_json,:content_type => :json, :accept => :json)
  puts @rtn1 
end

def deleteGoods
end

def deletedGoods
    @name = params[:name]
    @description = params[:description]
    @status= params[:status]  
    @createrEmail = params[:createrEmail]  
    @goodId=params[:goodId]
    rtn4 = RestClient.delete("#@URL/goods/"+@goodId,:content_type => :json)
  puts @rtn4 
end


 def editGoods 
   @goodId=params[:goodId]
     
    @name = params[:name]
    @description = params[:description]
    @status= params[:status]  
    @createrEmail = params[:createrEmail] 
     rtn2=RestClient.get("#@URL/goods/"+@goodId,:content_type => :json)
  
       result = ActiveSupport::JSON.decode(rtn2)
   @return = result 
  #  @serviceId=params[:goodId]
    
end
 def editedGoods
     @goodId=params[:goodId]
    @name = params[:name]
    @description = params[:description]
    @status= params[:status]  
    @createrEmail = params[:createrEmail] 
   
    rtn3 = RestClient.put("#@URL/goods/"+@goodId,{:name => @name, :description => @description, :createrEmail => @createrEmail, :status => @status}.to_json,:content_type => :json, :accept => :json)
  puts @rtn3 
    
  end

   def goods
    
     rtn=RestClient.get("#@URL/goods",:content_type => :json)
     result = ActiveSupport::JSON.decode(rtn)
   @return = result 
      
    
  end
  
  def welcome
  end
def goodSearch
  end
  
    def searchResult
      @name = params[:name]
 
    
   rtn = RestClient.post("#@URL/goods/searchname",@name.to_param,:content_type => :json, :accept => :json)
   result = ActiveSupport::JSON.decode(rtn)
   @goods = result 
   
 
  end
  
  def getGood
    
  end
end