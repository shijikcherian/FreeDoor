
/**
 * 
 */
package scribes.community.services;


import java.util.ArrayList;

import java.util.List;

import javax.ws.rs.core.Response;

import scribes.community.data.Bid;




import scribes.community.data.Good;



import scribes.community.restful.interfaces.IScribesGoodsService;
import scribes.community.DAO.ScribesDataManager;



public class ScribesGoodsService implements IScribesGoodsService {

	private ScribesDataManager sdm = new ScribesDataManager();
	
	
	/**
	 * 
	 * @return
	 */
	@Override
	public List<Good> getAllGoods() {
		List<Good> goods = new ArrayList<Good>();
		// TODO 
		goods = sdm.retrieveAllGoods();
		return goods;
	}
	@Override
	public Response createGood (Good good) {
		// TODO
		String goodId = sdm.createGood(good);
		System.out.println("Created good");	
		String result = "Good created: " + goodId + "-" + good;
		System.out.println("++++++++++++++++" + result + "++++++++++++++++");
		return Response.status(201).entity(result).build();    
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Good getGoodById (String goodId) { 
		Good good = null;		
		try {
			good = sdm.getGoodById(goodId);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return good;
	}
	
	
	/**
	 * 
	 */
	@Override
	public Response updateGood (String goodId, Good good) {
	//public Good updateGood (Good good) {
		good.setGoodId(goodId);
		sdm.updateGood(good);
		String result = "Good Updated : " + goodId;
		System.out.println("++++++++++++++++" + result + "++++++++++++++++");
		return Response.status(200).entity(result).build();
	}
	

	/**
	 * 
	 */
	@Override
	public Response deleteGood (String goodId) {
		sdm.deleteGood(goodId);
		String result = "Good Deleted : " + goodId;
		System.out.println("++++++++++++++++" + result + "++++++++++++++++");
		return Response.status(200).entity(result).build();
	}
	
	
	/*@Override
	public List<Bid> getBidsByGoodId (String goodId) {
		//List<Bid> bids = sdm.retrieveOffersByGoodId(goodId);
		return bids;
	}
	*/
	

	@Override
	public Response createBid (String goodId, Bid bid) {
		//bid.setGoodId(goodId);
		String bidId = sdm.createBid(bid);
		String result = "Bid created : " + bidId + "-" + bid;
		System.out.println("++++++++++++++++" + result + "++++++++++++++++");
		return Response.status(201).entity(result).build();
	}
	
	
	/**
	 * goods/search?name=...
	 * @param name
	 * @return
	 */
	@Override
	public List<Good> getGoodsBySearchCriteria(String name, String status, 
									String createrEmail, String ownerId) {
		List<Good> goods = sdm.getGoodsBySearchCriteria(name, status, createrEmail, ownerId);
		return goods;
	}
	@Override
	public List<Good> getGoodsByNameCriteria(String name) {
		// TODO Auto-generated method stub
		List<Good> goods = sdm.getGoodsByNameCriteria(name);
		
		return goods;
	}

}
