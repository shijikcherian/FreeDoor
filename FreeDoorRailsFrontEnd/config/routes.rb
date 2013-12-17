FreeDoorRailsFrontEnd::Application.routes.draw do
  # The priority is based upon order of creation:
  # first created -> highest priority.

  # Sample of regular route:
  #   match 'products/:id' => 'catalog#view'
  # Keep in mind you can assign values other than :controller and :action

  # Sample of named route:
  #   match 'products/:id/purchase' => 'catalog#purchase', :as => :purchase
  # This route can be invoked with purchase_url(:id => product.id)

  #Sample resource route (maps HTTP verbs to controller actions automatically):
 # resources :goods

  # Sample resource route with options:
  #   resources :products do
  #     member do
  #       get 'short'
  #       post 'toggle'
  #     end
  #
  #     collection do
  #       get 'sold'
  #     end
  #   end

  # Sample resource route with sub-resources:
  #   resources :products do
  #     resources :comments, :sales
  #     resource :seller
  #   end

  # Sample resource route with more complex sub-resources
  #   resources :products do
  #     resources :comments
  #     resources :sales do
  #       get 'recent', :on => :collection
  #     end
  #   end

  # Sample resource route within a namespace:
  #   namespace :admin do
  #     # Directs /admin/products/* to Admin::ProductsController
  #     # (app/controllers/admin/products_controller.rb)
  #     resources :products
  #   end

  # You can have the root of your site routed with "root"
  # just remember to delete public/index.html.
  # root :to => 'welcome#index'

  # See how all your routes lay out with "rake routes"

  # This is a legacy wild controller route that's not recommended for RESTful applications.
  # Note: This route will make all actions in every controller accessible via GET requests.
  # match ':controller(/:action(/:id))(.:format)'
  
 get 'about', :controller => 'goods', :action => 'about'
 get 'user', :controller => 'users', :action => 'user'
 get 'welcome', :controller => 'users', :action => 'welcome'
  
 get 'services/main', :controller => 'goods', :action => 'main'
 get 'goods/main', :controller => 'goods', :action => 'main'

 
 get 'goods', :controller => 'goods', :action => 'goods'
 get 'services', :controller => 'services', :action => 'services'
 
 get 'bids', :controller => 'services', :action => 'bids'
  get 'gbids', :controller => 'goods', :action => 'gbids'
 #get 'goodsbids', :controller => 'goods', :action => 'goodsbids'
 
 get '/createServices', :controller => 'services', :action => 'createServices'
 get '/createGood', :controller => 'goods', :action => 'createGood'
 
 get '/services/createServices', :controller => 'services', :action => 'createdServices'
 get '/goods/createGood', :controller => 'goods', :action => 'createGood'
 

 
get '/services/createdServices', :controller => 'services', :action => 'createdServices'
 get '/goods/createdGood', :controller => 'goods', :action => 'createdGood'
 
 
  
 get '/createServiceBid', :controller => 'services', :action => 'createServiceBid'
 get '/createGoodBid', :controller => 'goods', :action => 'createGoodBid'
#get '/createGoodBid', :controller => 'goods', :action => 'createGoodBid' 

 #get'/goods/editgoodBids', :controller => 'goods', :action => 'editgoodBids'
 
 
 
 
 
 get '/services/searchService', :controller => 'services', :action => 'searchService'
 get '/searchgood', :controller => 'goods', :action => 'goodSearch'
 
 get '/goods/searchGoodResult', :controller => 'goods', :action => 'searchGoodResult'

 get'/services/searchServiceResult', :controller => 'services', :action => 'editSearchServices' 
 get '/goods/searchresult', :controller => 'goods', :action => 'searchResult'
 
  get '/searchService', :controller => 'services', :action => 'searchService'
  get'/services/searchService', :controller => 'services', :action => 'searchServiceResult'
  
 
  
 
 get '/services', :controller => 'services', :action => 'services'
 get '/goods/goods', :controller => 'goods', :action => 'goods'
  
   get'/services/editServices', :controller => 'services', :action => 'editServices'
  get'/goods/editGoods', :controller => 'goods', :action => 'editGoods'
  
   
get '/services/editedServices', :controller => 'services', :action => 'editedServices'
get '/goods/editedGoods', :controller => 'goods', :action => 'editedGoods'





 

 get'/goods/deleteGoods', :controller => 'goods', :action => 'deletedGoods'
get'/goods/deleteGoods', :controller => 'goods', :action => 'deleteGoods'
# get '/goods/BidGoodSuccessful', :controller => 'goods', :action => 'BidGoodSuccessful'
 

 get '/services/BidServiceSuccessful', :controller => 'services', :action => 'BidServiceSuccessful'
 get '/goods/bidGoodSuccessful', :controller => 'goods', :action => 'bidGoodSuccessful'
 
 get'/services/editBids', :controller => 'services', :action => 'editBids'
  get'/goods/editgBids', :controller => 'goods', :action => 'editgBids'
 
get'/services/deleteServices', :controller => 'services', :action => 'deleteServices'

 
  get '/services/deletedServices', :controller => 'services', :action => 'deletedServices'


 
get 'main', :controller => 'users', :action => 'main'

get 'createUser', :controller => 'users', :action => 'createUser'
get 'createdUser', :controller => 'users', :action => 'createdUser'
end
